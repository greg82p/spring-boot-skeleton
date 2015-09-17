package com.greg82p.skeleton.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = "com.greg82p.skeleton", excludeFilters = { @ComponentScan.Filter(Configuration.class) })
@Import(MvcConfig.class)
public class CoreConfig {

//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setScriptEncoding("UTF-8")
//				.ignoreFailedDrops(true).addScript("schema.sql").build();
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}

}