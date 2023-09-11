package me.euichan.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.euichan.aop.Calculator;
import me.euichan.config.AppCtx;

public class MainAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		final Calculator cal = ctx.getBean("calculator", Calculator.class);
		final long fiveFact = cal.factorial(5);
		System.out.println("cal.factorial(5) = " + fiveFact);
		System.out.println(cal.getClass().getName());
		ctx.close();
	}
}
