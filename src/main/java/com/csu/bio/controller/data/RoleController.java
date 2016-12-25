package com.csu.bio.controller.data;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csu.bio.controller.pub.XkaptchaController;
import com.csu.bio.object.model.Role;
import com.csu.bio.service.data.RoleService;

/**
 *
 * @author kayzhao
 * @version 2016年12月25日
 */

@RestController
@RequestMapping(value = "role")
public class RoleController {
	private final Logger logger = Logger.getLogger(XkaptchaController.class);

	@Autowired
	public RoleService rs;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Role getRole(@PathVariable("id") String id) {
		return rs.getRoleBy(id);
	}
}
