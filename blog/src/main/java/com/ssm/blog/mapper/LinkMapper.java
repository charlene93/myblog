package com.ssm.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssm.blog.entity.Link;

public interface LinkMapper {
	
	// 获取友情链接
	public List<Link> getLinkData();

	// 分页获取友情链接
	public List<Link> listLinkData(@Param("map")Map<String, Object> map);

	// 获取总记录数
	public Long getTotal(@Param("map")Map<String, Object> map);

	// 添加友情链接
	public Integer addLink(Link link);

	// 更新友情链接
	public Integer updateLink(Link link);

	// 删除友情链接
	public Integer deleteLink(Integer id);
}
