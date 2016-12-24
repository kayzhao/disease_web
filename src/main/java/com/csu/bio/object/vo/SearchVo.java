package com.csu.bio.object.vo;

/**
 * 
 */
public class SearchVo {
	private int start = 1;
	private String searchbody = "";
	private String type = "";

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getSearchbody() {
		return searchbody;
	}

	public void setSearchbody(String searchbody) {
		this.searchbody = searchbody;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
