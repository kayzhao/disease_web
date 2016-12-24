package com.csu.bio.object.po;

import java.io.Serializable;
import java.util.List;

/**
 * Page
 * 
 * @param <T>
 */
public class Page<T extends Serializable> implements Serializable {
	public static final Integer DEFAULT_PAGE_SIZE = 10;

	public static final Integer DEFAULT_PAGE_NO = 1;

	private static final long serialVersionUID = 4904828641517350934L;

	/** 当前页码(从1开始) */
	private Integer pageNo;

	/** 总页数 */
	private Long pageTotal;

	/** 每页条数 */
	private Integer pageSize;

	/** 总记录数 */
	private Long totalSize;

	List<T> datas;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		if (pageNo == null || pageNo < 1) {
			pageNo = Page.DEFAULT_PAGE_NO;
		}

		this.pageNo = pageNo;
	}

	public Long getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Long pageTotal) {
		// this.pageTotal = pageTotal;
		this.pageTotal = (totalSize / pageSize + (totalSize % pageSize == 0 ? 0 : 1));
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize == null || pageSize < 1) {
			pageSize = Page.DEFAULT_PAGE_SIZE;
		}

		this.pageSize = pageSize;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
		this.pageTotal = totalSize % this.pageSize == 0 ? totalSize / this.pageSize : totalSize / this.pageSize + 1;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageSize=" + pageSize + ", totalSize="
				+ totalSize + ", datas=" + datas + "]";
	}
}
