package com.csu.bio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;

/**
 * @author kayzhao
 *
 */
@Controller
public class IndexController {

//	public static final String BASE_PATH = ContextLoader
//			.getCurrentWebApplicationContext().getServletContext()
//			.getRealPath("/");

	@RequestMapping("/index")
	public String indexInit(ModelMap model) {
		return "index";
	}
}
