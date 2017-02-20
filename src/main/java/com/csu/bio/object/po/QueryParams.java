package com.csu.bio.object.po;

import java.util.List;

/**
 * bootstrap table queryParams options<br>
 * queryParamsType='limit'
 */
public class QueryParams {

	private Integer limit;// pageSize

	private Integer offset;// pageNumber

	private String search;// searchText

	private String sort;// sortName

	private String order;// sortOrder

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
