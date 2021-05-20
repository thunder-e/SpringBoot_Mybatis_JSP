package com.sw.s1.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageLocaleConfig implements WebMvcConfigurer {
	
	// 언어를 구분
	@Bean
	public LocaleResolver localeResolver() {
		// session를 사용하여 설정
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.KOREAN);
		
		// cookie를 사용하여 설정 -- 더 편해
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
		cookieLocaleResolver.setCookieName("lang");
		
		return cookieLocaleResolver;
		//return localeResolver;
	}
	
	// Interceptor
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		// parameter를 받아서 언어 구분
		// url?lang=kr
		
		return localeChangeInterceptor;
	}
	
	// Interceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor())
				.addPathPatterns("/**");
	}
	
	
	
	
	
	
	
}
