package com.ssm.blog.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 博客实体
 * 
 * @author cheny
 *
 */
public class Blog implements Serializable {

	private static final long serialVersionUID = 2729987924652873100L;
	private Integer id;
	private String title;
	private String summary;
	private Date releaseDate;
	private Integer clickHit;
	private Integer replyHit;
	private String content;
	private String contentNoTag;// 不带标签的博客内容，用于Lucene索引中
	private String keyWord; // 关键字，用空格隔开
	private BlogType blogType; // 博客类型
	private Integer blogCount;// 博客数量，非博客实际属性，用于根据发布日期归档查询
	private String releaseDateStr;// 发布日期的字符串，只取年月
	private List<String> imageList = new LinkedList<String>();// 博客里存的图片，主要用于展示缩略图
	public Blog() {
		super();
	}
	public Blog(Integer id, String title, String summary, Date releaseDate, Integer clickHit, Integer replyHit,
			String content, String contentNoTag, String keyWord, BlogType blogType, Integer blogCount,
			String releaseDateStr, List<String> imageList) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.releaseDate = releaseDate;
		this.clickHit = clickHit;
		this.replyHit = replyHit;
		this.content = content;
		this.contentNoTag = contentNoTag;
		this.keyWord = keyWord;
		this.blogType = blogType;
		this.blogCount = blogCount;
		this.releaseDateStr = releaseDateStr;
		this.imageList = imageList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getClickHit() {
		return clickHit;
	}
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}
	public Integer getReplyHit() {
		return replyHit;
	}
	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentNoTag() {
		return contentNoTag;
	}
	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public BlogType getBlogType() {
		return blogType;
	}
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	public String getReleaseDateStr() {
		return releaseDateStr;
	}
	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
	public List<String> getImageList() {
		return imageList;
	}
	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", summary=" + summary + ", releaseDate=" + releaseDate
				+ ", clickHit=" + clickHit + ", replyHit=" + replyHit + ", content=" + content + ", contentNoTag="
				+ contentNoTag + ", keyWord=" + keyWord + ", blogType=" + blogType + ", blogCount=" + blogCount
				+ ", releaseDateStr=" + releaseDateStr + ", imageList=" + imageList + "]";
	}
}
