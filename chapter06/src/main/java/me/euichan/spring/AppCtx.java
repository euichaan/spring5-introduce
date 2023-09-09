package me.euichan.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("host");
		return client2;
	}
}
