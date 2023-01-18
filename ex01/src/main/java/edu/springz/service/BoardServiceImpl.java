package edu.springz.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.ConstructorArgs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.springz.domain.BoardAttachVO;
import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.mapper.BoardAttachMapper;
import edu.springz.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	private BoardAttachMapper boardAttachMapper;
	
	
	
	@Override
	public List<BoardAttachVO> attachList(int bno) {
		return boardAttachMapper.selectAttachAll(bno);
	}
	
	
	@Transactional
	@Override
	public boolean modify(BoardVO bvo) {
		boardAttachMapper.deleteAttach(bvo.getBno());
		
		
		int resultOne = boardMapper.updateBoard(bvo);
		int resultTwo = 0;
		
		
		
		
		//첨부파일이 없으면
		if(bvo.getAttachList() == null || bvo.getAttachList().size() < 1 ) { //첨부파일이 있는 경우
			

			
			
			if (resultOne == 1 && resultTwo == 1) {
				return true;
			}
			
			return false;
			
			

			
			
		}else {
			
			List<BoardAttachVO> list = bvo.getAttachList();
			
			for (int i = 0; i < list.size(); i++) {
				
			
			BoardAttachVO bavo = new BoardAttachVO();
			bavo.setBno(bvo.getBno());
			bavo.setFileName(list.get(i).getFileName());
			bavo.setImage(list.get(i).isImage());
			bavo.setUpFolder(list.get(i).getUpFolder());
			bavo.setUuid(list.get(i).getUuid());
			
			
			
			
			resultTwo = boardAttachMapper.insertAttach(bavo);
			
			
			}
			
			if (resultOne == 1 && resultTwo == 1) {
				return true;
			}
			
			return false;
			
		}
		
//		return boardMapper.updateBoard(bvo) == 1 ? true : false;

	}
	
	@Transactional
	@Override
	public boolean remove(int bno) {
		boardAttachMapper.deleteAttach(bno);	//기존 첨부파일 모두 삭제
		
		
		int result = boardMapper.deleteBoard(bno);

		
		if (result == 1) {
			return true;
		}
		
		return false;
	}
	
	@Transactional
	@Override
	public boolean register(BoardVO bvo) {
		int resultOne = boardMapper.insertBoardSelectKey(bvo);
		int resultTwo = 0;
		
		//첨부파일이 없으면
		if(bvo.getAttachList() == null || bvo.getAttachList().size() < 1 ) { //첨부파일이 있는 경우
			

			
			
			if (resultOne == 1 && resultTwo == 1) {
				return true;
			}
			
			return false;
			
			

			
			
		}else {
			
//			bvo.getAttachList().forEach(abvo -> {
//			abvo.setBno(bvo.getBno());	//게시물 번호 저장
//			boardAttachMapper.insertAttach(abvo);	//첨부파일 테이블에 추가
//		});
			
			List<BoardAttachVO> list = bvo.getAttachList();
			
			for (int i = 0; i < list.size(); i++) {
				
			
			BoardAttachVO bavo = new BoardAttachVO();
			bavo.setBno(bvo.getBno());
			bavo.setFileName(list.get(i).getFileName());
			bavo.setImage(list.get(i).isImage());
			bavo.setUpFolder(list.get(i).getUpFolder());
			bavo.setUuid(list.get(i).getUuid());
			
			
			
			resultTwo = boardAttachMapper.insertAttach(bavo);
			
			
			}
			
			if (resultOne == 1 && resultTwo == 1) {
				return true;
			}
			
			return false;
			
		}
		
		

	}
	
	@Override
	public int totalCount(Criteria cri) {
		int total = boardMapper.totalCount(cri);
		return total;
	}

	@Override
	public List<BoardVO> list(Criteria cri) {
		
		List<BoardVO> boardList = boardMapper.selectBoardAllPaging(cri);
		return boardList;
		
//		return boardMapper.selectBoardAll();
	}

	@Override
	public BoardVO view(int bno) {
		BoardVO bvo = boardMapper.selectBoard(bno);
		return bvo;
	}







	
	
}
