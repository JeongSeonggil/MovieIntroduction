package poly.service;

import java.util.Map;

public interface IMovieService {
    Map<String, Object> getMovieInfoJSON(String rURL) throws Exception;
}
