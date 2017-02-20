package com.csu.bio.service.data;

import java.io.Serializable;
import java.util.List;

import com.csu.bio.object.model.RelCount;
import com.csu.bio.object.po.Page;
import com.csu.bio.object.po.QueryParams;

public interface DataService {

	public <T> List<T> getListByPage(Class<T> clz, QueryParams queryParams);

	public <T> Long getListCount(Class<T> clz, QueryParams queryParams);

	public <T> T getDataByID(String id, Class<T> clz);

	public <T> List<RelCount> getListByAssociationType(String Type, Class<T> clz);

	public <T> List<T> getAssociationListByDisease(String disease_id, Class<T> clz);

	public <T extends Serializable> Page<T> findAllByPage(String[] words, Class<T> clz, Integer pageNo,
			Integer pageSize);
}
