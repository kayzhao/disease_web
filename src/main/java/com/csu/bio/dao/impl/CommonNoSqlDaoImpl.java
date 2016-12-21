package com.csu.bio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.csu.bio.dao.CommonNoSqlDao;

@Repository("commonNoSqlDao")
public class CommonNoSqlDaoImpl implements CommonNoSqlDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public <T> void insert(T t) {
		this.mongoTemplate.insert(t);
	}

	public <T> void remove(Class<T> clz) {
		this.mongoTemplate.remove(new Query(), clz);
	}

	public <T> T findById(Object id, Class<T> clz) {
		T t = this.mongoTemplate.findById(id, clz);
		return t;
	}

	public <T> List<T> findList(Class<T> clz,
			CommonNoSqlDao.SimpleCriteriaEntry... entries) {
		Query query = new Query();
		if (null != entries) {
			int i = 0;
			for (int len = entries.length; i < len; i++) {
				query.addCriteria(entries[i].toCriteria());
			}
		}
		List<T> list = this.mongoTemplate.find(query, clz);
		return list;
	}

	public <T> List<T> findListByQuery(Class<T> clz, Query query) {
		List<T> list = this.mongoTemplate.find(query, clz);
		return list;
	}

	public <T> Long findCount(Class<T> clz,
			CommonNoSqlDao.SimpleCriteriaEntry... entries) {
		Query query = new Query();

		int i = 0;
		for (int len = entries.length; i < len; i++) {
			query.addCriteria(entries[i].toCriteria());
		}
		long count = this.mongoTemplate.count(query, clz);
		return Long.valueOf(count);
	}

	public <T> void removeById(Object id, Class<T> clz) {
		this.mongoTemplate.remove(
				new Query().addCriteria(new Criteria().and("id").is(id)), clz);
	}

	public <T> void updateFirst(
			List<CommonNoSqlDao.SimpleUpdateEntry> uentries,
			List<CommonNoSqlDao.SimpleCriteriaEntry> centries, Class<T> clz) {
		Query query = new Query();

		int i = 0;
		for (int len = centries.size(); i < len; i++) {
			query.addCriteria(((CommonNoSqlDao.SimpleCriteriaEntry) centries
					.get(i)).toCriteria());
		}
		Update update = createAndInitUpdate(null, uentries);
		this.mongoTemplate.updateFirst(query, update, clz);
	}

	private Update createAndInitUpdate(Update update,
			List<CommonNoSqlDao.SimpleUpdateEntry> entries) {
		if (update == null) {
			update = new Update();
		}
		for (CommonNoSqlDao.SimpleUpdateEntry simpleUpdateEntry : entries) {
			if (simpleUpdateEntry.getOperation() == CommonNoSqlDao.SimpleUpdateEntry.Operation.SET) {
				update.set(simpleUpdateEntry.getKey(),
						simpleUpdateEntry.getValue());
			} else if (simpleUpdateEntry.getOperation() == CommonNoSqlDao.SimpleUpdateEntry.Operation.INC) {
				update.inc(simpleUpdateEntry.getKey(),
						(Number) simpleUpdateEntry.getValue());
			}
		}
		return update;
	}
}
