package me.euichan.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {

	private String host;

	public void send() {
		System.out.println("Client send() to " + host);
	}

	public void setHost(final String host) {
		this.host = host;
	}

	// 초기화 과정에서 빈 객체의 afterPropertiesSet 메서드를 실행한다.
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet 실행");
	}

	// 소멸 과정에서 빈 객체의 destroy 메서드를 실행한다.
	@Override
	public void destroy() throws Exception {
		System.out.println("Client.destroy 실행");
	}
}
