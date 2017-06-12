package com.ssm.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.blog.entity.BlogType;

@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
	@RequestMapping(value = "/save", produces = { "application/json;charset=utf-8" })
	public @ResponseBody String save(BlogType blogType) {

		return null;
	}
}
