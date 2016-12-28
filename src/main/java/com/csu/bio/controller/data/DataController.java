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
@RequestMapping(value = "data")
public class DataController {
	private final Logger logger = Logger.getLogger(XkaptchaController.class);

	@Autowired
	public DataService rs;

	@Autowired
	CommonNoSqlMongoFSDao cFsDao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Object getData(@PathVariable("id") String id) {
		return rs.getDataByID(id, CTD.class);
	}

	@RequestMapping(value = "gfs/{filename}", method = RequestMethod.GET)
	public Object getDataByFsName(@PathVariable("filename") String filename) throws IOException {
		String fileName = "MESH:C531617_genes_1481955794.173352.pyobj";
		GridFSDBFile fs = cFsDao.getFileByFileName(fileName);
		System.out.println(GridfsUtil.toByteArray(fs).toString());
		System.out.println("success");
		return fs.getContentType();
	}
}
