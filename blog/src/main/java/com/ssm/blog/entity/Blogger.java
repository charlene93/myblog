package com.ssm.blog.entity;

import java.io.Serializable;
/**
 * 博主实体
 * @author cheny
 *
 */
public class Blogger implements Serializable {

	private static final long serialVersionUID = 6151896743260215677L;
	private Integer id;
	private String username;//姓名
	private String password;//密码
	private String profile;//博客信息
	private String nickname;//博主昵称
	private String sign;//博主签名
	private String imagename;//头像路劲
	public Blogger() {
		super();
	}
	public Blogger(Integer id, String username, String password, String profile, String nickname, String sign,
			String imagename) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.profile = profile;
		this.nickname = nickname;
		this.sign = sign;
		this.imagename = imagename;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	@Override
	public String toString() {
		return "Blogger [id=" + id + ", username=" + username + ", password=" + password + ", profile=" + profile
				+ ", nickname=" + nickname + ", sign=" + sign + ", imagename=" + imagename + "]";
	}
}
