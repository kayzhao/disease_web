package com.csu.bio.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csu.bio.model.BasicModel;
import com.csu.bio.util.ApplicationException;
import com.csu.bio.util.Page;

/**
 * 
 * @author kayzhao
 *
 */
@Repository
public class BasicDAOImpl implements BasicDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <T extends BasicModel> void addItem(List<T> items)
			throws ApplicationException {
		try {
			for (T item : items) {
				getCurrentSession().save(item);
			}
		} catch (Exception e) {
			throw new ApplicationException(items.get(0).getClass()
					.getSimpleName()
					+ "插入记录失败");
		}
	}

	@Override
	public BasicModel getItem(int id, Class classtype) {
		return (BasicModel) getCurrentSession().get(classtype, id);
	}

	@Override
	public void updateItem(BasicModel item) throws ApplicationException {
		// TODO Auto-generated method stub
		BasicModel itemToUpdate = getItem(item.getId(), item.getClass());
		if (itemToUpdate != null) {
			getCurrentSession().merge(item);
		} else {
			throw new ApplicationException(item.getClass().getName()
					+ " 数据不存在，无法更新");
		}
	}

	@Override
	public void deleteItem(int id, Class classtype) {
		// TODO Auto-generated method stub
		BasicModel item = getItem(id, classtype);
		if (item != null)
			getCurrentSession().delete(item);
	}

	@Override
	public void deleteByWhere(Map<String, String> params, Class classtype) {
		// TODO Auto-generated method stub
		String hql = "";
		if (params != null) {
			hql = " where ";
			for (Entry<String, String> para : params.entrySet()) {
				hql += para.getKey() + "=" + para.getValue() + " ";
			}
		}
		Query qu = getCurrentSession().createQuery(
				"delete from " + classtype.getSimpleName() + hql);
		qu.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BasicModel> List<T> getItemsByPage(Class classtype,
			Page page) {
		// TODO Auto-generated method stub
		int total = getCurrentSession()
				.createQuery("from " + classtype.getSimpleName()).list().size();
		int tpage = (int) Math.ceil(total / (double) page.getPagesize());
		page.setTotal(total);
		tpage = tpage > 0 ? tpage : 1;
		page.setTotalpage(tpage);
		return getCurrentSession()
				.createQuery("from " + classtype.getSimpleName())
				.setFirstResult((page.getStart() - 1) * page.getPagesize())
				.setMaxResults(page.getPagesize()).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BasicModel> List<T> getWhereByPageLike(Class classtype,
			Map<String, Object> params, Page page) {
		Criteria cri = getCurrentSession().createCriteria(classtype);
		for (Entry<String, Object> param : params.entrySet()) {
			cri.add(Restrictions.like(param.getKey(),
					(String) param.getValue(), MatchMode.ANYWHERE));
		}
		int total = cri.list().size();
		page.setTotal(total);
		int tpage = (int) Math.ceil(total / (double) page.getPagesize());
		tpage = tpage > 0 ? tpage : 1;
		page.setTotalpage(tpage);
		cri.setFirstResult((page.getStart() - 1) * page.getPagesize())
				.setMaxResults(page.getPagesize());
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BasicModel> List<T> getItemsByWhere(Class classtype,
			Map<String, Object> params) {
		Criteria cri = getCurrentSession().createCriteria(classtype);
		for (Entry<String, Object> param : params.entrySet()) {
			cri.add(Restrictions.eq(param.getKey(), param.getValue()));
		}
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BasicModel> List<T> getItemsByIn(Class classtype,
			String key, List<Object> inlist) {
		Query query = getCurrentSession().createQuery(
				"from " + classtype.getSimpleName() + " where " + key
						+ " in (:inlist)");
		query.setParameterList("inlist", inlist);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BasicModel> List<T> getItems(Class classtype) {
		// TODO Auto-generated method stub
		List<T> list = getCurrentSession().createQuery(
				" from " + classtype.getSimpleName()).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Object> createHql(String hql) throws ApplicationException {
		try {
			return getCurrentSession().createQuery(hql).list();
		} catch (Exception e) {
			throw new ApplicationException("HQL查找失败:hql");
		}
	}

}
