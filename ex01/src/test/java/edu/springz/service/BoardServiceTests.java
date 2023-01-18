package edu.springz.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	//JUnit으로 단위 테스트 프레임워크 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	
	public void testModify() {
		BoardVO bvo = boardService.view(3);
		if(bvo == null) return; //게시물이 없는 경우
		
		bvo.setTitle("modify TITLE");
		
		

		log.info("UPDATE RESULT : " + boardService.modify(bvo));
		

	}
	
	
	public void testRemove() {
		log.info("DELETE RESULT : " + boardService.remove(2));
		testList();

	}
	
	
	
	public void testView() {
		log.info(boardService.view(10));

	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria(3, 2);
		
		boardService.list(cri).forEach(bvo -> log.info(bvo));
		
		log.info("total count : " + boardService.totalCount(cri));

	}
	
	
	public void testRegister() {
		BoardVO bvo = new BoardVO();
		bvo.setTitle("new title SERVICE");
		bvo.setContent("new content SERVICE");
		bvo.setWriter("newbie");
		boardService.register(bvo);

		log.info("등록된 게시물 번호 : " + bvo.getBno());

	}
	
	
	public void testExists() {
		assertNotNull(boardService);
		log.info(boardService);
	}
	
	
	
}
