package com.csu.bio.service.data;

import java.io.Serializable;
import java.util.List;

import com.csu.bio.object.model.RelCount;
import com.csu.bio.object.po.Page;
import com.csu.bio.object.po.QueryParams;

public interface DataService {

	/**
	 * 获取列表
	 * 
	 * @param clz
	 *            class类
	 * @param queryParams
	 *            查询参数（参考自bootstrap-table的queryParams）
	 * @return
	 */
	public <T> List<T> getList(Class<T> clz, QueryParams queryParams);

	/**
	 * 获取列表的总个数
	 * 
	 * @param clz
	 *            class类
	 * @param queryParams
	 *            查询参数（参考自bootstrap-table的queryParams）
	 * @return
	 */
	public <T> Long getListCount(Class<T> clz, QueryParams queryParams);

	/**
	 * 根据ID获取数据
	 * 
	 * @param id
	 *            ID
	 * @param clz
	 *            class类
	 * @return
	 */
	public <T> T getDataByID(String id, Class<T> clz);

	public <T> List<RelCount> getListByAssociationType(String Type, Class<T> clz);

	/**
	 * * 获取疾病相关数据列表
	 * 
	 * @param clz
	 *            class类
	 * @param queryParams
	 *            查询参数（参考自bootstrap-table的queryParams）
	 * @param disease_id
	 *            疾病ID
	 * @return
	 */
	public <T> List<T> getAssociationListByDisease(String disease_id, Class<T> clz, QueryParams queryParams);

	/**
	 * * 获取疾病相关数据列表的个数
	 * 
	 * @param clz
	 *            class类
	 * @param queryParams
	 *            查询参数（参考自bootstrap-table的queryParams）
	 * @param disease_id
	 *            疾病ID
	 * @return
	 */
	public <T> Long getAssociationListCountByDisease(String disease_id, Class<T> clz, QueryParams queryParams);

	/**
	 * 全文检索
	 * 
	 * @param words
	 * @param clz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public <T> List<T> findAllByWords(String[] words, Class<T> clz, QueryParams queryParams);

	/**
	 * 全文检索
	 * 
	 * @param words
	 * @param clz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public <T> Long findAllCountByWords(String[] words, Class<T> clz, QueryParams queryParams);
}
