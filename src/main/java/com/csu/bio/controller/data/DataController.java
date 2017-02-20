package com.csu.bio.controller.data;

import java.io.IOException;
import java.util.List;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.csu.bio.controller.pub.XkaptchaController;
import com.csu.bio.frame.dao.CommonNoSqlDao;
import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.csu.bio.object.model.*;
import com.csu.bio.object.po.Page;
import com.csu.bio.object.po.PageList;
import com.csu.bio.object.po.QueryParams;
import com.csu.bio.service.data.DataService;
import com.csu.bio.util.oper.GridfsUtil;
import com.mongodb.gridfs.GridFSDBFile;

/**
 *
 * @author kayzhao
 * @version 2016年12月25日
 */

@RestController
@RequestMapping(value = "/data")
public class DataController {
	private final Logger logger = Logger.getLogger(XkaptchaController.class);

	@Autowired
	public DataService rs;

	@Autowired
	CommonNoSqlMongoFSDao cFsDao;

	@Autowired
	CommonNoSqlDao cDao;

	@RequestMapping(value = "/disease/index", method = RequestMethod.GET)
	public ModelAndView getDiseases() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("disease/index");
		return mav;
	}

	@RequestMapping(value = "/disease/page", method = RequestMethod.GET)
	public PageList<Disease> getdisease(QueryParams queryParams) {
		PageList<Disease> page = new PageList<Disease>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null)
			queryParams.setSearch("UMLS_CUI");
		List<Disease> diseases = rs.getListByPage(Disease.class, queryParams);
		Long total = rs.getListCount(Disease.class, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(diseases);
		return page;
	}

	@RequestMapping(value = "/disease/{id}", method = RequestMethod.GET)
	public Object getDiseaseByID(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView();
		Disease disease = rs.getDataByID(id, Disease.class);
		mav.setViewName("disease/disease_info");
		mav.addObject("disease", disease);
		return mav;
	}

	@RequestMapping(value = "drugs", method = RequestMethod.GET)
	public List<RelCount> getDrugs() {
		// return cDao.findListGroupBy("Disease-Drug");
		return null;
		// return rs.getListByAssociationType("Disease-Drug", Drug.class);
	}

	@RequestMapping(value = "/drugs/{disease_id}", method = RequestMethod.GET)
	public List<Drug> getDrugByDiseaseID(@PathVariable("disease_id") String disease_id) {
		return rs.getAssociationListByDisease(disease_id, Drug.class);
	}

	@RequestMapping(value = "/chemical/{id}", method = RequestMethod.GET)
	public Object getChemicalByID(@PathVariable("id") String id) {
		return rs.getDataByID(id, Chemical.class);
	}

	@RequestMapping(value = "/synonym/{keyword}", method = RequestMethod.GET)
	public Object getDataByName(@PathVariable("keyword") String keyword) {
		return rs.getDataByID(keyword, Disease.class);
	}
}
