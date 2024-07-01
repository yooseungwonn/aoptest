package com.example.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// 컨텍스트 확보
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.class);
		
		ProductVo vo = ps.findProduct("목탁");		
		System.out.println("검색된 제품: " + vo);
		
		vo = ps.findProduct("bomb");		
		System.out.println("검색된 제품: " + vo);
	}

}
