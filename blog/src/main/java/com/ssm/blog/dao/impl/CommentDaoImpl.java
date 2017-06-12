package com.ssm.blog.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ssm.blog.dao.CommentDao;
import com.ssm.blog.entity.Comment;
import com.ssm.blog.mapper.CommentMapper;
@Repository
public class CommentDaoImpl implements CommentDao {
	@Resource
	private CommentMapper cm;

	@Override
	public List<CommentDao> getCommentData(Map<String, Object> map) {
		return cm.getCommentData(map);
	}

	@Override
	public int addComment(Comment comment) {
		return cm.addComment(comment);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return cm.getTotal(map);
	}

	@Override
	public Integer update(Comment comment) {
		return cm.update(comment);
	}

	@Override
	public Integer deleteComment(Integer id) {
		return cm.deleteComment(id);
	}

	@Override
	public Integer deleteCommentByBlogId(Integer id) {
		return cm.deleteCommentByBlogId(id);
	}

}
