package me.euichan.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import me.euichan.spring.ChangePasswordService;
import me.euichan.spring.MemberDao;

@Configuration
@EnableTransactionManagement
public class AppCtx {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		//org.apache.tomcat.jdbc.pool.DataSource 가 javax.sql.DataSource 를 구현한 형태
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("a87524626");
		dataSource.setInitialSize(2);
		dataSource.setMaxActive(10);
		dataSource.setTestWhileIdle(true); // 유휴 커넥션 유효한지 여부 검사
		dataSource.setMinEvictableIdleTimeMillis(1000 * 60 * 3); // 최소 유휴 시간 3분
		dataSource.setTimeBetweenEvictionRunsMillis(1000 * 10); // 10초 주기
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService changePasswordService = new ChangePasswordService();
		changePasswordService.setMemberDao(memberDao());
		return changePasswordService;
	}
}
