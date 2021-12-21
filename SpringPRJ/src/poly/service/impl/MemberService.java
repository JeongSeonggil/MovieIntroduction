package poly.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import poly.dto.MemberDTO;
import poly.persistance.mapper.IDummyMapper;
import poly.persistance.mapper.IMemberMapper;
import poly.service.IMemberService;

import javax.annotation.Resource;

@Service("MemberService")
public class MemberService implements IMemberService{
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="MemberMapper")
	private IMemberMapper memberMapper;

	// 회원가입
	@Override
	public int insertMember(MemberDTO pDTO) throws Exception{
		return memberMapper.insertMember(pDTO);
	}

	//로그인
	@Override
	public MemberDTO loginMember(MemberDTO pDTO) throws Exception{
		return memberMapper.loginMember(pDTO);
	}

}
