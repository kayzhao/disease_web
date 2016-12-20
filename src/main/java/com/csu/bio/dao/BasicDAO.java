package com.csu.bio.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.csu.bio.model.BasicModel;
import com.csu.bio.util.ApplicationException;
import com.csu.bio.util.Page;

/**
 * 
 * @author kayzhao
 *
 */
public interface BasicDAO {
	public <T extends BasicModel> void addItem(List<T> item)
			throws ApplicationException;

	public void updateItem(BasicModel team) throws ApplicationException;

	public BasicModel getItem(int id, Class classtype);

	public void deleteItem(int id, Class classtype);

	public <T extends BasicModel> List<T> getItemsByPage(Class classtype,
			Page page);

	public <T extends BasicModel> List<T> getItems(Class classtype);

	public <T extends BasicModel> List<T> getItemsByWhere(Class classtype,
			Map<String, Object> map);

	public <T extends BasicModel> List<T> getItemsByIn(Class classtype,
			String key, List<Object> inlist);

	public List<Object> createHql(String hql) throws ApplicationException;

	public <T extends BasicModel> List<T> getWhereByPageLike(Class classtype,
			Map<String, Object> params, Page page);

	public void deleteByWhere(Map<String, String> params, Class classtype);
}
