package com.csu.bio.controller.pub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class ExceptionController {

	@RequestMapping("/404")
	public String notFound(ModelMap model) {
		return "exception/404";
	}

	@RequestMapping("/error")
	public String error(ModelMap model) {
		return "exception/error";
	}
}