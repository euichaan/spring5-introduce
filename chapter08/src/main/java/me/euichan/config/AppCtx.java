package me.euichan.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
		return dataSource;
	}
}
