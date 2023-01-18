package edu.springz.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.ConstructorArgs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyPageDTO;
import edu.springz.domain.ReplyVO;
import edu.springz.mapper.BoardMapper;
import edu.springz.mapper.ReplyMapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper replyMapper;
	private BoardMapper boardMapper;

	@Override
	public boolean modify(ReplyVO rvo) {
	
		return replyMapper.updateReply(rvo) == 1 ? true : false;
	}
	
	@Transactional
	@Override
	public boolean remove(int rno) {
		ReplyVO rvo = replyMapper.selectReply(rno);
		boardMapper.updateReplyCnt(rvo.getBno(), -1);
		return replyMapper.deleteReply(rno) == 1 ? true : false;
	}
	
	@Transactional
	@Override
	public boolean register(ReplyVO rvo) {
		boardMapper.updateReplyCnt(rvo.getBno(), 1);
		return replyMapper.insertReply(rvo) == 1 ? true : false;
	}

	@Override
	public ReplyPageDTO list(Criteria cri, int bno) {
		return new ReplyPageDTO(replyMapper.totalReply(bno),
				replyMapper.selectReplyAllPaging(cri, bno));
	}

	@Override
	public int totalReply(int bno) {
		int total = replyMapper.totalReply(bno);
		return total;
	}
	
	@Override
	public ReplyVO view(int rno) {
		return replyMapper.selectReply(rno);
	}

	
	
}
