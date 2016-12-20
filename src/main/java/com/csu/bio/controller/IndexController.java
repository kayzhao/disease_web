package com.csu.bio.controller;

import org.apache.log4j.Logger;
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

	private final Logger logger = Logger.getLogger(IndexController.class);
	public static final String BASE_PATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	@RequestMapping("/index")
	public String indexInit(ModelMap model) {
		logger.info("start index page");
		return "index";
	}
}
