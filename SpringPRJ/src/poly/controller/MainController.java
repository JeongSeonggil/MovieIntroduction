package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.service.IMovieService;

import javax.annotation.Resource;


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
			
}
