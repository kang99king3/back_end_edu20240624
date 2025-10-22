package com.hk.board.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //스프링 환경설정 클래스 선언: root-context.xml, servlet-context.xml을 자바로 대체
@EnableTransactionManagement //선언해줘야 @Transactional을 사용할 수 있다
public class TransactionConfig {

	@Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
