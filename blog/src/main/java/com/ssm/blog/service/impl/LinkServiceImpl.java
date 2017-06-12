package com.ssm.blog.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ssm.blog.dao.LinkDao;
import com.ssm.blog.entity.Link;
import com.ssm.blog.service.LinkService;
@Service
public class LinkServiceImpl implements LinkService {
	@Resource
	private LinkDao linkDaoImpl;
	
	@Override
	public List<Link> getLinkData() {
		return linkDaoImpl.getLinkData();
	}

	@Override
	public List<Link> listLinkData(Map<String, Object> map) {
		return linkDaoImpl.listLinkData(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return linkDaoImpl.getTotal(map);
	}

	@Override
	public Integer addLink(Link link) {
		return linkDaoImpl.addLink(link);
	}

	@Override
	public Integer updateLink(Link link) {
		return linkDaoImpl.updateLink(link);
	}

	@Override
	public Integer deleteLink(Integer id) {
		return linkDaoImpl.deleteLink(id);
	}

}
