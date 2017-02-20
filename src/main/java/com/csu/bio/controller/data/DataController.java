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

	@RequestMapping(value = "/diseases", method = RequestMethod.GET)
	public ModelAndView diseaseIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("disease/index");
		return mav;
	}

	@RequestMapping(value = "/diseases/page", method = RequestMethod.GET)
	public PageList<Disease> getdisease(QueryParams queryParams) {
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
		List<Disease> diseases = rs.getList(Disease.class, queryParams);
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
		mav.setViewName("disease/info");
		mav.addObject("disease", disease);
		return mav;
	}

	@RequestMapping(value = "/disease/{id}/drugs", method = RequestMethod.GET)
	public PageList<Drug> getDrugByDiseaseID(@PathVariable("id") String disease_id, QueryParams queryParams) {
		PageList<Drug> page = new PageList<Drug>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null || queryParams.getSort().length() == 0)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null || queryParams.getSearch().length() == 0)
			queryParams.setSearch(disease_id);
		List<Drug> list = rs.getAssociationListByDisease(disease_id, Drug.class, queryParams);
		Long total = rs.getAssociationListCountByDisease(disease_id, Drug.class, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(list);
		return page;
	}

	@RequestMapping(value = "/disease/{id}/mirnas", method = RequestMethod.GET)
	public PageList<MiRNA> getMiRNAByDiseaseID(@PathVariable("id") String disease_id, QueryParams queryParams) {
		PageList<MiRNA> page = new PageList<MiRNA>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null || queryParams.getSort().length() == 0)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null || queryParams.getSearch().length() == 0)
			queryParams.setSearch(disease_id);
		List<MiRNA> list = rs.getAssociationListByDisease(disease_id, MiRNA.class, queryParams);
		Long total = rs.getAssociationListCountByDisease(disease_id, MiRNA.class, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(list);
		return page;
	}

	@RequestMapping(value = "/disease/{id}/genes", method = RequestMethod.GET)
	public PageList<Gene> getGeneByDiseaseID(@PathVariable("id") String disease_id, QueryParams queryParams) {
		PageList<Gene> page = new PageList<Gene>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null || queryParams.getSort().length() == 0)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null || queryParams.getSearch().length() == 0)
			queryParams.setSearch(disease_id);
		List<Gene> list = rs.getAssociationListByDisease(disease_id, Gene.class, queryParams);
		Long total = rs.getAssociationListCountByDisease(disease_id, Gene.class, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(list);
		return page;
	}

	@RequestMapping(value = "/disease/{id}/lncrnas", method = RequestMethod.GET)
	public PageList<LncRNA> getLncRNAByDiseaseID(@PathVariable("id") String disease_id, QueryParams queryParams) {
		PageList<LncRNA> page = new PageList<LncRNA>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null || queryParams.getSort().length() == 0)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null || queryParams.getSearch().length() == 0)
			queryParams.setSearch(disease_id);
		List<LncRNA> list = rs.getAssociationListByDisease(disease_id, LncRNA.class, queryParams);
		Long total = rs.getAssociationListCountByDisease(disease_id, LncRNA.class, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(list);
		return page;
	}

	@RequestMapping(value = "/disease/{id}/snps", method = RequestMethod.GET)
	public PageList<SNP> getSNPByDiseaseID(@PathVariable("id") String disease_id, QueryParams queryParams) {
		PageList<SNP> page = new PageList<SNP>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null || queryParams.getSort().length() == 0)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null || queryParams.getSearch().length() == 0)
			queryParams.setSearch(disease_id);
		List<SNP> list = rs.getAssociationListByDisease(disease_id, SNP.class, queryParams);
		Long total = rs.getAssociationListCountByDisease(disease_id, SNP.class, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(list);
		return page;
	}

	@RequestMapping(value = "/disease/{id}/gos", method = RequestMethod.GET)
	public PageList<GO> getGOByDiseaseID(@PathVariable("id") String disease_id, QueryParams queryParams) {
		PageList<GO> page = new PageList<GO>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null || queryParams.getSort().length() == 0)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null || queryParams.getSearch().length() == 0)
			queryParams.setSearch(disease_id);
		List<GO> list = rs.getAssociationListByDisease(disease_id, GO.class, queryParams);
		Long total = rs.getAssociationListCountByDisease(disease_id, GO.class, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(list);
		return page;
	}

	@RequestMapping(value = "/disease/{id}/chemicals", method = RequestMethod.GET)
	public PageList<Chemical> getChemicalByDiseaseID(@PathVariable("id") String disease_id, QueryParams queryParams) {
		PageList<Chemical> page = new PageList<Chemical>();
		if (queryParams == null) {
			queryParams = new QueryParams();
			queryParams.setLimit(10);
			queryParams.setOffset(0);
			queryParams.setOrder("asc");
		}
		if (queryParams.getSort() == null || queryParams.getSort().length() == 0)
			queryParams.setSort("id");
		if (queryParams.getSearch() == null || queryParams.getSearch().length() == 0)
			queryParams.setSearch(disease_id);
		List<Chemical> list = rs.getAssociationListByDisease(disease_id, Chemical.class, queryParams);
		Long total = rs.getAssociationListCountByDisease(disease_id, Chemical.class, queryParams);
		page.setParams(queryParams);
		page.setTotal(total);
		page.setRows(list);
		return page;
	}

	@RequestMapping(value = "/synonym/{keyword}", method = RequestMethod.GET)
	public Object getDataByName(@PathVariable("keyword") String keyword) {
		return rs.getDataByID(keyword, Disease.class);
	}
}
