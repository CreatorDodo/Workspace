package edu.springz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;

public interface ReplyMapper {
	
	public int totalReply(int bno);	//토탈
	
	public List<ReplyVO> selectReplyAllPaging(@Param("cri") Criteria cri, @Param("bno") int bno);	//전체 댓글 목록 페이징
	
//	public List<ReplyVO> selectReplyAll();	//전체 댓글 목록
	
	public ReplyVO selectReply(int rno);	//댓글 하나
	
	public int updateReply(ReplyVO rvo); //댓글 수정
	
	public int deleteReply(int rno); //댓글 삭제
	
	public int insertReply(ReplyVO rvo);
	
	
	
}
