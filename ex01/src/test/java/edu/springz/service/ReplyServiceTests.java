package edu.springz.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	//JUnit으로 단위 테스트 프레임워크 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	@Setter(onMethod_ = @Autowired)
	private ReplyService replyService;
	
	
	public void testModify() {
		ReplyVO rvo = replyService.view(2);
		if(rvo == null) return;
		
		rvo.setReply("modify REPLY");
		
		

		log.info("UPDATE RESULT : " + replyService.modify(rvo));
		

	}
	
	
	public void testRemove() {
		log.info("DELETE RESULT : " + replyService.remove(2));
		testList();

	}
	
	
	
	public void testView() {
		log.info(replyService.view(9));

	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria(3, 1);
		
//		replyService.list(cri, 7).forEach(rvo -> log.info(rvo));
		
		log.info("total count : " + replyService.totalReply(7));

	}
	
	
	public void testRegister() {
		ReplyVO rvo = new ReplyVO();
		rvo.setBno(1);
		rvo.setReply("댓글1");
		rvo.setReplyer("댓글러");
		replyService.register(rvo);

		log.info("등록된 게시물 번호 : " + rvo.getBno());

	}
	
	
	public void testExists() {
		assertNotNull(replyService);
		log.info(replyService);
	}
	
	
	
}
