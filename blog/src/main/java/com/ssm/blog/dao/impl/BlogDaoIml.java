package com.ssm.blog.dao.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.ssm.blog.dao.BlogDao;
import com.ssm.blog.entity.Blog;
import com.ssm.blog.mapper.BlogMapper;

@Repository
public class BlogDaoIml implements BlogDao {
	@Resource
	private BlogMapper bm;

	@Override
	public List<String> getBlogData() {
		return bm.getBlogData();
	}

	@Override
	public List<Blog> listBlog(Map<String, Object> map) {
		return bm.listBlog(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return bm.getTotal(map);
	}

	@Override
	public Blog findById(Integer id) {
		return bm.findById(id);
	}

	@Override
	public Integer update(Blog blog) {
		return bm.update(blog);
	}

	@Override
	public Blog getPrevBlog(Integer id) {
		return bm.getPrevBlog(id);
	}

	@Override
	public Blog getNextBlog(Integer id) {
		return bm.getNextBlog(id);
	}

	@Override
	public int addBlog(Blog blog) {
		return bm.addBlog(blog);
	}

	@Override
	public int deleteBlog(Integer id) {
		return bm.deleteBlog(id);
	}

	@Override
	public Integer getBlogByTypeId(Integer id) {
		return bm.getBlogByTypeId(id);
	}

}
