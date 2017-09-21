package com.xiaoming.demo.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoming.demo.base.bean.User;
import com.xiaoming.demo.base.dao.UserDao;
@Service
@Transactional(readOnly = true)
public class UserService<T extends User> {
	@Autowired
	private UserDao<T> dao;
	public T findOne(String id){
		return dao.getById(id);
		
	}
}
