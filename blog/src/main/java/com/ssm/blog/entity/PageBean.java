package com.ssm.blog.entity;

import java.io.Serializable;

public class PageBean implements Serializable {
	
	private static final long serialVersionUID = 4167812796349937285L;
	private int page;//第几页
	private int pageSize;//每页记录数
	private int start;//起始页
	public PageBean() {
		super();
	}
	public PageBean(int page, int pageSize, int start) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.start = start;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
}
