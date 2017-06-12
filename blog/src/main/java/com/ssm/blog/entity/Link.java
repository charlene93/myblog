package com.ssm.blog.entity;

import java.io.Serializable;
/**
 * 友情链接实体
 * @author cheny
 *
 */
public class Link implements Serializable {

	private static final long serialVersionUID = -6243638661654556329L;
	private Integer id;
	private String linkname;//连接名称
	private String linkurl;//连接地址
	private String orderNum;//链接排序序号
	public Link() {
		super();
	}
	public Link(Integer id, String linkname, String linkurl, String orderNum) {
		super();
		this.id = id;
		this.linkname = linkname;
		this.linkurl = linkurl;
		this.orderNum = orderNum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "Link [id=" + id + ", linkname=" + linkname + ", linkurl=" + linkurl + ", orderNum=" + orderNum + "]";
	}
}
