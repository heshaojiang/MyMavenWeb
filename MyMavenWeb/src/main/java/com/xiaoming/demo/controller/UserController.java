package com.xiaoming.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoming.demo.base.bean.User;
import com.xiaoming.demo.base.service.CommonService;
import com.xiaoming.demo.real.bean.UserReal;
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private CommonService<UserReal, User> reService;
	@ResponseBody
	@RequestMapping(value = "test")
	public User test(){
		//UserReal user = reService.getUser("93db7b6afeb44ec4b3c458e60d837daa");
		UserReal user = (UserReal) reService.getUser1("93db7b6afeb44ec4b3c458e60d837daa");
		UserReal user1 = new UserReal();
		user1.setId("2");
		user1.setSysId("1");
		user1.setParentId("-1");
		user1.setUsername("hesj");
		user1.setPassword("11");
		user1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		reService.save((User)user1);
		return user;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "save")
	public boolean save(User user, HttpServletRequest request){
		UserReal user1 = (UserReal) user;
		return true;
	}
}
