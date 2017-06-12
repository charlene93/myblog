package com.ssm.blog.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ssm.blog.dao.LinkDao;
import com.ssm.blog.entity.Link;
import com.ssm.blog.mapper.LinkMapper;

@Repository
public class LinkDaoImpl implements LinkDao {
	@Resource
	private LinkMapper lm;

	@Override
	public List<Link> getLinkData() {
		return lm.getLinkData();
	}

	@Override
	public List<Link> listLinkData(Map<String, Object> map) {
		return lm.listLinkData(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return lm.getTotal(map);
	}

	@Override
	public Integer addLink(Link link) {
		return null;
	}

	@Override
	public Integer updateLink(Link link) {
		return lm.updateLink(link);
	}

	@Override
	public Integer deleteLink(Integer id) {
		return lm.deleteLink(id);
	}

}
