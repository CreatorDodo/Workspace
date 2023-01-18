package edu.springz.service;

import java.util.List;

import edu.springz.domain.BoardAttachVO;
import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;

public interface BoardService {
	
	public List<BoardAttachVO> attachList(int bno);	//전체 첨부파일 목록
	
	public boolean modify(BoardVO bvo); //게시물 수정
	
	public boolean remove(int bno); //게시물 삭제
	
	public boolean register(BoardVO bvo);	//사전에 bno 증가 후 insert 수행
	
	public int totalCount(Criteria cri); 	//전체 게시물 수
	
	public List<BoardVO> list(Criteria cri);	//전체 게시물 목록 페이징
	
	public BoardVO view(int bno);	//게시물 하나
	
	
	
	
	
}
