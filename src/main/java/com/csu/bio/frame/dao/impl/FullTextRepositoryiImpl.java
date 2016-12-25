package com.csu.bio.frame.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;

import com.csu.bio.frame.dao.CommonNoSqlDao.SimpleCriteriaEntry;
import com.csu.bio.frame.dao.FullTextRepository;
import com.csu.bio.object.po.Page;

@Repository("FullTextRepository")
public class FullTextRepositoryiImpl implements FullTextRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	// Execute a full-text search and define sorting dynamically
	public <T extends Serializable> Page<T> findAllByPage(String[] words, Class<T> clz, Integer pageNo,
			Integer pageSize) {

		Query query = TextQuery.queryText(new TextCriteria().matchingAny(words)).sortByScore().restrict(clz);

		Page<T> page = new Page<T>();
		int totalCount = this.mongoTemplate.find(query, clz).size();
		page.setPageSize(totalCount);
		if (pageNo != null && pageSize != null) {
			query.skip((pageNo - 1) * pageSize).limit(pageSize);
		}

		List<T> resultList = this.mongoTemplate.find(query, clz);
		page.setDatas(resultList);
		page.setPageNo(pageNo);

		return page;
	}

	public <T extends Serializable> Page<T> findAllByPage(String[] words, String userId, Class<T> clz, Integer pageNo,
			Integer pageSize, SimpleCriteriaEntry... entries) {
		Query query = TextQuery.queryText(new TextCriteria().matchingAny(words)).sortByScore().restrict(clz);
		for (int i = 0, len = entries.length; i < len; i++) {
			query.addCriteria(entries[i].toCriteria());
		}
		Page<T> page = new Page<T>();
		int totalCount = this.mongoTemplate.find(query, clz).size();
		page.setPageSize(totalCount);
		if (pageNo != null && pageSize != null) {
			query.skip((pageNo - 1) * pageSize).limit(pageSize);
		}

		List<T> resultList = this.mongoTemplate.find(query, clz);
		page.setDatas(resultList);
		page.setPageNo(pageNo);

		return page;
	}

}
