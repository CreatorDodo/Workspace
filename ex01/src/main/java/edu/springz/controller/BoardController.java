package edu.springz.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.springz.domain.BoardAttachVO;
import edu.springz.domain.BoardVO;
import edu.springz.domain.Criteria;
import edu.springz.domain.PageDTO;
import edu.springz.domain.ReplyPageDTO;
import edu.springz.mapper.BoardAttachMapper;
import edu.springz.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.net.aso.b;

@Controller // 스프링이 관리하는 빈 컨트롤러가 되도록 어노테이션 지정
@AllArgsConstructor // 생성자 인젝션 어노테이션 지정
@RequestMapping("/board/*") // /board/로 들어오는 모든 요청을 처리하도록 어노테이션 지정
@Log4j
public class BoardController {
	private BoardService boardService; // 생성자 인젝션의 대상이 되는 필드 선언
	
	@GetMapping("/attachList") // 첨부파일 목록
	public ResponseEntity<List<BoardAttachVO>> attachList(int bno) {
		log.info("attachList()..........." + bno);
		
		//첨부파일 목록과 200번 코드 반환
		return new ResponseEntity<>(boardService.attachList(bno), HttpStatus.OK);
	
	}
	
	public void deleteAttach(List<BoardAttachVO> attachList){ //첨부파일 삭제
		log.info("deleteAttach.................." + attachList);
		
		
		if (attachList == null || attachList.size() < 1) {
			return;
			
		}
		
		
		attachList.forEach(abvo -> {
			try {
			Path file = Paths.get("c:\\upload\\" + abvo.getUpFolder() + "\\" + abvo.getUuid() + "_" + abvo.getFileName());
			
			
				Files.deleteIfExists(file); //파일이 존재하면 삭제
			
			
			if (Files.probeContentType(file).startsWith("image")) { //이미지 파일의 경우
				Path thumbnail = Paths.get("c:\\upload\\" + abvo.getUpFolder() + "\\s_" + abvo.getUuid() + "_" + abvo.getFileName());
				Files.delete(thumbnail); //썸네일 삭제
			}
			
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		});
		
	}
	
	
	
	// 게시물 삭제
	@PostMapping("remove")
	public String remove(int bno, RedirectAttributes rttr,  @ModelAttribute("cri") Criteria cri ) {
		log.info("remove()....................");

		List<BoardAttachVO> list = boardService.attachList(bno);

		if (boardService.remove(bno)) {	//삭제에 성공한 경우
			deleteAttach(list);
			rttr.addFlashAttribute("result", "success");
			
		} else {
			rttr.addFlashAttribute("result", "fail");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list"; // response.sendRedirect() 처리

	}
	
	
	// 게시물 수정
	@PostMapping("modify")
	public String modify(BoardVO bvo, RedirectAttributes rttr, Criteria cri ) {
		log.info("modify()....................");

		if (boardService.modify(bvo)) {	//수정에 성공한 경우
			rttr.addFlashAttribute("result", "success");
		} else {
			rttr.addFlashAttribute("result", "fail");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list"; // response.sendRedirect() 처리

	}
	

	
	
//	@GetMapping({"view", "modify"})
	@GetMapping(value = {"view", "modify"}) // 게시물 조회, 수정 폼
	public void view(Model model, int bno, @ModelAttribute("cri") Criteria cri ) {
		log.info("view() or modify form...................." + cri);

		model.addAttribute("bvo", boardService.view(bno));
		

		
		
	}

	// 게시물 등록
	@PostMapping("register")
	public String register(BoardVO bvo, RedirectAttributes rttr) {
		log.info("register()...................." + bvo);
		
		
			boardService.register(bvo); //첨부파일 테이블에 추가

		
			
		
		
		
		rttr.addFlashAttribute("result", bvo.getBno()); // 게시물 번호
		
		
		return "redirect:/board/list"; // response.sendRedirect() 처리

	}
	
	@GetMapping("register") // 게시물 등록 폼
	public void register() {
		log.info("registerForm()....................");
	}

	@GetMapping("list") // 게시물 목록
	public void list(Model model, Criteria cri) {
		log.info("list()...................." + cri);
		model.addAttribute("list", boardService.list(cri));
	
		int totalCount = boardService.totalCount(cri);
		model.addAttribute("pageDTO", new PageDTO(cri, totalCount));
	
	}

}
