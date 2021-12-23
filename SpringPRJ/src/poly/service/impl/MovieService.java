package poly.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import poly.dto.MovieDTO;
import poly.persistance.mapper.IMovieMapper;
import poly.persistance.mapper.INlpMapper;
import poly.service.IMovieService;
import poly.service.INlpService;
import poly.util.CmmUtil;


@Service(value = "MovieService")
public class MovieService implements IMovieService {
    @Resource(name = "MovieMapper")
    private IMovieMapper movieMapper;

    @Resource(name = "NlpService")
    private INlpService nlpService;

    private Logger log = Logger.getLogger(this.getClass());

    // Url을 사용하여 JSON 형태로 데이터 받아오기
    private String getUrlForJSON(String callUrl) {
        log.info(this.getClass().getName() + ".getUrlForJSON start!");

        log.info("Requeted URL:" + callUrl);

        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;

        // json 결과값이 저장되는 변수
        String json = "";

        // SSL 적용된 사이트일 경우, 데이터 증명을 위해 사용
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        try {

            // 웹 사이트 접속을 위한 URL 파싱
            URL url = new URL(callUrl);

            // 접속
            urlConn = url.openConnection();

            // 접속하면, 응답을 60초(60 * 1000ms)동안 가다림
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);

            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.forName("UTF-8"));

                BufferedReader bufferedReader = new BufferedReader(in);

                // 주어진 문자 입력 스트림 inputStream에 대해 기본 크기의 버퍼를 갖는 객체를 생성.
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception URL:" + callUrl, e);
        }

        json = sb.toString(); // json 결과 저장
        log.info("JSON result : " + json);

        log.info(this.getClass().getName() + ".getUrlForJSON End!");

        return json;

    }

    @Override // 영화 정보 저장 / 수정 (이미 있을 경우 최신 정보로 수정)
    public int insertMovieInfo(String rURL) throws Exception {
        log.info(this.getClass().getName() + ".getMovieInfoJSON start!");
        String json = this.getUrlForJSON(CmmUtil.nvl(rURL));

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(json);
        JSONObject jsonObject = (JSONObject) obj;

        // String으로 가져오기
        // String reqYYYYMM = CmmUtil.nvl((String) jsonObject.get("reqYYYYMM"));

        List<Object> movieInfoArr = (JSONArray) jsonObject.get("movieInfo");

        String date = CmmUtil.nvl((String) jsonObject.get("date"));
        log.info("date : " + date);
        log.info("movieInfoArr : " + jsonObject.get("movieInfo"));

        MovieDTO pDTO = new MovieDTO();
        int res = 0;

        for (int i = 0; i < movieInfoArr.size(); i++) {
            Map<String, Object> result = (Map<String, Object>) movieInfoArr.get(i);
            log.info("title :: " + CmmUtil.nvl(result.get("title").toString()));
            log.info("code :: " + CmmUtil.nvl(result.get("code").toString()));
            log.info("comments ::" + CmmUtil.nvl(result.get("comments").toString()));
            log.info("movie_type ::" + CmmUtil.nvl(result.get("movie_type").toString()));

            String movie_code = CmmUtil.nvl(result.get("code").toString());
            String movie_title = CmmUtil.nvl(result.get("title").toString());
            String movie_comment = CmmUtil.nvl(result.get("comments").toString());
            String movie_type = CmmUtil.nvl(result.get("movie_type").toString());

            // 오피니언 마이닝
            int point = nlpService.preProcessWordAnalysisForMind(movie_comment);
            String movie_analysis = Integer.toString(point);

            pDTO.setMovie_analysis(movie_analysis);
            pDTO.setMovie_code(movie_code);
            pDTO.setMovie_title(movie_title);
            pDTO.setMovie_comment(movie_comment);
            pDTO.setMovie_type(movie_type);
            // 중복 확인
            MovieDTO checkDTO = movieMapper.getMovieExists(pDTO);
            if (checkDTO == null) {
                checkDTO = new MovieDTO();
            }

            if (CmmUtil.nvl(checkDTO.getExists_yn()).equals("Y")) {
                log.info("modifyMovieInfo");
                res += movieMapper.modifyMovieInfo(pDTO);

            }else{
                log.info("insertMovieInfo");
                res += movieMapper.insertMovieInfo(pDTO);
            }

            log.info("[" + i + "] res : " + res);
        }
        res = res / movieInfoArr.size();

        return res;
    }

    @Override // index page 실행 시 영화 정보를 DB에서 가져오는 기능
    public List<MovieDTO> findMovieInfo() throws Exception {
        return movieMapper.findMovieInfo();
    }
}
