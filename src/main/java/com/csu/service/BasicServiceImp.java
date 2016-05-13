package com.csu.service;

/**
 * 
 */
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.BasicDAOImpl;
import com.csu.model.BasicModel;
import com.csu.util.ApplicationException;
import com.csu.util.Page;

@Service
@Transactional
public class BasicServiceImp extends BasicService {
	@Autowired
	private BasicDAOImpl baseDAO;

	public BasicModel getById(int id, Class classtype) {
		return baseDAO.getItem(id, classtype);
	}

	public List<BasicModel> getListByPage(Class classtype, Page page) {
		return baseDAO.getItemsByPage(classtype, page);
	}

	public List<BasicModel> getList(Class classtype) {
		return baseDAO.getItems(classtype);
	}

	public void updateItem(BasicModel item) throws ApplicationException {
		baseDAO.updateItem(item);
	}

	public void delete(Class classtype, int id) {
		baseDAO.deleteItem(id, classtype);
	}

	public void add(List<BasicModel> items) throws ApplicationException {
		baseDAO.addItem(items);
	}

	/**
	 * 
	 * @param classtype
	 *            :查找的对象类型
	 * @param params
	 *            :键值对，键值为对应属性名，值为对应的属性，默认eq
	 * @return
	 * @throws ApplicationException
	 */
	public <T extends BasicModel> List<T> getByWhere(Class classtype,
			Map<String, Object> params) throws ApplicationException {
		return baseDAO.getItemsByWhere(classtype, params);
	}

	public <T extends BasicModel> List<T> getByIn(Class classtype, String key,
			List<Object> inlist) throws ApplicationException {
		return baseDAO.getItemsByIn(classtype, key, inlist);
	}
}
