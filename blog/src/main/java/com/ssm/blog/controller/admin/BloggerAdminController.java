package com.ssm.blog.controller.admin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ssm.blog.entity.Blogger;
import com.ssm.blog.service.BloggerService;
import com.ssm.blog.utils.DateUtil;

@RequestMapping("/admin/blogger")
@Controller
public class BloggerAdminController {
	@Resource
	private BloggerService bloggerService;

	// 查询博主信息
	@RequestMapping(value = "/findBlogger", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> findBlogger() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Blogger blogger = bloggerService.getBloggerData();
		map.put("blogger", blogger);
		return map;
	}

	// 修改博主信息
	@RequestMapping(value = "/save", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> save(@RequestParam("imageFile") CommonsMultipartFile imageFile,
			Blogger blogger, HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!imageFile.isEmpty()) { // 如果用户有传过照片，就更新
			String filePath = request.getServletContext().getRealPath("/"); // 获取服务器根路径
			String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
			imageFile.transferTo(new File(filePath + "static/userImages/" + imageName));
			blogger.setImagename(imageName);
		}
		int result = bloggerService.updateBlogger(blogger);
		map.put("result", result);
		return map;
	}

	// 修改博主密码
	@RequestMapping(value = "/modifyPassword", produces = { "application/json;charset=utf-8" })
	public @ResponseBody Map<String, Object> modifyPassword(@RequestParam("password") String password)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Blogger blogger = new Blogger();
		// blogger.setPassword(CryptographyUtil.md5(password, "javacoder"));
		int result = bloggerService.updateBlogger(blogger);
		map.put("result", result);
		return map;
	}
}
