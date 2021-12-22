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
import poly.service.IMovieService;
import poly.util.CmmUtil;


@Service(value = "MovieService")
public class MovieService implements IMovieService {
    @Resource(name = "MovieMapper")
    private IMovieMapper movieMapper;

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public Map<String,Object> getMovieInfoJSON(String rURL) throws Exception {
        log.info(this.getClass().getName() + ".getMovieInfoJSON start!");

        Map<String, Object> rMap = new HashMap<String, Object>();
        // json 결과 받아오기
        String json = this.getUrlForJSON(CmmUtil.nvl(rURL));

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(json);
        JSONObject jsonObject = (JSONObject) obj;
        // String으로 가져오기
        // String reqYYYYMM = CmmUtil.nvl((String) jsonObject.get("reqYYYYMM"));
        JSONArray movieInfoArr = (JSONArray) jsonObject.get("movieInfo");
        log.info("movieInfoArr : " + movieInfoArr);


        List<MovieDTO> rList = new ArrayList<MovieDTO>();
        MovieDTO rDTO = null;
        for (int i = 0; i < movieInfoArr.size(); i++) {
            JsonObject result = (JsonObject) movieInfoArr.get(i);

        }

        return rMap;
    }

    private String getUrlForJSON(String callUrl) {

        log.info(this.getClass().getName() + ".getUrlForJSON start!");

        log.info("Requeted URL:" + callUrl);

        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;

        String json = "";

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
}
