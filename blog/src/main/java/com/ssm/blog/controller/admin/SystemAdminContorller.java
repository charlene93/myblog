package com.ssm.blog.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ssm.blog.entity.Blog;
import com.ssm.blog.entity.BlogType;
import com.ssm.blog.entity.Blogger;
import com.ssm.blog.entity.Link;
import com.ssm.blog.service.BlogService;
import com.ssm.blog.service.BlogTypeService;
import com.ssm.blog.service.BloggerService;
import com.ssm.blog.service.LinkService;

@Controller
@RequestMapping("/admin/system")
public class SystemAdminContorller {

	@Resource
	private BloggerService bloggerService;
	@Resource
	private LinkService linkService;
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;

	@RequestMapping(value = "/refreshSystemCache", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> refreshSystemCache(HttpServletRequest request) throws Exception {
		ServletContext context = RequestContextUtils.findWebApplicationContext(request).getServletContext();
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取博主信息
		Blogger blogger = bloggerService.getBloggerData();
		blogger.setPassword(null);
		context.setAttribute("blogger", blogger);

		// 获取友情链接信息
		List<Link> linkList = linkService.getLinkData();
		context.setAttribute("linkList", linkList);

		// 获取博客类别信息
		List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
		context.setAttribute("blogTypeList", blogTypeList);

		// 获取博客信息，按照时间分类的
		List<Blog> blogTimeList = blogService.getBlogData();
		context.setAttribute("blogTimeList", blogTimeList);
		map.put("success", true);
		return map;
	}
}
