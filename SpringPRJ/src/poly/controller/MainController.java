package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.dto.MovieDTO;
import poly.service.IMovieService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "MovieService")
	private IMovieService movieService;

	@RequestMapping(value = "index")
	public String Index(HttpServletRequest request, ModelMap model) throws Exception {
		log.info(this.getClass().getName());

		try{
			List<MovieDTO> rList = movieService.findMovieInfo();
			if (rList == null) {
				rList = new ArrayList<MovieDTO>();
				log.info("영화 정보 없음");
			}
			log.info("영화 정보 불러오기 성공");
			model.addAttribute("rList", rList);
		} catch (Exception e) {
			log.info("영화 정보 불러오기를 실패하였습니다 :" + e.toString());
			log.info(e.toString());
			e.printStackTrace();
		}

		return "/index";
	}



	@RequestMapping(value = "crawlingMovieInfo")
	public String Test(HttpServletRequest request, ModelMap model) throws Exception {
		String url = "http://127.0.0.1:5000/crawlingMovieInfo";
		String msg = "";
		String check_code = request.getParameter("check_code"); // 코드 없이 크롤링 실행 불가 session으로 변경
		if (check_code.equals("1108")){
			int res = movieService.insertMovieInfo(url);

			log.info(this.getClass().getName() + " res : " + res);
			if (res == 1) {
				msg = "영화 정보 저장 성공";
			} else {
				msg = "영화 정보 저장 실패";
			}
		}
		url = "/index.do";
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);


		return "/redirect";
	}

			
}
