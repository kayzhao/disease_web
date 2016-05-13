package com.csu.controller;

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
public class Controllers {

	private final Logger logger = Logger.getLogger(Controllers.class);
	public static final String BASE_PATH = ContextLoader
			.getCurrentWebApplicationContext().getServletContext()
			.getRealPath("/");

	@RequestMapping("/index")
	public String indexInit(ModelMap model) {
		logger.info("start index page");
		return "index";
	}

}
