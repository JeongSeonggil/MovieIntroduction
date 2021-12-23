package poly.service;

import poly.dto.MovieDTO;

import java.util.List;
import java.util.Map;

public interface IMovieService {
    int insertMovieInfo(String rURL) throws Exception;

    List<MovieDTO> findMovieInfo() throws Exception;
}
