package com.csu.bio.frame.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.Repository;

import com.csu.bio.frame.dao.CommonNoSqlDao.SimpleCriteriaEntry;
import com.csu.bio.object.po.Page;

public interface FullTextRepository extends Repository {
	/**
	 * 全文搜索
	 * 
	 * @param words
	 * @param clz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public <T extends Serializable> Page<T> findAllByPage(String[] words, Class<T> clz, Integer pageNo,
			Integer pageSize);

	/**
	 * 用户的全文搜索
	 * 
	 * @param words
	 * @param userId
	 * @param clz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public <T extends Serializable> Page<T> findAllByPage(String[] words, String userId, Class<T> clz, Integer pageNo,
			Integer pageSize, SimpleCriteriaEntry... entries);
}