package poly.persistance.mapper;

import config.Mapper;
import poly.dto.BoardDTO;
import poly.dto.DummyDTO;

import java.util.List;

@Mapper("BoardMapper")
public interface IBoardMapper {

	//게시판 리스트
	List<BoardDTO> selectBoard() throws Exception;

	//글 추가
	int newPost(BoardDTO pDTO) throws Exception;

}
