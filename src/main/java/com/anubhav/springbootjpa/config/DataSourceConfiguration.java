package com.anubhav.springbootjpa.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix = "com.springbootjpa.datasource")
	public DataSource dataSource() {
		HikariDataSource hikariDataSource=(HikariDataSource) DataSourceBuilder.create().build();
		return hikariDataSource;
	}

}
