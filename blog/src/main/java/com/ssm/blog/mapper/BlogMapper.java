package com.ssm.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.blog.entity.Blog;

public interface BlogMapper {

	// 获取博客信息，根据日期月份分组查询
	public List<Blog> getBlogData();

	// 分页查询博客
	public List<Blog> listBlog(@Param("map") Map<String, Object> map);

	// 获取总记录数
	public Long getTotal(@Param("map") Map<String, Object> map);

	// 根据id获取博客
	public Blog findById(Integer id);

	// 更新博客信息
	public Integer update(@Param("b") Blog blog);

	// 获取上一篇博客
	public Blog getPrevBlog(Integer id);

	// 获取下一篇博客
	public Blog getNextBlog(Integer id);

	// 添加博客
	public int addBlog(@Param("b") Blog blog);

	// 删除博客
	public int deleteBlog(Integer id);

	// 根据博客类型的id查询该类型下的博客数量
	public Integer getBlogByTypeId(Integer id);
}
