package com.sw.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@GetMapping("join")
	public void join(Model model)throws Exception {
		model.addAttribute("memberVO", new MemberVO());
	}

}
