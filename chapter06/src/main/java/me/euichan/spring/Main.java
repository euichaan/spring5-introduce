package me.euichan.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 설정 정보를 이용해서 빈 객체를 생성한다.
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppCtx.class);
		// 빈 객체를 제공한다.
		final Client2 client = ac.getBean(Client2.class);
		client.send();
		client.close(); // 프로토타입 범위의 빈은 컨테이너를 종료한다고 해서 생성한 프로토타입 빈 객체의 소멸 메서드를 실행하지 않는다.
		ac.close();
	}
}
