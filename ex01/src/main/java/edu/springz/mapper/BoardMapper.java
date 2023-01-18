package edu.springz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;



public interface BoardMapper {
	

	public int totalCount(Criteria cri);	//토탈
	
	public int updateReplyCnt(@Param("bno") int bno, @Param("num") int num); //댓글 수 수정
	
	public List<BoardVO> selectBoardAllPaging(Criteria cri);	//전체 게시물 목록 페이징
	
	public int updateBoard(BoardVO bvo); //게시물 수정
	
	public int deleteBoard(int bno); //게시물 삭제
	
	public int insertBoardSelectKey(BoardVO bvo);	//사전에 bno 증가 후 insert 수행
	
//	public List<BoardVO> selectBoardAll();	//전체 게시물 목록
	
	public BoardVO selectBoard(int bno);	//게시물 하나
	
//	public void insertBoard(BoardVO bvo);	//게시물 등록 insert만 수행

	
}
