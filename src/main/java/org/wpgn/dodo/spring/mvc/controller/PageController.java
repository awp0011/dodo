package org.wpgn.dodo.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springMVC")
public class PageController {



	@RequestMapping("/index.action")
	public String index() {
		return "index";
	}
	@RequestMapping("/welcome.action")
	public String login() {
		return "welcome";
	}
	
	
}
