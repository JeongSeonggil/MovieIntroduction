package poly.persistance.mapper;

import config.Mapper;
import poly.dto.MemberDTO;

@Mapper("MemberMapper")

public interface IMemberMapper {

        // 회원가입
        int insertMember(MemberDTO pDTO) throws Exception;

        //로그인
        MemberDTO loginMember(MemberDTO pDTO) throws Exception;


}
