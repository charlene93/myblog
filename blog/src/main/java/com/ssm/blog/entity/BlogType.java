package com.ssm.blog.entity;

import java.io.Serializable;

public class BlogType implements Serializable {

	private static final long serialVersionUID = -767167181840771124L;
	private Integer id;
	private String typeName;
	private String orderNum;
	private Integer blogCount; //统计不同类型的博客数量
	public BlogType() {
		super();
	}
	
	public BlogType(Integer id, String typeName, String orderNum, Integer blogCount) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.orderNum = orderNum;
		this.blogCount = blogCount;
	}

	public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "BlogType [id=" + id + ", typeName=" + typeName + ", orderNum=" + orderNum + ", blogCount=" + blogCount
				+ "]";
	}
}
