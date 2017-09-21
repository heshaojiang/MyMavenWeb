package test.annotation;

import org.junit.Assert;
import org.junit.Test;

import com.xiaoming.test.TestMyAnnotation;



public class TestAnnotation {
	@Test
	public void method1(){
		
		TestMyAnnotation test = new TestMyAnnotation();
		Assert.assertEquals(test.getFruitName(),"Apple");
	}
}
