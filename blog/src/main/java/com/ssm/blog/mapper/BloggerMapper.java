package com.ssm.blog.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssm.blog.entity.Blogger;

public interface BloggerMapper {
	// 通过用户名查询博主
	public Blogger getByUsername(String username);

	// 获取博主信息
	public Blogger getBloggerData();

	// 更新博主个人信息
	public Integer updateBlogger(@Param("b")Blogger blogger);
}
