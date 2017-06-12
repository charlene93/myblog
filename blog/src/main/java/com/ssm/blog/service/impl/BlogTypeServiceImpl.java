package com.ssm.blog.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.blog.dao.BlogTypeDao;
import com.ssm.blog.entity.BlogType;
import com.ssm.blog.service.BlogTypeService;
@Service
public class BlogTypeServiceImpl implements BlogTypeService {
	@Resource
	private BlogTypeDao blogTypeDaoImpl;

	@Override
	public List<BlogType> getBlogTypeData() {
		return blogTypeDaoImpl.getBlogTypeData();
	}

	@Override
	public BlogType findById(Integer id) {
		return blogTypeDaoImpl.findById(id);
	}

	@Override
	public List<BlogType> listBlogType(Map<String, Object> map) {
		return blogTypeDaoImpl.listBlogType(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return blogTypeDaoImpl.getTotal(map);
	}

	@Override
	public Integer addBlogType(BlogType blogType) {
		return blogTypeDaoImpl.addBlogType(blogType);
	}

	@Override
	public Integer updateBlogType(BlogType blogType) {
		return blogTypeDaoImpl.updateBlogType(blogType);
	}

	@Override
	public Integer deleteBlogType(Integer id) {
		return blogTypeDaoImpl.deleteBlogType(id);
	}

}
