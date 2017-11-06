package com.capeat.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.scheduling.annotation.EnableAsync;

import com.capeat.DAO.UserDAO;
import com.capeat.DAO.UserDAOImpl;

@Configuration

public class MvcConfig {
	
	@Bean
	public DataSource getDataSource(){
		//DriverManagerDataSource ds1=new DriverManagerDataSource();
		SimpleDriverDataSource ds=new SimpleDriverDataSource();
		ds.setDriver(new org.postgresql.Driver());
		ds.setUrl("jdbc:postgresql://capeat.cn0466qhz7wl.us-east-1.rds.amazonaws.com:5432/capEAT");
		ds.setSchema("capEAT");
		ds.setUsername("capEAT");
		ds.setPassword("test1234");
		return ds;
		
	}

	
	@Bean
	public UserDAO getArtistDAO()
	{
		return new UserDAOImpl(getDataSource());
		
	}
}
