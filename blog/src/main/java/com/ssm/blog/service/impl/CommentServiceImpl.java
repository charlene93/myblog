package com.ssm.blog.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.blog.dao.CommentDao;
import com.ssm.blog.entity.Comment;
import com.ssm.blog.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentDao commentDaoImpl;
	
	@Override
	public List<Comment> getCommentData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commentDaoImpl.getCommentData(map);
	}

	@Override
	public int addComment(Comment comment) {
		return commentDaoImpl.addComment(comment);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return commentDaoImpl.getTotal(map);
	}

	@Override
	public Integer update(Comment comment) {
		return commentDaoImpl.update(comment);
	}

	@Override
	public Integer deleteComment(Integer id) {
		return commentDaoImpl.deleteComment(id);
	}

	@Override
	public Integer deleteCommentByBlogId(Integer id) {
		return commentDaoImpl.deleteCommentByBlogId(id);
	}

}
