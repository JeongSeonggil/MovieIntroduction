package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import poly.service.IMovieService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MainController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "MovieService")
	private IMovieService movieService;

	@RequestMapping(value="index")
	public String Index() {
		log.info(this.getClass());
		
		return "/index";
	}


	@RequestMapping(value = "crawlingMovieInfo")
	public String Test(HttpServletRequest request, ModelMap model) throws Exception {
		String url = "http://127.0.0.1:5000/crawlingMovieInfo";
		int res = movieService.insertMovieInfo(url);
		String msg = "";
		log.info(this.getClass().getName() + " res : " + res);
		if (res == 1) {
			msg = "영화 정보 저장 성공";
		} else {
			msg = "영화 정보 저장 실패";
		}
		url = "/index.do";
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);


		return "/redirect";
	}
			
}
