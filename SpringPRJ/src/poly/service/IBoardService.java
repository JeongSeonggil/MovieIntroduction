package poly.service;

import poly.dto.BoardDTO;

import java.util.List;

public interface IBoardService {

    // 게시글 조회
    List<BoardDTO> selectBoard() throws Exception;

    // 글 추가
    int newPost(BoardDTO pDTO) throws Exception;

	
}
