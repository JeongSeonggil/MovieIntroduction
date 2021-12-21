from urllib.request import urlopen
from bs4 import BeautifulSoup
from flask import Flask, request, render_template
from flask_restful import reqparse, abort, Api, Resource

app = Flask(__name__)
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

        for i in range(0, 10):
            code = movieList.findAll('div', 'thumb')[i].find('a')["href"][30:]
            title = "title : ", movieList.findAll('dt', 'tit')[i].find('a').getText()
            imgUrl = movieList.findAll('div', 'thumb')[i].find('img')['src']
            with urlopen(imgUrl) as f:
                with open("../SpringPRJ/WebContent/resources/assets/movieImg/" + str(code) + ".jpg", "wb") as h:
                    img = f.read()
                    h.write(img)
        f.close()
        h.close()

        return "1"

    except Exception as e:
        return {'error': str(e)}


@app.route('/crawlingComments')
def crawlingComments():
    code = request.args.get("code", "code")  # code 값을 이용하여 영화 댓글 조회
    try:
        review_list = []
        for page in range(1, 12):
            url = f'https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code={code}&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page={page}'
            html = urlopen(url)
            soup = BeautifulSoup(html, 'html.parser')
            for i in range(10):
                review = soup.find('span', {'id': f'_filtered_ment_{i}'})
                review = review.get_text().strip()
                review_list.append(review)
        result = "".join(review_list)  # 문자열로 변환

        return result

    except Exception as e:
        return {'error': str(e)}


if __name__ == '__main__':
    app.run()
