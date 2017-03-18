package com.csu.bio.controller.data;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csu.bio.controller.pub.XkaptchaController;
import com.csu.bio.frame.dao.CommonNoSqlDao;
import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.csu.bio.object.disease.Disease;
import com.csu.bio.object.po.PageList;
import com.csu.bio.object.po.QueryParams;
import com.csu.bio.service.data.DataService;

/**
 *
 * @author kayzhao
 * @version 2016年12月25日
 */
@RequestMapping(value = "/data")
@Controller
public class DownloadController {
	private final Logger logger = Logger.getLogger(XkaptchaController.class);

	@Autowired
	public DataService rs;

	@Autowired
	CommonNoSqlMongoFSDao cFsDao;

	@Autowired
	CommonNoSqlDao cDao;

	@RequestMapping(value = "/download/", method = RequestMethod.GET)
	public String queryIndex() {
		return "download/index";
	}
}
