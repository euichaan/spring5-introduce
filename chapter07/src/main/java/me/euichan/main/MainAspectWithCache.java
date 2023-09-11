package me.euichan.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.euichan.aop.Calculator;
import me.euichan.config.AppCtxWithCache;

public class MainAspectWithCache {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			AppCtxWithCache.class);
		final Calculator calculator = ac.getBean("calculator", Calculator.class);
		calculator.factorial(7); // CacheAspect 실행 -> ExeTimeAspect 실행 -> 대상 객체 실행
		calculator.factorial(7);
		calculator.factorial(5);
		calculator.factorial(5);
		ac.close();
	}
}
