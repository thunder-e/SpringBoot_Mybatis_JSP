package com.sw.s1.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  =====================================
 * 	           JSP Project 
 *  =====================================
 **/

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "JSP Project");
		return "index"; //뷰로 찾아가는게 아니라 json으로 바뀌어서 데이터 전달
	}
	
	
}
