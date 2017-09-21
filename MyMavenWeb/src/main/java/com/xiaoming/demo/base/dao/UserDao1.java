package com.xiaoming.demo.base.dao;

import com.xiaoming.demo.base.bean.User;

public interface  UserDao1 {
	public User getById(String id);
	public int insert(User user);
}
