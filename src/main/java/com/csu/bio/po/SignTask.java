package com.csu.bio.po;

import java.util.Date;

public class SignTask {
	public String _id;
	public Date date;
	public boolean isSuccess = false;
	public Date lastExecuteTime;
	public int tryTimes = 0;

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isSuccess() {
		return this.isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public int getTryTimes() {
		return this.tryTimes;
	}

	public void setTryTimes(int tryTimes) {
		this.tryTimes = tryTimes;
	}

	public Date getLastExecuteTime() {
		return this.lastExecuteTime;
	}

	public void setLastExecuteTime(Date lastExecuteTime) {
		this.lastExecuteTime = lastExecuteTime;
	}
}
