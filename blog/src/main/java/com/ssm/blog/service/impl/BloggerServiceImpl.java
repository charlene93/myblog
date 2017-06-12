package com.ssm.blog.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.blog.dao.BloggerDao;
import com.ssm.blog.entity.Blogger;
import com.ssm.blog.service.BloggerService;

@Service
public class BloggerServiceImpl implements BloggerService {
	@Resource
	private BloggerDao bloggerDaoImpl;

	@Override
	public Blogger getByUsername(String username) {
		return bloggerDaoImpl.getByUsername(username);
	}

	@Override
	public Blogger getBloggerData() {
		return bloggerDaoImpl.getBloggerData();
	}

	@Override
	public Integer updateBlogger(Blogger blogger) {
		return bloggerDaoImpl.updateBlogger(blogger);
	}

}
