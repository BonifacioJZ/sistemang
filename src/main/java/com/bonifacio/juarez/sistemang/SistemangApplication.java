package com.bonifacio.juarez.sistemang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class SistemangApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemangApplication.class, args);
	}

}
