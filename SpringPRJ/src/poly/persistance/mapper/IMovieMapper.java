package poly.persistance.mapper;

import config.Mapper;
import poly.dto.MovieDTO;

import java.util.List;

@Mapper(value = "MovieMapper")
public interface IMovieMapper {
    // 중복 확인
    MovieDTO getMovieExists(MovieDTO pDTO) throws Exception;

    // 영화 등록
    int insertMovieInfo(MovieDTO pDTO) throws Exception;

    // 영화 정보 수정
    int modifyMovieInfo(MovieDTO pDTO) throws Exception;

    // 영화 조회
    List<MovieDTO> findMovieInfo() throws Exception;
}
