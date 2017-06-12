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
import com.ssm.blog.entity.BlogType;
import com.ssm.blog.entity.PageBean;
import com.ssm.blog.service.BlogService;
import com.ssm.blog.service.BlogTypeService;

@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;

	// 分页显示数据
	@RequestMapping(value = "/listBlogType/{page}/{rows}", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> listBlogType(@PathVariable("page") Integer page,
			@PathVariable("rows") Integer rows) throws Exception {
		PageBean pageBean = new PageBean(page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pageBean.getPage());// 第几页
		map.put("start", pageBean.getStart());// 起始页
		map.put("pageSize", pageBean.getPageSize());// 每页记录数
		List<BlogType> blogTypeList = blogTypeService.listBlogType(map);
		Long total = blogService.getTotal(map);// 总记录数
		map.put("datas", blogTypeList);// 总数据
		map.put("total", total);
		return map;
	}

	// 添加于更新博客
	@RequestMapping(value = "/save", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> save(BlogType blogType) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		if (blogType.getId() == null) {
			result = blogTypeService.addBlogType(blogType);
		} else {
			result = blogTypeService.updateBlogType(blogType);
		}
		map.put("result", result);
		return map;
	}

	// 删除博客
	@RequestMapping(value = "/delete", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> delete(@RequestBody Integer[] ids) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			if (blogService.getBlogByTypeId(ids[i]) > 0) {
				map.put("exist", "该类别下有博客，不能删除!");
			} else {
				result = blogTypeService.deleteBlogType(ids[i]);
			}
		}
		map.put("result", result);
		return map;
	}

}
