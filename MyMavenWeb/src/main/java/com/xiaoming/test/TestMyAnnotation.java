package com.xiaoming.test;

import com.xiaoming.annotation.FruitName;

public class TestMyAnnotation {
	@FruitName("Apple")
	private String fruitName;
	public TestMyAnnotation(){
		
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	
	
	public static void main(String[] args) {
		TestMyAnnotation test1 = new TestMyAnnotation();
		System.out.println(test1.getFruitName());
	}
}
