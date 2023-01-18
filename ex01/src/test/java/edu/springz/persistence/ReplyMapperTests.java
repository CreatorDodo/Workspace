package edu.springz.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.stream.IntStream;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;
import edu.springz.mapper.BoardMapper;
import edu.springz.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit으로 단위 테스트 프레임워크 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Setter(onMethod_ = @Autowired) // 세터인젝션
	private ReplyMapper replyMapper;
	
	//실제 게시판의 게시물 번호
	private int[] bnoArr = {1, 4, 5, 6, 7};
	
	
	public void testUpdate() {
		
//		ReplyVO rvo = replyMapper.selectReply(5);
//		rvo.setReply("hello");	
		
	ReplyVO rvo = new ReplyVO();
	rvo.setRno(1);
	rvo.setReply("hello");

	log.info("UPDATE COUNT : " + replyMapper.updateReply(rvo));
	
	}

	
	public void testDelete() {
	log.info("DELETE COUNT : " + replyMapper.deleteReply(1));
	testSelectAllPaging();

}
	@Test
	public void testSelectAllPaging() {
	Criteria cri = new Criteria(3,1);	//기본 값 - 한 페이지에 3개씩 1번째 1페이지
//	cri = new Criteria(3, 1);
	replyMapper.selectReplyAllPaging(cri, 7).forEach(rvo -> log.info(rvo));
	
	log.info("total Reply : " + replyMapper.totalReply(7));

}




	
//	public void testSelectAll() {
//		replyMapper.selectReplyAll().forEach(rvo -> log.info(rvo));
//
//	}
	
	public void testSelect() {
		log.info(replyMapper.selectReply(5));

	}
	
	public void testInsert() {
		//각 게시물에 2개씩 댓글 등록
		IntStream.rangeClosed(1, 10)
				 .forEach(i -> {
						ReplyVO rvo = new ReplyVO();
						rvo.setBno(bnoArr[i % 5]);
						rvo.setReply("댓글 테스트" + i);
						rvo.setReplyer("replyer" + i);
						replyMapper.insertReply(rvo);
				 });



		

	}
	
	public void testMapper() {
		log.info(replyMapper);

	}
	
	
//	public void testSearch() {
//		Criteria cri = new Criteria();	//기본 값 - 한 페이지에 3개씩 1번째 1페이지
//		cri.setType("W");	//작성자에서 검색
////		cri.setType("TC");	//제목과 내용에서 검색
//		cri.setKeyword("aaa");
//		boardMapper.selectBoardAllPaging(cri).forEach(bvo -> log.info(bvo));
//	}
//	
//	



	
	


}
