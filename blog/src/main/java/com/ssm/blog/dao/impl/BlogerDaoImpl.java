package com.ssm.blog.dao.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.ssm.blog.dao.BloggerDao;
import com.ssm.blog.entity.Blogger;
import com.ssm.blog.mapper.BloggerMapper;
@Repository
public class BlogerDaoImpl implements BloggerDao {
	@Resource
	private BloggerMapper blogerMapper;

	@Override
	public Blogger getByUsername(String username) {
		return blogerMapper.getByUsername(username);
	}

	@Override
	public Blogger getBloggerData() {
		return blogerMapper.getBloggerData();
	}

	@Override
	public Integer updateBlogger(Blogger blogger) {
		return blogerMapper.updateBlogger(blogger);
	}

}
