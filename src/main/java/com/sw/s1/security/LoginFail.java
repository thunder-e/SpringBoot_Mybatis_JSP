package com.sw.s1.security;

import java.io.IOException;

import javax.security.auth.login.CredentialExpiredException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

//로그인 실패 했을 때 실행하는 객체
@Component
public class LoginFail implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Login Fail Handler");
		System.out.println(exception.getClass());
		
		String errorClass = exception.getClass().toString().substring(exception.getClass().toString().lastIndexOf(".")+1);
		
		System.out.println(errorClass);
		
		String message="";
		
		
		
		switch(errorClass) {
		case "InternalAuthenticationServiceException":
			message="ID가 존재하지 않음";
			break;
		case "BadCredentialsException":
			message="비밀번호가 일치하지 않습니다";
			break;
		case "AuthenticationCredentialsNotFoundException":
			message="인증이 안됌";
			break;
		case "LockedException":
			message="계정 잠김";
			break;
		case "DisabledException":
			message="휴면계정";
			break;
		case "AccountExpiredException":
			message="계정의 유효기간이 만료";
			break;
		case "CredentialExpiredException":
			message="비밀번호의 유효기간이 만료";
			break;
		default:
			message="다시 시도";
			break;
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("/member/memberLogin").forward(request, response);
		
	}
	
	
}
