package com.xiaoming.webService.service;

import javax.jws.WebService;

@WebService(endpointInterface="com.xiaoming.webService.service.MyWebService",serviceName="myWebService")
public class MyWebServiceImpl implements MyWebService{

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return "hello";
	}

}
