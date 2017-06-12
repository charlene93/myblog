package com.ssm.blog.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ssm.blog.entity.Blog;
import com.ssm.blog.entity.BlogType;
import com.ssm.blog.entity.Blogger;
import com.ssm.blog.entity.Link;
import com.ssm.blog.service.BlogService;
import com.ssm.blog.service.BlogTypeService;
import com.ssm.blog.service.BloggerService;
import com.ssm.blog.service.LinkService;

@Component
public class InitBloggerData implements ServletContextListener, ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		InitBloggerData.applicationContext = applicationContext;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 先获取servlet上下文
		ServletContext context = sce.getServletContext();
		// 根据spring的上下文获取bloggerService这个bean
		BloggerService bloggerService = (BloggerService) applicationContext.getBean("bloggerService");
		// 获取博主信息
		Blogger blogger = bloggerService.getBloggerData();
		// 由于密码也获取到了，比较敏感，我们也不需要这个，所以把密码清空掉
		blogger.setPassword(null);
		// 将博主信息存入context域中
		context.setAttribute("blogger", blogger);

		// 获取友情链接信息
		LinkService linkService = (LinkService) applicationContext.getBean("linkService");
		List<Link> linkList = linkService.getLinkData();
		context.setAttribute("linkList", linkList);
		// 获取博客类别信息
		BlogTypeService blogTypeService = (BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
		context.setAttribute("blogTypeList", blogTypeList);

		// 获取博客信息，按照时间分类的
		BlogService blogService = (BlogService) applicationContext.getBean("blogService");
		List<Blog> blogTimeList = blogService.getBlogData();
		context.setAttribute("blogTimeList", blogTimeList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
