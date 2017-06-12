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
import com.ssm.blog.entity.Link;
import com.ssm.blog.entity.PageBean;
import com.ssm.blog.service.LinkService;

@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {

	@Resource
	private LinkService linkService;

	// 分页显示数据
	@RequestMapping(value = "/listBlogType/{page}/{rows}", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> listBlogType(@PathVariable("page") Integer page,
			@PathVariable("rows") Integer rows) throws Exception {
		PageBean pageBean = new PageBean(page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", pageBean.getPage());// 第几页
		map.put("start", pageBean.getStart());// 起始页
		map.put("pageSize", pageBean.getPageSize());// 每页记录数
		List<Link> linkList = linkService.listLinkData(map);
		Long total = linkService.getTotal(map);// 总记录数
		map.put("datas", linkList);// 总数据
		map.put("total", total);
		return map;
	}

	@RequestMapping(value = "/save", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> save(Link link) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		if (link.getId() == null) {
			result = linkService.addLink(link);
		} else {
			result = linkService.updateLink(link);
		}
		map.put("result", result);
		return map;
	}

	@RequestMapping(value = "/deleteLink", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> deleteLink(@RequestBody Integer[] ids) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			result = linkService.deleteLink(ids[i]);
		}
		map.put("result", result);
		return map;
	}
}
