package com.shop.biz.impl;

import java.util.List;

import com.shop.bean.User;
import com.shop.biz.UserBiz;
import com.shop.dao.DBHelper;

public class UserBizImpl implements UserBiz {
	private DBHelper db = new DBHelper();
	


	/**
	 * 
	 */
	@Override
	public int reg(String uname, String pwd, String rname, String email) {
		String sql = "insert into users values(null,?,?,?,?,0)";
		return db.update(sql, uname, pwd, rname, email);
	}
	
	/**
	 * 
	 */
	@Override
	public User login(String uname, String pwd) {
		String sql = "select * from users where uname=? and pwd=?";
		List<User> users = db.find(sql, User.class, uname, pwd);
		if(users.size()>0) {
			return users.get(0);
		}
		return null;
	}



}
