package com.csu.bio.controller.data;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csu.bio.controller.pub.XkaptchaController;
import com.csu.bio.object.model.*;
import com.csu.bio.service.data.DataService;

/**
 *
 * @author kayzhao
 * @version 2016年12月25日
 */

@RestController
@RequestMapping(value = "data")
public class DataController {
	private final Logger logger = Logger.getLogger(XkaptchaController.class);

	@Autowired
	public DataService rs;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Object getData(@PathVariable("id") String id) {
		return rs.getDataByID(id, KEGG.class);
	}
}
