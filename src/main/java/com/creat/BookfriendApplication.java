package com.creat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.creat.bookfriend.mapper")
public class BookfriendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookfriendApplication.class, args);
	}
}
