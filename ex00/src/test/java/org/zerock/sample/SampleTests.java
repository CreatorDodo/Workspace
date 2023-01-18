package org.zerock.sample;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	//JUnit으로 단위 테스트 프레임워크 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	@Setter(onMethod_ = @Autowired)
	private Hotel hotel;
	
	@Test
	public void testHotelExists() {
		assertNotNull(hotel);
		
		log.info(hotel);
		log.info("-----------------------");
		log.info(hotel.getChef());
	}
	
	public void testExists() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("-----------------------");
		log.info(restaurant.getChef());
	}
}
