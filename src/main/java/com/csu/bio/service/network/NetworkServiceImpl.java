package com.csu.bio.service.network;

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
import com.csu.bio.object.model.UMLSREL;

@Service
public class NetworkServiceImpl implements NetworkService {
	@Autowired
	private CommonNoSqlDao commonNoSqlDao;

	@Override
	public <T> Map<String, Object> getRelationshipData(List<String> ids, Class<T> clz) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (ids == null || ids.size() == 0)
			return null;
		for (String id : ids) {
			T rel = null;
			rel = commonNoSqlDao.findOne(clz, SimpleCriteriaEntry.createEqEntry("_id", id));
			if (rel == null) {
				if (result.get("errorids") == null) {
					result.put("errorids", id);
				} else {
					result.put("errorids", result.get("errorids") + "," + id);
				}
				continue;
			}
			rel = commonNoSqlDao.findOne(clz, SimpleCriteriaEntry.createEqEntry("_id", id));
			result.put(id, rel);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.csu.bio.service.network.NetworkService#getUMLSRELData(java.lang.
	 * String)
	 */
	@Override
	public UMLSREL getUMLSRELData(String id) {
		UMLSREL rel = null;
		rel = commonNoSqlDao.findOne(UMLSREL.class, SimpleCriteriaEntry.createEqEntry("_id", id));
		return rel;
	}
}
