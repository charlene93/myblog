package com.ssm.blog.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.blog.entity.Comment;
import com.ssm.blog.entity.PageBean;
import com.ssm.blog.service.CommentService;

@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {

	@Resource
	private CommentService commentServiceImpl;

	@RequestMapping("/listComment/{page}/{rows}/{state}")
	public @ResponseBody Map<String, Object> listBlog(@PathVariable("page") Integer page,
			@PathVariable("rows") Integer rows, @PathVariable("state") Integer state) throws Exception {
		PageBean pageBean = new PageBean(page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pageBean.getPage());// 第几页
		map.put("start", pageBean.getStart());// 起始页
		map.put("pageSize", pageBean.getPageSize());// 每页记录数
		map.put("state", state);
		List<Comment> commentList = commentServiceImpl.getCommentData(map);
		Long total = commentServiceImpl.getTotal(map);
		map.put("datas", commentList);
		map.put("total", total);
		return map;
	}

	// 评论审核
	@RequestMapping(value = "/review/{state}", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> review(@RequestBody Integer[] ids, @PathVariable("state") Integer state)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		Comment comment = null;
		for (int i = 0; i < ids.length; i++) {
			comment = new Comment();
			comment.setId(ids[i]);
			comment.setState(state);
			result = commentServiceImpl.update(comment);
		}
		map.put("result", result);
		return map;
	}

	// 评论信息删除
	@RequestMapping(value = "/deleteComment", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> delete(@RequestBody Integer[] ids) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			result = commentServiceImpl.deleteComment(ids[i]);
		}
		map.put("result", result);
		return map;
	}
}
