package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;
import org.zerock.sample.Restaurant;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	//JUnit으로 단위 테스트 프레임워크 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	@Setter(onMethod_ = @Autowired)	//세터인젝션
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTimeTomorrow() {
		log.info(timeMapper.getClass().getName());			
		log.info(timeMapper.getTimeTomorrow());

				
	}
	
//	@Test
//	public void testGetTime() {
//		log.info(timeMapper.getClass().getName());			
//		log.info(timeMapper.getTime());
//
//				
//	}
	
	
	
	
}
