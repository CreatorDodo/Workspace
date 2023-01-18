package edu.springz.service;

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
public class SampleTxServiceTests {
	@Setter(onMethod_ = @Autowired)
	private SampleTxService service;
	
	@Test
	public void testAround() throws Exception {
		service.addCol("xyzzzzzzzz12345678");
		
	}
}
