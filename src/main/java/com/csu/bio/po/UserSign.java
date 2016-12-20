package com.csu.bio.po;

import java.util.List;

public class UserSign {
	public String _id;
	public String name;
	public String mac;
	public int autoSignMode;
	public List<SignTask> signTasks;

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getAutoSignMode() {
		return this.autoSignMode;
	}

	public void setAutoSignMode(int autoSignMode) {
		this.autoSignMode = autoSignMode;
	}

	public List<SignTask> getSignTasks() {
		return this.signTasks;
	}

	public void setSignTasks(List<SignTask> signTasks) {
		this.signTasks = signTasks;
	}
}
