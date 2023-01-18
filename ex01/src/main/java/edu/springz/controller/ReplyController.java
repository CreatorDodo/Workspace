package edu.springz.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.springz.domain.Criteria;
import edu.springz.domain.PageDTO;
import edu.springz.domain.ReplyPageDTO;
import edu.springz.domain.ReplyVO;
import edu.springz.domain.SampleVO;
import edu.springz.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.net.aso.b;

@RestController
@AllArgsConstructor // 생성자 인젝션 어노테이션 지정
@RequestMapping("/replies/") // /replies/로 들어오는 모든 요청을 처리하도록 어노테이션 지정
@Log4j
public class ReplyController {
	private ReplyService replyService; // 생성자 인젝션의 대상이 되는 필드 선언

	
	
	@GetMapping("list/{bno}/{pageNum}") // 댓글	 목록
	public ResponseEntity<ReplyPageDTO> list(@PathVariable("bno") int bno,
			@PathVariable("pageNum") int pageNum) {
		log.info("list()..........." + bno + "...pageNum:" + pageNum);
		Criteria cri = new Criteria(3, pageNum);
		
		//댓글 목록과 200번 코드 반환
		return new ResponseEntity<>(replyService.list(cri, bno), HttpStatus.OK);
	
	}
	
	
	// 댓글 삭제
	@DeleteMapping(value = "{rno}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {
		log.info("remove()....................");

		if (replyService.remove(rno)) {	//삭제에 성공한 경우
			return new ResponseEntity<>("success", HttpStatus.OK);
//			rttr.addFlashAttribute("result", "success");
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			rttr.addFlashAttribute("result", "fail");
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
//		return "redirect:/board/list"; // response.sendRedirect() 처리

	}
	
	
	// 게시물 수정
	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH}, value = "{rno}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody ReplyVO rvo, @PathVariable("rno") int rno) {
		log.info("modify()....................rno:" + rno + " ...rvo:" + rvo);
		rvo.setRno(rno);
		
		if (replyService.modify(rvo)) {	//수정에 성공한 경우
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}
	

	@GetMapping("{rno}")
	public ResponseEntity<ReplyVO> view(@PathVariable("rno") int rno) {
		log.info("view()...................." + rno);
		
		//댓글 하나와 200번 코드 반환
		return new ResponseEntity<>(replyService.view(rno), HttpStatus.OK);
		
	}
	
	
	
//	@GetMapping({"view", "modify"}) // 게시물 조회, 수정 폼
//	public ResponseEntity<String> view(Model model, int rno, @ModelAttribute("cri") Criteria cri ) {
//		log.info("view() or modify form...................." + rvo);
//
//		model.addAttribute("rvo", replyService.view(rno));
//		
//		
//	}

	// 게시물 등록
	@PostMapping(value = "register", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> register(@RequestBody ReplyVO rvo) {
		log.info("register()...................." + rvo);
		
		//댓글 등록에 성공하면 success와 200번 상태 코드, 실패하면 500번 반환
		if (replyService.register(rvo)) {	//삭제에 성공한 경우
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	

	}
	
	@GetMapping("register") // 게시물 등록 폼
	public void register() {
		log.info("registerForm()....................");
	}



}
