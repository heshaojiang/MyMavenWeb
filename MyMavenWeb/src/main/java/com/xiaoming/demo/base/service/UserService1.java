package com.xiaoming.demo.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoming.demo.base.bean.User;
import com.xiaoming.demo.base.dao.UserDao1;
@Service
@Transactional(readOnly = true)
public class UserService1 {
	@Autowired
	private UserDao1 dao;
	public User findOne(String id){
		return dao.getById(id);
		
	}
	public int insert(User user){
		return dao.insert(user);
		
	}
}
