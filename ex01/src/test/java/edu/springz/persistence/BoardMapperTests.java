package edu.springz.persistence;

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

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit으로 단위 테스트 프레임워크 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired) // 세터인젝션
	private BoardMapper boardMapper;

	@Test
	public void testSearch() {
		Criteria cri = new Criteria();	//기본 값 - 한 페이지에 3개씩 1번째 1페이지
		cri.setType("W");	//작성자에서 검색
//		cri.setType("TC");	//제목과 내용에서 검색
		cri.setKeyword("aaa");
		boardMapper.selectBoardAllPaging(cri).forEach(bvo -> log.info(bvo));
	}
	
	
	public void testSelectAllPaging() {
		Criteria cri = new Criteria();	//기본 값 - 한 페이지에 3개씩 1번째 1페이지
		cri = new Criteria(3, 1);	//한 페이지에 3개씩 3번째 페이지
		boardMapper.selectBoardAllPaging(cri).forEach(bvo -> log.info(bvo));
		
		log.info("total count : " + boardMapper.totalCount(cri));

	}

	
	
	
	public void testUpdate() {
		BoardVO bvo = new BoardVO();
		bvo.setBno(4);
		bvo.setTitle("update title");
		bvo.setContent("update content");
		
		

		log.info("UPDATE COUNT : " + boardMapper.updateBoard(bvo));
		

	}

	public void testDelete() {
		log.info("DELETE COUNT : " + boardMapper.deleteBoard(5));
		testSelectAll();

	}

	public void testInsertSelectKey() {
		BoardVO bvo = new BoardVO();
		bvo.setTitle("new title");
		bvo.setContent("new content");
		bvo.setWriter("newbie");
		boardMapper.insertBoardSelectKey(bvo);

		log.info(bvo);

	}

	public void testInsert() {
		BoardVO bvo = new BoardVO();
		bvo.setTitle("new title");
		bvo.setContent("new content");
		bvo.setWriter("newbie");
//		boardMapper.insertBoard(bvo);

		log.info(bvo);

	}

	public void testSelect() {
		log.info(boardMapper.selectBoard(5));

	}
	
	
	public void testSelectAll() {
//		boardMapper.selectBoardAll().forEach(bvo -> log.info(bvo));

	}

}
