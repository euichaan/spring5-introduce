package me.euichan.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 설정 정보를 이용해서 빈 객체를 생성한다.
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppCtx.class);
		// 빈 객체를 제공한다.
		final Client client = ac.getBean(Client.class);
		client.send();
		ac.close();
	}
}
