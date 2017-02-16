package com.csu.bio.controller.pub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kayzhao
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(ModelMap model) {
		return "index";
	}

	@RequestMapping("/contact")
	public String about(ModelMap model) {
		return "contact";
	}

	@RequestMapping("/readme")
	public String faq(ModelMap model) {
		return "readme";
	}

	@RequestMapping("/api")
	public String api(ModelMap model) {
		return "api";
	}
}
