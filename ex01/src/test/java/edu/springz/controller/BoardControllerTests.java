package edu.springz.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	//JUnit으로 단위 테스트 프레임워크 지정
@ContextConfiguration({
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
@Log4j
public class BoardControllerTests {
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	
	public void testRemove() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
										.post("/board/remove")
										.param("bno", "6")
										)
						.andReturn()
						.getModelAndView()
						.getViewName()
			);
			testList();
		}
	
	
	public void testModify() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
										.post("/board/modify")
										.param("title", "modify title CONTROLLER")
										.param("content", "modify content CONTROLLER")
										.param("bno", "8")
										)
						.andReturn()
						.getModelAndView()
						.getViewName()
			);
			testList();
		}
	
	
	public void testView() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/view")
														.param("bno", "1"))
						.andReturn()
						.getModelAndView()
						.getModelMap()
			);
		}
	
	
	
	
	
	
	public void testRegister() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
										.post("/board/register")
										.param("title", "new title CONTROLLER")
										.param("content", "new content CONTROLLER")
										.param("writer", "aaa")
										)
						.andReturn()
						.getModelAndView()
						.getViewName()
			);
			testList();
		}
	
	@Test
	public void testList() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("amount", "3")
				.param("pageNum", "2")
				)
						.andReturn()
						.getModelAndView()
						.getModelMap()
			);
		}
}
