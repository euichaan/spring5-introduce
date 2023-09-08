package me.euichan.config;

import static org.springframework.context.annotation.ComponentScan.*;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import me.euichan.spring.MemberDao;
import me.euichan.spring.MemberPrinter;

@Configuration
@ComponentScan(basePackages = {"me.euichan.spring"},
               excludeFilters = @Filter(type = FilterType.ANNOTATION,
			   classes = {NoProduct.class, ManualBean.class}))
public class AppWithExclude {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
}
