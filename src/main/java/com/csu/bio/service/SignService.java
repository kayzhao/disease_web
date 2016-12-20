package com.csu.bio.service;

import java.util.List;

import com.csu.bio.po.SignTask;
import com.csu.bio.po.UserSign;

public abstract interface SignService {
	public abstract List<UserSign> getAllUsers();

	public abstract List<UserSign> getAllUserSignInAutoMode();

	public abstract int insertUserSign(UserSign paramUserSign);

	public abstract int updateUserSign(UserSign paramUserSign);

	public abstract int removeUserSign();

	public abstract int updateUserSignTask(String paramString,
			SignTask paramSignTask);

	public abstract int deleteUserSignTasks(String paramString);

	public abstract UserSign getUserSignByUserid(String paramString);

	public abstract UserSign getUserSignByMac(String paramString);
}