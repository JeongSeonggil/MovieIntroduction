package poly.service;

import poly.dto.MemberDTO;

public interface IMemberService {
    
    // 회원가입
    int insertMember(MemberDTO pDTO) throws Exception;


    MemberDTO loginMember(MemberDTO pDTO) throws Exception;
	
}
