package com.ssm.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.blog.entity.BlogType;

public interface BlogTypeMapper {
	// 获取博客类别信息
	public List<BlogType> getBlogTypeData();

	// 根据id查找博客类型信息
	public BlogType findById(Integer id);

	// 分页查询博客类别信息
	public List<BlogType> listBlogType(@Param("map")Map<String, Object> map);

	// 获取总记录数
	public Long getTotal(Map<String, Object> map);

	// 添加博客类别
	public Integer addBlogType(@Param("b")BlogType blogType);

	// 更新博客类别
	public Integer updateBlogType(@Param("b")BlogType blogType);

	// 删除博客类别
	public Integer deleteBlogType(Integer id);
}
