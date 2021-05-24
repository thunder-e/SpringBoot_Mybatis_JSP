package com.sw.s1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	//회원가입
	public int SetJoin(MemberVO memberVO)throws Exception;
	//로그인
	public MemberVO getLogin(MemberVO memberVO)throws Exception;
	//ID 중복확인
	public MemberVO getUsername(MemberVO memberVO)throws Exception;

}
