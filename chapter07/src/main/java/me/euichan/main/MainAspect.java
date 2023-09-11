package me.euichan.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.euichan.aop.RecCalculator;
import me.euichan.config.AppCtx;

public class MainAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		final RecCalculator cal = ctx.getBean("calculator", RecCalculator.class);
		final long fiveFact = cal.factorial(5);
		System.out.println("cal.factorial(5) = " + fiveFact);
		System.out.println(cal.getClass().getName());
		ctx.close();
	}
}
