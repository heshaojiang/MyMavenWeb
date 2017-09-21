package com.xiaoming.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect  
public class AspectJTest {  
    @Pointcut("execution(* *.test(..))")  
    public void test(){  
          
    }  
      
    @Before("test()")  
    public void beforeTest(){  
        System.out.println("beforeTest");  
    }  
      
    @Around("test()")  
    public Object aroundTest(ProceedingJoinPoint p){  
        System.out.println("before1");  
        Object o = null;  
        try{  
            o = p.proceed();  
        }catch(Throwable e){  
            e.printStackTrace();  
        }  
        System.out.println("after1");  
        return o;  
    }  
      
      
    public static void main(String[] args) {  
        ApplicationContext bf = new ClassPathXmlApplicationContext("config/spring-aop.xml");  
        TestBean bean = (TestBean)bf.getBean("test");  
        bean.test();  
    }  
}