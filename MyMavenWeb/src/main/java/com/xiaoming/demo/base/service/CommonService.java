package com.xiaoming.demo.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoming.demo.base.bean.User;
@Service
@Transactional(readOnly = true)
public class CommonService<T extends User,M extends User>{
	@Autowired private UserService<T> userService;
	@Autowired private UserService1 userService1;
	public T getUser(String id){
		return userService.findOne(id);
	}
	public User getUser1(String id){
		return userService1.findOne(id);
	}
	public void save(User user){
		userService1.insert(user);
	}
}
