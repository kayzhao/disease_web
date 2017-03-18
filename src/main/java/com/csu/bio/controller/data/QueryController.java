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
public class QueryController {
	private final Logger logger = Logger.getLogger(XkaptchaController.class);

	@Autowired
	public DataService rs;

	@Autowired
	CommonNoSqlMongoFSDao cFsDao;

	@Autowired
	CommonNoSqlDao cDao;

	@RequestMapping(value = "/query/", method = RequestMethod.GET)
	public String queryIndex() {
		return "query/index";
	}

	@RequestMapping(value = "/query/result", method = RequestMethod.GET)
	public String queryResult(ModelMap model, RedirectAttributes attributes) {
		// model.addAttribute("type",
		// attributes.getFlashAttributes().get(("type")));
		// model.addAttribute("words",
		// attributes.getFlashAttributes().get(("words")));
		return "query/show";
	}

	@RequestMapping(value = "/query/keywords", method = RequestMethod.POST)
	public String getdisease(ModelMap model, String type, String words, RedirectAttributes attributes) {
		if (type == null || words == null || words.length() == 0) {
			attributes.addFlashAttribute("errorInfo", "Error Search Text or Type");
			return "redirect:/data//query/";
		} else {
			attributes.addFlashAttribute("type", type);
			attributes.addFlashAttribute("words", words);
			return "redirect:/data/query/result?type=" + type + "&words=" + words;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/query/page", method = RequestMethod.GET)
	public PageList<Disease> getdisease(HttpServletRequest request, QueryParams queryParams) {
		String type = request.getParameter("type");
		PageList<Disease> page = new PageList<Disease>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null || queryParams.getSort().length() == 0)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null || queryParams.getSearch().length() == 0)
			queryParams.setSearch("UMLS_CUI");

		List<Disease> diseases = rs.getList(Disease.class, type, queryParams);
		Long total = rs.getListCount(Disease.class, type, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(diseases);
		return page;
	}
}
