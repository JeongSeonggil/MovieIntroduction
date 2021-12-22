from urllib.request import urlopen
from bs4 import BeautifulSoup
from flask import Flask, jsonify
from flask_restful import reqparse, abort, Api, Resource
from datetime import datetime
app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

api = Api(app)


@app.route('/')
def hello_world():
    return "Hello"


@app.route('/crawlingMovieInfo')
def crawlingMovieInfo():
    try:
        url = "https://movie.naver.com/movie/running/current.naver"
        html = urlopen(url)
        soup = BeautifulSoup(html, 'html.parser')

        movieList = soup.find('ul', 'lst_detail_t1')

        result = {}
        movieInfo = {}
        movieInfoList = []

        for i in range(0, 10):
            code = movieList.findAll('div', 'thumb')[i].find('a')["href"][30:]
            comments = crawlingComments(code=code)
            title = movieList.findAll('dt', 'tit')[i].find('a').getText()
            imgUrl = movieList.findAll('div', 'thumb')[i].find('img')['src']

            movieInfo = {"code": code, "title": title, "comments": comments, "rating": i}
            movieInfoList.append(movieInfo)
            print(movieInfoList)
            with urlopen(imgUrl) as f:
                with open("../SpringPRJ/WebContent/resources/assets/movieImg/" + str(code) + ".jpg", "wb") as h:
                    img = f.read()
                    h.write(img)
        result["date"] = datetime.date.today().isoformat()
        result["movieInfo"] = movieInfoList
        f.close()
        h.close()

        return jsonify(result)

    except Exception as e:
        return {'error': str(e)}


def crawlingComments(code):
    try:
        review_list = []
        for page in range(1, 12):
            url = f'https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code={code}&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page={page}'
            html = urlopen(url)
            soup = BeautifulSoup(html, 'html.parser')
            for i in range(1, 10):
                review = soup.find('span', {'id': f'_filtered_ment_{i}'})
                review = review.get_text().strip()
                review_list.append(review)
        result = "".join(review_list)  # 문자열로 변환

        return result

    except Exception as e:
        return "No Comments"


if __name__ == '__main__':
    app.run()
    app.run(debug=False, host="127.0.0.1", port=5000)
