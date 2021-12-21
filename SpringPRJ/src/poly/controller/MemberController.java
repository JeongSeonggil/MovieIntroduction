package poly.controller;

import org.apache.ibatis.jdbc.Null;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.dto.MemberDTO;
import poly.service.IMemberService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class MemberController {

	private Logger log = Logger.getLogger(this.getClass());


	@Resource(name = "MemberService")
	private IMemberService memberService;

	@RequestMapping(value = "/regForm")
	public String regForm() {
		log.info("regFrom Start!");

		log.info("regFrom End!");

		return "Member/regForm";
	}

	//회원가입
	@RequestMapping(value = "/insertMember")
	public String insertMember(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {
		log.info("insertMember start");
		String email = CmmUtil.nvl(EncryptUtil.encAES128CBC(request.getParameter("email")));
		String password = CmmUtil.nvl(EncryptUtil.encHashSHA256(request.getParameter("password")));
		String member_name = CmmUtil.nvl(request.getParameter("member_name"));
		String member_nic = CmmUtil.nvl(request.getParameter("member_nic"));


		// session.setAttribute("id", uDTO.getID());

		log.info("email : " + email);
		log.info("password : " + password);
		log.info("member_name : " + member_name);
		log.info("member_nic : " + member_nic);
		MemberDTO pDTO = new MemberDTO();

		pDTO.setEMAIL(email);
		pDTO.setMEMBER_NAME(member_name);
		pDTO.setMEMBER_NIC(member_nic);
		pDTO.setMEMBER_PW(password);

		log.info("res start");
		int res = memberService.insertMember(pDTO);

//		MemberDTO rDTO = memberService.insertMember(pDTO);
		log.info("res : " + res);

		String msg = "";
		String url = "";
		if (res > 0) {
			msg = "회원가입 성공";
		} else {
			msg = "회원정보를 확인 후 가입을 진행해 주세요.";
		}

		url = "index.do";

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		pDTO = null;

		log.info("insertUser END!");

		return "/redirect";


	}

	// 로그인 / Main page 이동
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {
		String email = CmmUtil.nvl(EncryptUtil.encAES128CBC(request.getParameter("email"))); // email 저장
		String password = CmmUtil.nvl(EncryptUtil.encHashSHA256(request.getParameter("password"))); // password 저장

		log.info("email : " + email);
		log.info("password : " + password);

		MemberDTO pDTO = new MemberDTO();

		pDTO.setEMAIL(email);
		pDTO.setMEMBER_PW(password);

		log.info("pDTO.email : " + pDTO.getEMAIL());
		log.info("pDTO.getMember_pw : " + pDTO.getMEMBER_PW());

		log.info("login Start!");
		String msg = "";
		String url = "";

		MemberDTO res = memberService.loginMember(pDTO);
		log.info("res.getName : " + res.getMEMBER_NAME());
		log.info("res.getMemberNic : " + res.getMEMBER_NIC());

		if (res != null) {
			msg = "로그인 성공";
			url = "lounge.do";
			session.setAttribute("SS_MEMBER_NAME", res.getMEMBER_NAME());
			session.setAttribute("SS_MEMBER_NIC", res.getMEMBER_NIC());


		} else {
			msg = "로그인 실패";
			url = "index.do";
		}



		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "/redirect";

	}

	@RequestMapping(name = "/lounge")
	public String lounge(){
		return "/lounge";
	}

}
