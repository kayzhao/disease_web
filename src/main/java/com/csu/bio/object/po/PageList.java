package com.csu.bio.object.po;

import java.util.List;

/**
 * Bootstrap Table url json format
 * 
 * @param <T>
 */
public class PageList<T> {

	private Long total;

	List<T> rows;

	private QueryParams params;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public QueryParams getParams() {
		return params;
	}

	public void setParams(QueryParams params) {
		this.params = params;
	}
}
