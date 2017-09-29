package com.creat;

import com.creat.bookfriend.interceptor.AllowOriginInterceptor;
import com.creat.bookfriend.interceptor.LoginInterceptor;
import com.creat.bookfriend.interceptor.UserInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.creat.bookfriend.mapper")
public class BookfriendApplication extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AllowOriginInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new UserInterceptor())
				.addPathPatterns("/user/**")
				.excludePathPatterns("/user/login")
				.excludePathPatterns("/user/sendSMS")
				.excludePathPatterns("/user/register")
				.excludePathPatterns("/user/getInterestUser")
				.excludePathPatterns("/user/getUserNameByUserInfoId")
				.excludePathPatterns("/user/getUserInfoById")
				.addPathPatterns("/picture/**")
				.excludePathPatterns("/picture/getMainPicture")
				.addPathPatterns("/bookInfo/**")
				.excludePathPatterns("/bookInfo/getDetailBookInfo")
				.excludePathPatterns("/bookInfo/searchBooks")
				.excludePathPatterns("/bookInfo/getSameCityBooks")
				.excludePathPatterns("/bookInfo/getInterestBooks")
				.excludePathPatterns("/bookInfo/getPublishedBookByUserId")
				.addPathPatterns("/attention/**");
	}

	public static void main(String[] args) {
		SpringApplication.run(BookfriendApplication.class, args);
	}
}
