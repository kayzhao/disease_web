package com.csu.bio.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csu.bio.frame.dao.CommonNoSqlDao;
import com.csu.bio.frame.dao.FullTextRepository;
import com.csu.bio.object.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private CommonNoSqlDao commonNoSqlDao;

	@Autowired
	private FullTextRepository fullTextRepository;

	@Override
	public Role getRoleBy(String id) {
		return commonNoSqlDao.findById(id, Role.class);
	}
}
