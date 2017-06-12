package com.ssm.blog.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ssm.blog.dao.BlogTypeDao;
import com.ssm.blog.entity.BlogType;
import com.ssm.blog.mapper.BlogTypeMapper;

@Repository
public class BlogTypeDaoImpl implements BlogTypeDao {
	@Resource
	private BlogTypeMapper btm;

	@Override
	public List<BlogType> getBlogTypeData() {
		return btm.getBlogTypeData();
	}

	@Override
	public BlogType findById(Integer id) {
		return btm.findById(id);
	}

	@Override
	public List<BlogType> listBlogType(Map<String, Object> map) {
		return btm.listBlogType(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return btm.getTotal(map);
	}

	@Override
	public Integer addBlogType(BlogType blogType) {
		return btm.addBlogType(blogType);
	}

	@Override
	public Integer updateBlogType(BlogType blogType) {
		return btm.updateBlogType(blogType);
	}

	@Override
	public Integer deleteBlogType(Integer id) {
		return btm.deleteBlogType(id);
	}

}
