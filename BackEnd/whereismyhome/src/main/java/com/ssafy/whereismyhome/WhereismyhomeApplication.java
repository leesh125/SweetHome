package com.ssafy.whereismyhome;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ssafy.whereismyhome.repository", annotationClass = Mapper.class)
@SpringBootApplication
public class WhereismyhomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhereismyhomeApplication.class, args);
	}

}
