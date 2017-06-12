package com.ssm.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.blog.dao.CommentDao;
import com.ssm.blog.entity.Comment;

public interface CommentMapper {
	
	// 获取评论信息
	public List<Comment> getCommentData(@Param("map")Map<String, Object> map);

	// 添加评论
	public int addComment(@Param("c")Comment comment);

	// 获取总记录数
	public Long getTotal(@Param("map")Map<String, Object> map);

	// 修改评论信息
	public Integer update(@Param("c")Comment comment);

	// 删除评论信息
	public Integer deleteComment(Integer id);

	// 根据博客id删除评论信息，用于删除某篇博客前，先删掉该博客的评论，因为有外键
	public Integer deleteCommentByBlogId(Integer id);
}
