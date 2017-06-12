package com.ssm.blog.service;

import com.ssm.blog.entity.Blogger;

public interface BloggerService {
	
	// 通过用户名查询博主
	public Blogger getByUsername(String username);

	// 获取博主信息
	public Blogger getBloggerData();

	// 更新博主个人信息
	public Integer updateBlogger(Blogger blogger);
}
