package com.example.aoptest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	// 특정 메서드 수행 이전에 Advice 실행
	@Before("execution(public ProductVo com.example.aoptest.ProductService.findProduct(..))")
	public void before() {
		System.out.println("[before advice] 수행");
	}
	
	// 특정 메서드 수행 이후에 Advice 실행
	@After("execution(* com.example.aoptest.*.findProduct(..))")
	public void after() {
		System.out.println("[after advice] 수행");
	}
	
	// 특정에서도 수행 이후 결과 값을 받아오는 포인트 컷
	@AfterReturning(value="execution(* *..ProductService.findProduct(..))", returning = "vo")
	public void afterReturning(ProductVo vo) {
		System.out.println("[afterReturning advice 수행, 결과 = " + vo);
	}
	
	// 예외 발생시 예외 객체를 받아오는 어드바이스
	@AfterThrowing(value="execution(* findProduct(String))", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.err.println("call [afterThrowing]: " + ex.getMessage());
		ex.printStackTrace();
		System.out.println("---------------");
		
	}
	
}
