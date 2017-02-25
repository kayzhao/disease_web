package com.csu.bio.controller.data;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.csu.bio.controller.pub.XkaptchaController;
import com.csu.bio.frame.dao.CommonNoSqlDao;
import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.csu.bio.object.disease.Disease;
import com.csu.bio.object.model.*;
import com.csu.bio.object.po.PageList;
import com.csu.bio.object.po.QueryParams;
import com.csu.bio.service.data.DataService;

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

	@RequestMapping(value = "/drug/{id}", method = RequestMethod.POST)
	public Drug getDrugByIDPOST(@PathVariable("id") String id) {
		Drug drug = rs.getDataByID(id, Drug.class);
		drug.setData_type("drug");
		return drug;
	}

	@RequestMapping(value = "/gene/{id}", method = RequestMethod.POST)
	public Gene getGeneByIDPOST(@PathVariable("id") String id) {
		Gene gene = rs.getDataByID(id, Gene.class);
		gene.setData_type("gene");
		return gene;
	}

	@RequestMapping(value = "/lncrna/{id}", method = RequestMethod.POST)
	public LncRNA getLncRNAByIDPOST(@PathVariable("id") String id) {
		LncRNA lncrna = rs.getDataByID(id, LncRNA.class);
		lncrna.setData_type("lncrna");
		return lncrna;
	}

	@RequestMapping(value = "/mirna/{id}", method = RequestMethod.POST)
	public MiRNA getMiRNAByIDPOST(@PathVariable("id") String id) {
		MiRNA mirna = rs.getDataByID(id, MiRNA.class);
		mirna.setData_type("mirna");
		return mirna;
	}

	@RequestMapping(value = "/snp/{id}", method = RequestMethod.POST)
	public SNP getSNPByIDPOST(@PathVariable("id") String id) {
		SNP snp = rs.getDataByID(id, SNP.class);
		snp.setData_type("snp");
		return snp;
	}

	@RequestMapping(value = "/go/{id}", method = RequestMethod.POST)
	public GO getGOByIDPOST(@PathVariable("id") String id) {
		GO go = rs.getDataByID(id, GO.class);
		go.setData_type("go");
		return go;
	}

	@RequestMapping(value = "/chemical/{id}", method = RequestMethod.POST)
	public Chemical getChemicalByIDPOST(@PathVariable("id") String id) {
		Chemical chemical = rs.getDataByID(id, Chemical.class);
		chemical.setData_type("chemical");
		return chemical;
	}

	@RequestMapping(value = "/disease/{id}", method = RequestMethod.POST)
	public Disease getDiseaseByIDPOST(@PathVariable("id") String id) {
		Disease disease = rs.getDataByID(id, Disease.class);
		return disease;
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
		if (list != null) {
			for (Drug d : list) {
				d.setData_type("drug");
			}
		}
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
		if (list != null) {
			for (MiRNA m : list) {
				m.setData_type("mirna");
			}
		}
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
		if (list != null) {
			for (Gene m : list) {
				m.setData_type("gene");
			}
		}
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
		if (list != null) {
			for (LncRNA m : list) {
				m.setData_type("lncrna");
			}
		}
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
		if (list != null) {
			for (SNP m : list) {
				m.setData_type("snp");
			}
		}
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
		if (list != null) {
			for (GO m : list) {
				m.setData_type("go");
			}
		}
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
		if (list != null) {
			for (Chemical m : list) {
				m.setData_type("chemical");
			}
		}
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
