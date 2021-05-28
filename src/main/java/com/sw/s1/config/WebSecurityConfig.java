package com.sw.s1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sw.s1.security.LoginFail;

@Configuration // 설정파일입니다
@EnableWebSecurity //security를 활성화할게요
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	//비밀번호 암호화해주는 클래스 객체 만들어주기
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
			// Security를 무시(제외) - 정적파일들
		web.ignoring()
		   .antMatchers("/resources/**")
		   .antMatchers("/images/**")
		   .antMatchers("/css/**")
		   .antMatchers("/js/**")
		   .antMatchers("/vendor/**")
		   .antMatchers("/favicon/**")
		   ;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// URL에 따른 로그인, 권한 설정
		http
			//권한 에러 발생(403) 처리
			//사용하지 않으면 기본 재공 에러처리 방법 사용(error-Handling 브랜치 참고)
			.exceptionHandling() 
					// 둘 중 하나 쓰면 됨
//				  .accessDeniedPage("/member/error") // error page URL 경로
//				  .accessDeniedHandler(new SecurityException()) // error 처리하는 class 선언(만들어야함) 
				  .and()
			.cors().and()
			//csrf : 어디서 보내는 지 확인할 수 있게 폼을 보낼때 일련번호를 같이 보냄 
			.csrf().disable() //csrf란 토큰을 사용하지 않겠다
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/notice/list","/notice/select").permitAll()
				.antMatchers("/notice/**").hasRole("ADMIN")
				.antMatchers("/qna/list").permitAll()
				.antMatchers("/qna/**").hasAnyRole("ADMIN", "MEMBER")
				.antMatchers("/member/join").permitAll()
				.antMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
				.anyRequest().authenticated() // 그외 없는것은 로그인 필요
				.and() // 한 항목을 알려줌*
			.formLogin()
				//username 파라미터를 다른이름으로 설정(컬럼명) 
				.usernameParameter("email")
				//password 파라미터를 다른이름으로 설정(컬럼명) 
				.passwordParameter("pw")
				// 로그인페이지를 따로 만들지 않아도 기본 내장된 폼으로 이동
				// 개발자가 만든 로그인폼을 사용하려면 다음과 같이 작성
				.loginPage("/member/login")
				//로그인이 성공하면 이쪽으로 가세요
				.defaultSuccessUrl("/member/memberLoginResult")
				//로그인 실패 처리
//				.failureUrl("/member/loginFail")	// 다시 요청하면 파라미터 없어지니까 login.html의 param.error가 나오지 않음
				.failureHandler(new LoginFail()) // 세밀한 작업할 때 클래스 만들어서 객체
				.permitAll()
				.and()
			.logout()
				//마찬가지로 컨트롤러에 할 것 X 자동으로 해줌
				.logoutUrl("/member/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
				;
	
	}
	
	
	
}
