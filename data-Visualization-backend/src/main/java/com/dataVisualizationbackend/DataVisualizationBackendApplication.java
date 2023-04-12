package com.dataVisualizationbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

@SpringBootApplication
public class DataVisualizationBackendApplication {//implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ResourceLoader resourceLoader;

	public static void main(String[] args) {
		SpringApplication.run(DataVisualizationBackendApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Resource resource = resourceLoader.getResource("classpath:org/springframework/batch/core/schema-mysql.sql");
//		ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
//	}

}
