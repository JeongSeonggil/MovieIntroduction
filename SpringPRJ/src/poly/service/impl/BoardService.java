package poly.service.impl;

import org.springframework.stereotype.Service;
import poly.dto.BoardDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.persistance.mapper.IDummyMapper;
import poly.service.IBoardService;
import poly.service.IDummyService;

import javax.annotation.Resource;
import java.util.List;

@Service("BoardService")
public class BoardService implements IBoardService{

	@Resource(name = "BoardMapper")
	private IBoardMapper boardMapper;

	// 게시글 리스트 조회
	@Override
	public List<BoardDTO >selectBoard() throws Exception{
		return boardMapper.selectBoard();
	}

	// 글 추가
	@Override
	public int newPost(BoardDTO pDTO) throws Exception {
		return boardMapper.newPost(pDTO);
	}

}
