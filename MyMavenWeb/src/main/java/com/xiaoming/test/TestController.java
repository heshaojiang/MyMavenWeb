package com.xiaoming.test;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minstone.common.util.Tools;
//import com.minstone.pms.indi.controller.IndiController;
import com.xiaoming.test.dao.TestDao;

@Controller
@RequestMapping(value="/test")
public class TestController {
	@Autowired TestDao dao;
	@RequestMapping(value="/hello")
	public String hello() throws Exception{
		//Tools.isEmpty("");
		//IndiController s = new IndiController();
		//s.toForm();
		return "MyJsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/getData")
	public Map getData(){
		Map map = dao.getUser("bfd7f1dfe46c4a0faaf59b304d23aaed");
		map.remove("CREATE_TIME");
		map.remove("UPDATE_TIME");
		return map;
	}
}
