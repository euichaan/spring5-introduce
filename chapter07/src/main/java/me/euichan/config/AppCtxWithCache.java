package me.euichan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import me.euichan.aop.CacheAspect;
import me.euichan.aop.Calculator;
import me.euichan.aop.ExeTimeAspect;
import me.euichan.aop.RecCalculator;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxWithCache {

	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}

	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}

	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}
}
