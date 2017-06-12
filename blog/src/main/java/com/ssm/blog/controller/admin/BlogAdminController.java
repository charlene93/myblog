package com.ssm.blog.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.blog.entity.Blog;
import com.ssm.blog.entity.PageBean;
import com.ssm.blog.service.BlogService;
import com.ssm.blog.service.CommentService;

@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;

	// 分页显示数据
	@RequestMapping(value = "/listBlogType/{page}/{rows}", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> listBlogType(@PathVariable("page") Integer page,
			@PathVariable("rows") Integer rows) throws Exception {
		PageBean pageBean = new PageBean(page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pageBean.getPage());// 第几页
		map.put("start", pageBean.getStart());// 起始页
		map.put("pageSize", pageBean.getPageSize());// 每页记录数
		List<Blog> blogList = blogService.listBlog(map);
		Long total = blogService.getTotal(map);// 总记录数
		map.put("datas", blogList);// 总数据
		map.put("total", total);
		return map;
	}

	@RequestMapping(value = "/save", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> save(Blog blog) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		if (blog.getId() == null) {
			result = blogService.addBlog(blog);
		} else {
			result = blogService.update(blog);
		}
		map.put("result", result);
		return map;
	}

	@RequestMapping(value = "/deleteBlog", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> deleteBlog(@RequestBody Integer[] ids) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			result = blogService.deleteBlog(ids[i]);
			if (result > 0) {
				commentService.deleteCommentByBlogId(ids[i]);
			}
		}
		map.put("result", result);
		return map;
	}

	// 通过id获取博客实体
	@RequestMapping(value = "/findById", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> findById(@RequestParam(value = "id", required = false) Integer id)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Blog blog = blogService.findById(id);
		map.put("datas", blog);
		return map;
	}
}
