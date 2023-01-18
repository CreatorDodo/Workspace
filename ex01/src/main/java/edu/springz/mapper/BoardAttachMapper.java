package edu.springz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.springz.domain.BoardAttachVO;
import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;

public interface BoardAttachMapper {
	
	public List<BoardAttachVO> yesterdayFiles();
	
	public List<BoardAttachVO> selectAttachAll(int bno);
	
	public int deleteAttach(int bno);
	
	public int insertAttach(BoardAttachVO bavo);
	
	
	
}
