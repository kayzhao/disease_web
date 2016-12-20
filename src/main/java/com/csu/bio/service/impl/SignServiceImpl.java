package com.csu.bio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.csu.bio.dao.CommonNoSqlDao;
import com.csu.bio.po.SignTask;
import com.csu.bio.po.UserSign;
import com.csu.bio.service.SignService;

@Service
public class SignServiceImpl implements SignService {
	@Autowired
	private CommonNoSqlDao commonNoSqlDao;

	public List<UserSign> getAllUsers() {
		Query query = new Query();
		query.with(new Sort(Sort.Direction.ASC, new String[] { "_id" }));
		return this.commonNoSqlDao.findListByQuery(UserSign.class, query);
	}

	public int insertUserSign(UserSign userSign) {
		this.commonNoSqlDao.insert(userSign);
		return 0;
	}

	public int removeUserSign() {
		this.commonNoSqlDao.remove(UserSign.class);
		return 0;
	}

	public int updateUserSign(UserSign userSign) {
		List<CommonNoSqlDao.SimpleCriteriaEntry> centries = new ArrayList();
		List<CommonNoSqlDao.SimpleUpdateEntry> uentries = new ArrayList();

		centries.add(CommonNoSqlDao.SimpleCriteriaEntry.createEqEntry("_id",
				userSign.get_id()));

		CommonNoSqlDao.SimpleUpdateEntry simpleUpdateEntry = new CommonNoSqlDao.SimpleUpdateEntry();
		simpleUpdateEntry.setKey("name");
		simpleUpdateEntry.setValue(userSign.getName());
		simpleUpdateEntry
				.setOperation(CommonNoSqlDao.SimpleUpdateEntry.Operation.SET);
		uentries.add(simpleUpdateEntry);

		simpleUpdateEntry = new CommonNoSqlDao.SimpleUpdateEntry();
		simpleUpdateEntry.setKey("mac");
		simpleUpdateEntry.setValue(userSign.getMac());
		simpleUpdateEntry
				.setOperation(CommonNoSqlDao.SimpleUpdateEntry.Operation.SET);
		uentries.add(simpleUpdateEntry);

		simpleUpdateEntry = new CommonNoSqlDao.SimpleUpdateEntry();
		simpleUpdateEntry.setKey("autoSignMode");
		simpleUpdateEntry.setValue(Integer.valueOf(userSign.autoSignMode));
		simpleUpdateEntry
				.setOperation(CommonNoSqlDao.SimpleUpdateEntry.Operation.SET);
		uentries.add(simpleUpdateEntry);

		simpleUpdateEntry = new CommonNoSqlDao.SimpleUpdateEntry();
		simpleUpdateEntry.setKey("signTasks");
		simpleUpdateEntry.setValue(userSign.getSignTasks());
		simpleUpdateEntry
				.setOperation(CommonNoSqlDao.SimpleUpdateEntry.Operation.SET);
		uentries.add(simpleUpdateEntry);

		this.commonNoSqlDao.updateFirst(uentries, centries, UserSign.class);

		return 0;
	}

	public UserSign getUserSignByUserid(String id) {
		UserSign userSign = (UserSign) this.commonNoSqlDao.findById(id,
				UserSign.class);
		return userSign;
	}

	public List<UserSign> getAllUserSignInAutoMode() {
		CommonNoSqlDao.SimpleCriteriaEntry simpleCriteriaEntry = new CommonNoSqlDao.SimpleCriteriaEntry();
		simpleCriteriaEntry.setKey("autoSignMode");
		simpleCriteriaEntry.setValue(Integer.valueOf(1));
		simpleCriteriaEntry
				.setOperation(CommonNoSqlDao.SimpleCriteriaEntry.Operation.eq);
		List<UserSign> userSigns = this.commonNoSqlDao
				.findList(
						UserSign.class,
						new CommonNoSqlDao.SimpleCriteriaEntry[] { simpleCriteriaEntry });
		return userSigns;
	}

	public int updateUserSignTask(String userid, SignTask userSignTask) {
		return 0;
	}

	public int deleteUserSignTasks(String userid) {
		UserSign userSign = (UserSign) this.commonNoSqlDao.findById(userid,
				UserSign.class);
		if ((null != userSign.getSignTasks())
				&& (!userSign.getSignTasks().isEmpty())) {
			for (SignTask signTask : userSign.getSignTasks()) {
				this.commonNoSqlDao.removeById(signTask.get_id(),
						SignTask.class);
			}
		}
		return 0;
	}

	public UserSign getUserSignByMac(String mac) {
		Criteria criteria = new Criteria().and("mac").is(mac);
		Query query = new Query();
		query.addCriteria(criteria);
		List<UserSign> userSigns = this.commonNoSqlDao.findListByQuery(
				UserSign.class, query);
		if ((null != userSigns) && (!userSigns.isEmpty())) {
			return (UserSign) userSigns.get(0);
		}
		return null;
	}
}
