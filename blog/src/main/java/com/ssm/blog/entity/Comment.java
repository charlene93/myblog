package com.ssm.blog.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 评论实体
 * @author cheny
 *
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 7385931327200143170L;
	
	private Integer id;
	private String userIp;//评论用户的ip
	private String content;//评论内容
	private Date commentDate;//评论日期
	private Integer state; //审核状态，0待审核 1审核通过 2未通过
	private Blog blog; //关联的博客
	public Comment() {
		super();
	}
	public Comment(Integer id, String userIp, String content, Date commentDate, Integer state, Blog blog) {
		super();
		this.id = id;
		this.userIp = userIp;
		this.content = content;
		this.commentDate = commentDate;
		this.state = state;
		this.blog = blog;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", userIp=" + userIp + ", content=" + content + ", commentDate=" + commentDate
				+ ", state=" + state + ", blog=" + blog + "]";
	}
}
