package me.euichan.chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 설정 정보를 이용해서 빈 객체를 생성한다.
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppContext.class);
		// 빈 객체를 제공한다.
		Greeter g = ac.getBean("greeter", Greeter.class); // 빈 객체의 이름, 빈 객체의 타입
		String msg = g.greet("스프링");
		System.out.println(msg);
		ac.close();
	}
}
