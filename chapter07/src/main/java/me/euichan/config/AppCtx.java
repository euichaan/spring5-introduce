package me.euichan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import me.euichan.aop.Calculator;
import me.euichan.aop.ExeTimeAspect;
import me.euichan.aop.RecCalculator;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtx {

	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}

	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}
}
