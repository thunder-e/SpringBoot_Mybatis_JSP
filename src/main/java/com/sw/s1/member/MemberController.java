package com.sw.s1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void join(Model model)throws Exception {
		model.addAttribute("memberVO", new MemberVO());
	}
	
	@PostMapping("join")
	public String join(@Valid MemberVO memberVO, Errors bindingResult)throws Exception{
					// @Valid : 이 파라미터를 검증하겠다 //BindingResult : 에러(검증된 결과물)를 담는 인터페이스, 꼭 valid하는 파라미터 바로 뒤에 와야함, 중간에 Model이 들어가거나 하면 안됨 
		
		if(bindingResult.hasErrors()) {
			return "member/join";
		} 
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login()throws Exception {
	}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session)throws Exception {
		memberVO = memberService.getLogin(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
		}
		return "redirect:/";
	}
	
	
	
	
	

}
