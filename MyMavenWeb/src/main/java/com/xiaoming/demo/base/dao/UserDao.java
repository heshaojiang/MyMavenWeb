package com.xiaoming.demo.base.dao;

import com.xiaoming.demo.base.bean.User;

public interface  UserDao<T extends User> {
	public T getById(String id);
}
