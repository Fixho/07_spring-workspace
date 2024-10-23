package com.br.sbatis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.br.sbatis.aop.AfterLoggingAdvice;
import com.br.sbatis.aop.AroundLoggingAdvice;
import com.br.sbatis.aop.BeforeLoggingAdvice;

@EnableAspectJAutoProxy
@Configuration
public class SpringBeanConfig {
	//자바 방법으로 빈 등록한거 빈 등록은 자바, xml, 어노테이션 이용이 있음
	//자바 로 등록할땐 @위에 proxy 사용해야함
	
	@Bean
	public BeforeLoggingAdvice beforeLoggingAdvice() {
		return new BeforeLoggingAdvice();
	}
	
	@Bean
	public AfterLoggingAdvice afterLoggingADvice() {
		return new AfterLoggingAdvice();
	}
	
	@Bean
	public AroundLoggingAdvice aroundLoggingAdvice() {
		return new AroundLoggingAdvice();
	}
	
	
	
	
}
