package com.csu.bio.service.mapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import com.csu.bio.frame.dao.CommonNoSqlDao;
import com.csu.bio.frame.dao.CommonNoSqlDao.SimpleCriteriaEntry;
import com.csu.bio.frame.dao.FullTextRepository;
import com.csu.bio.object.model.DisMap;
import com.jayway.restassured.internal.http.Method;

@Service
public class MappingServiceImpl implements MappingService {
	@Autowired
	private CommonNoSqlDao commonNoSqlDao;

	@Autowired
	private FullTextRepository fullTextRepository;

	@Override
	public Map<String, DisMap> getMappingData(List<String> ids, String type) {
		Map<String, DisMap> result = new HashMap<String, DisMap>();
		if (ids == null || ids.size() == 0)
			return null;
		type = type.toLowerCase();
		for (String id : ids) {
			DisMap dis = null;
			if (type.equals("all"))
				dis = commonNoSqlDao.findOne(DisMap.class, SimpleCriteriaEntry.createEqEntry("_id", id));
			else
				dis = commonNoSqlDao.findOne(DisMap.class, SimpleCriteriaEntry.createEqEntry("_id", id),
						SimpleCriteriaEntry.createEqEntry(type, 1), SimpleCriteriaEntry.createEqEntry("other", 1));
			result.put(id, dis);
		}
		return result;
	}
}
