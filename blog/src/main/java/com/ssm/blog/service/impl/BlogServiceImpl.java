package com.ssm.blog.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.ssm.blog.dao.BlogDao;
import com.ssm.blog.entity.Blog;
import com.ssm.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	private BlogDao blogDaoImpl;

	@Override
	public List<String> getBlogData() {
		return blogDaoImpl.getBlogData();
	}

	@Override
	public List<Blog> listBlog(Map<String, Object> map) {
		return blogDaoImpl.listBlog(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogDaoImpl.getTotal(map);
	}

	@Override
	public Blog findById(Integer id) {
		return blogDaoImpl.findById(id);
	}

	@Override
	public Integer update(Blog blog) {
		return blogDaoImpl.update(blog);
	}

	@Override
	public Blog getPrevBlog(Integer id) {
		return blogDaoImpl.getPrevBlog(id);
	}

	@Override
	public Blog getNextBlog(Integer id) {
		return blogDaoImpl.getNextBlog(id);
	}

	@Override
	public int addBlog(Blog blog) {
		return blogDaoImpl.addBlog(blog);
	}

	@Override
	public int deleteBlog(Integer id) {
		return blogDaoImpl.deleteBlog(id);
	}

	@Override
	public Integer getBlogByTypeId(Integer id) {
		return blogDaoImpl.getBlogByTypeId(id);
	}

}
