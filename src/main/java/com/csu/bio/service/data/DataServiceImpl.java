package com.csu.bio.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import com.csu.bio.frame.dao.CommonNoSqlDao;
import com.csu.bio.frame.dao.FullTextRepository;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	private CommonNoSqlDao commonNoSqlDao;

	@Autowired
	private FullTextRepository fullTextRepository;

	@Override
	public <T> T getDataByID(String id, Class<T> clz) {
		return commonNoSqlDao.findById(id, clz);
	}

	@Override
	public Document getDataByID(String id) {
		return null;
	}
}
