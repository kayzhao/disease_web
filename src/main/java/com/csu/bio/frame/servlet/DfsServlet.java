package com.csu.bio.frame.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.csu.bio.util.oper.StringUtil;
import com.csu.bio.util.web.MyApplicationContext;
import com.mongodb.gridfs.GridFSDBFile;

public class DfsServlet extends HttpServlet {
	private static final long serialVersionUID = 6340762040636049790L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommonNoSqlMongoFSDao commonNoSqlMongoFSDao = MyApplicationContext.getBean(CommonNoSqlMongoFSDao.class);
		String id = request.getParameter("id");
		if (StringUtil.isNotBlank(id)) {
			String uri = request.getRequestURI();
			GridFSDBFile gridFSDBFile = commonNoSqlMongoFSDao.getFileById(id);
			if (null != gridFSDBFile) {
				response.reset();
				response.setContentType(gridFSDBFile.getContentType());
				gridFSDBFile.writeTo(response.getOutputStream());
			}
		}
	}

}
