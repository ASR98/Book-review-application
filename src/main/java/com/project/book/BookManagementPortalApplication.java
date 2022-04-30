package com.project.book;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementPortalApplication.class, args);
	}
//	@Bean
//    public DataSource dataSource(){
//       DriverManagerDataSource dataSource = new DriverManagerDataSource();
//       dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//       dataSource.setUrl("your url");
//       dataSource.setUsername( "username" );
//       dataSource.setPassword( "password" );
//       return dataSource;
//    }
}
