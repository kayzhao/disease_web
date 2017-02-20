package com.csu.bio.frame.dao.impl;

import java.io.Serializable;
import java.util.List;

//imports as static
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.csu.bio.frame.dao.CommonNoSqlDao;
import com.csu.bio.frame.dao.CommonNoSqlDao.SimpleUpdateEntry.Operation;
import com.csu.bio.object.model.Drug;
import com.csu.bio.object.model.MiRNA;
import com.csu.bio.object.model.RelCount;
import com.csu.bio.object.po.Page;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Repository("commonNoSqlDao")
public class CommonNoSqlDaoImpl implements CommonNoSqlDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public <T> void insert(T t) {
		this.mongoTemplate.insert(t);

	}

	public <T> T findById(Object id, Class<T> clz) {
		T t = this.mongoTemplate.findById(id, clz);
		return t;
	}

	@Override
	public <T> T findOne(Class<T> clz, SimpleCriteriaEntry... entries) {
		Query query = new Query();

		if (null != entries) {
			for (int i = 0, len = entries.length; i < len; i++) {
				query.addCriteria(entries[i].toCriteria());
			}
		}
		T t = this.mongoTemplate.findOne(query, clz);
		return t;
	}

	@Override
	public <T> T findOne(Class<T> clz, String[] fields, SimpleCriteriaEntry... entries) {
		Query query = new Query();

		if (null != entries) {
			for (int i = 0, len = entries.length; i < len; i++) {
				query.addCriteria(entries[i].toCriteria());
			}
		}
		if (fields != null) {
			for (int i = 0; i < fields.length; i++) {
				query.fields().include(fields[i]);
			}
		}
		T t = this.mongoTemplate.findOne(query, clz);
		return t;
	}

	public <T> List<T> findList(Class<T> clz, SimpleCriteriaEntry... entries) {
		Query query = new Query();

		if (null != entries) {
			for (int i = 0, len = entries.length; i < len; i++) {
				query.addCriteria(entries[i].toCriteria());
			}
		}
		List<T> list = this.mongoTemplate.find(query, clz);
		return list;
	}

	@Override
	public <T> List<RelCount> findListGroupBy(Class<T> clz, String type) {
		Aggregation agg = newAggregation(group("disease_id").count().as("total_count"),
				project("total_count").and("disease_id").previousOperation(), sort(Sort.Direction.DESC, "total_count"));
		// Convert the aggregation result into a List
		AggregationResults<RelCount> groupResults = this.mongoTemplate.aggregate(agg, clz, RelCount.class);
		List<RelCount> result = groupResults.getMappedResults();
		for (RelCount relCount : result) {
			relCount.setAssociation_type(type);
		}
		return result;
	}

	public <T> List<T> findListByQuery(Class<T> clz, Query query) {
		List<T> list = this.mongoTemplate.find(query, clz);
		return list;
	}

	public <T> Long findCount(Class<T> clz, SimpleCriteriaEntry... entries) {
		Query query = new Query();

		for (int i = 0, len = entries.length; i < len; i++) {
			query.addCriteria(entries[i].toCriteria());
		}
		long count = this.mongoTemplate.count(query, clz);
		return count;
	}

	public <T> Long findCountByQuery(Class<T> clz, Query query) {
		long count = this.mongoTemplate.count(query, clz);
		return count;
	}

	public <T> void removeById(Object id, Class<T> clz) {
		this.mongoTemplate.remove(new Query().addCriteria(new Criteria().and("id").is(id)), clz);
	}

	// 根据状态删除对应的类
	public <T> void removeByState(Object state, Class<T> clz) {
		this.mongoTemplate.remove(new Query().addCriteria(new Criteria().and("RUNNING_STATUS").is(state)), clz);
	}

	public <T> void updateFirst(List<SimpleUpdateEntry> uentries, List<SimpleCriteriaEntry> centries, Class<T> clz) {
		Query query = new Query();

		for (int i = 0, len = centries.size(); i < len; i++) {
			query.addCriteria(centries.get(i).toCriteria());
		}

		Update update = this.createAndInitUpdate(null, uentries);
		this.mongoTemplate.updateFirst(query, update, clz);
	}

	private Update createAndInitUpdate(Update update, List<SimpleUpdateEntry> entries) {
		if (update == null) {
			update = new Update();
		}

		for (SimpleUpdateEntry simpleUpdateEntry : entries) {
			if (simpleUpdateEntry.getOperation() == Operation.SET) {
				update.set(simpleUpdateEntry.getKey(), simpleUpdateEntry.getValue());
			} else if (simpleUpdateEntry.getOperation() == Operation.INC) {
				update.inc(simpleUpdateEntry.getKey(), (Number) simpleUpdateEntry.getValue());
			}
		}

		return update;
	}
}
