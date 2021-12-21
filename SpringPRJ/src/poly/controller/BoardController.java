package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import poly.dto.BoardDTO;
import poly.service.IBoardService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BoardController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "BoardService")
	private IBoardService boardService;

	@RequestMapping(value = "/Board/boardList")
	public String selectBoard(ModelMap model) throws Exception {
		log.info("boardList start!!");
		List<BoardDTO> rList = boardService.selectBoard();
		if (rList == null) {
			rList = new ArrayList<>();
		}
		model.addAttribute("rList", rList);
		log.info("rList : " + rList);
		log.info("boardList end");
		return "/Board/boardList";

	}

	@RequestMapping(value = "Board/newPost")
	public String newPost(){
		log.info("newPost start!!");

		log.info("newPost end");

		return "/Board/newPost";
	}

	@RequestMapping(value = "Board/doPost")
	public String newPost(HttpServletRequest request, ModelMap model) throws Exception {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String nic = "admin"; // 세션에서 받아오기
		log.info("title :" + title);
		log.info("contents : " + contents);
		log.info("nic : " + nic);
		BoardDTO pDTO = new BoardDTO();
		pDTO.setTITLE(title);
		pDTO.setCONTENTS(contents);
		pDTO.setUSER_NIC(nic);
		log.info("pDTO(title) : " + pDTO.getTITLE());
		log.info("pDTO(contents) : " + pDTO.getTITLE());

		int res = boardService.newPost(pDTO);
		pDTO = null;
		String msg;
		String url = "/Board/boardList.do";
		if (res > 0){
			msg = "등록에 성공했습니다.";
		}
		else{
			msg = "등록에 실패했습니다.";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "/redirect";

	}
}
