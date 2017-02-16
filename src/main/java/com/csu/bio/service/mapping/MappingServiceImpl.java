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

@Service
public class MappingServiceImpl implements MappingService {
	@Autowired
	private CommonNoSqlDao commonNoSqlDao;

	@Autowired
	private FullTextRepository fullTextRepository;

	@Override
	public Map<String, Object> getMappingData(List<String> ids, String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (ids == null || ids.size() == 0)
			return null;
		type = type.toLowerCase();
		for (String id : ids) {
			DisMap dis = null;
			dis = commonNoSqlDao.findOne(DisMap.class, SimpleCriteriaEntry.createEqEntry("_id", id));
			if (dis == null) {
				if (result.get("errorids") == null) {
					result.put("errorids", id);
				} else {
					result.put("errorids", result.get("errorids") + "," + id);
				}
				continue;
			}
			if (type.equals("all")) {
				dis = commonNoSqlDao.findOne(DisMap.class, SimpleCriteriaEntry.createEqEntry("_id", id));
			} else {
				dis = commonNoSqlDao.findOne(DisMap.class, new String[] { type },
						SimpleCriteriaEntry.createEqEntry("_id", id));
			}
			result.put(id, dis);
		}
		return result;
	}
}
