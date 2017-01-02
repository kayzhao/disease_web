package com.csu.bio.controller.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csu.bio.controller.pub.XkaptchaController;
import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.csu.bio.object.model.*;
import com.csu.bio.service.data.DataService;
import com.csu.bio.util.oper.GridfsUtil;
import com.mongodb.gridfs.GridFSDBFile;

/**
 *
 * @author kayzhao
 * @version 2016年12月25日
 */

@RestController
@RequestMapping(value = "/")
public class DataController {
	private final Logger logger = Logger.getLogger(XkaptchaController.class);

	@Autowired
	public DataService rs;

	@Autowired
	CommonNoSqlMongoFSDao cFsDao;

	@RequestMapping(value = "disease/{id}", method = RequestMethod.GET)
	public Object getDiseaseByID(@PathVariable("id") String id) {
		return rs.getDataByID(id, Disease.class);
	}

	@RequestMapping(value = "drug/{id}", method = RequestMethod.GET)
	public Object getDrugByID(@PathVariable("id") String id) {
		return rs.getDataByID(id, Drug.class);
	}

	@RequestMapping(value = "chemical/{id}", method = RequestMethod.GET)
	public Object getChemicalByID(@PathVariable("id") String id) {
		return rs.getDataByID(id, Chemical.class);
	}

	@RequestMapping(value = "/synonym/{keyword}", method = RequestMethod.GET)
	public Object getDataByName(@PathVariable("keyword") String keyword) {
		return rs.getDataByID(keyword, Disease.class);
	}

	@RequestMapping(value = "gfs/{filename}", method = RequestMethod.GET)
	public Object getDataByFsName(@PathVariable("filename") String filename) throws IOException {
		String fileName = "MESH:C531617_genes_1481955794.173352.pyobj";
		GridFSDBFile fs = cFsDao.getFileByFileName(fileName);
		System.out.println(new String(GridfsUtil.File2Bytes(fs)));
		System.out.println("success");
		return fs.getContentType();
	}
}
