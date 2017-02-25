package com.csu.bio.service.data;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;
import com.csu.bio.frame.dao.CommonNoSqlDao;
import com.csu.bio.frame.dao.FullTextRepository;
import com.csu.bio.object.model.RelCount;
import com.csu.bio.object.po.QueryParams;

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
	public <T> List<RelCount> getListByAssociationType(String Type, Class<T> clz) {
		return commonNoSqlDao.findListGroupBy(clz, Type);
	}

	@Override
	public <T> List<T> getAssociationListByDisease(String disease_id, Class<T> clz, QueryParams queryParams) {
		Query query = TextQuery.queryText(TextCriteria.forDefaultLanguage().matchingAny(queryParams.getSearch()));
		// Query query = new Query();
		if (queryParams.getOrder().equals("asc")) {
			query.with(new Sort(Sort.Direction.ASC, queryParams.getSort()));
		} else {
			query.with(new Sort(Sort.Direction.DESC, queryParams.getSort()));
		}
		query.addCriteria(Criteria.where("umls_cui").is(disease_id));
		// page info
		query.with(new PageRequest(queryParams.getOffset(), queryParams.getLimit()));
		return commonNoSqlDao.findListByQuery(clz, query);
	}

	@Override
	public <T> Long getAssociationListCountByDisease(String disease_id, Class<T> clz, QueryParams queryParams) {
		Query query = TextQuery.queryText(TextCriteria.forDefaultLanguage().matchingAny(queryParams.getSearch()));
		query.addCriteria(Criteria.where("umls_cui").is(disease_id));
		return commonNoSqlDao.findCountByQuery(clz, query);
	}

	@Override
	public <T> List<T> getList(Class<T> clz, QueryParams queryParams) {
		Query query = TextQuery.queryText(TextCriteria.forDefaultLanguage().matchingAny(queryParams.getSearch()));
		// Query query = new Query();
		if (queryParams.getOrder().equals("asc")) {
			query.with(new Sort(Sort.Direction.ASC, queryParams.getSort()));
		} else {
			query.with(new Sort(Sort.Direction.DESC, queryParams.getSort()));
		}
		// page info
		query.with(new PageRequest(queryParams.getOffset(), queryParams.getLimit()));
		return commonNoSqlDao.findListByQuery(clz, query);
	}

	@Override
	public <T> Long getListCount(Class<T> clz, QueryParams queryParams) {
		Query query = TextQuery.queryText(TextCriteria.forDefaultLanguage().matchingAny(queryParams.getSearch()));
		return commonNoSqlDao.findCountByQuery(clz, query);
	}

	@Override
	public <T> List<T> findAllByWords(String[] words, Class<T> clz, QueryParams queryParams) {
		Query query = TextQuery.queryText(new TextCriteria().matchingAny(words)).sortByScore().restrict(clz);
		// Query query = new Query();
		if (queryParams.getOrder().equals("asc")) {
			query.with(new Sort(Sort.Direction.ASC, queryParams.getSort()));
		} else {
			query.with(new Sort(Sort.Direction.DESC, queryParams.getSort()));
		}
		// page info
		query.with(new PageRequest(queryParams.getOffset(), queryParams.getLimit()));
		return fullTextRepository.findAllByWords(clz, query);
	}

	@Override
	public <T> Long findAllCountByWords(String[] words, Class<T> clz, QueryParams queryParams) {
		Query query = TextQuery.queryText(new TextCriteria().matchingAny(words)).sortByScore().restrict(clz);
		return fullTextRepository.findAllCountByWords(clz, query);
	}
}
