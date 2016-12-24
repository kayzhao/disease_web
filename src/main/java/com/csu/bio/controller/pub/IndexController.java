package com.csu.bio.controller.pub;

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

	@RequestMapping("/index")
	public String indexInit(ModelMap model) {
		return "index";
	}
}
