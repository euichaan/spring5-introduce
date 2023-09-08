package me.euichan.chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Greeter greeter() { // 객체 생성, 초기화
		Greeter g = new Greeter(); // 생성
		g.setFormat("%s, 안녕하세요!"); // 초기화
		return g;
	}
}
