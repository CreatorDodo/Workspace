package org.zerock.controller;


import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	//파일 업로드 폼
	@GetMapping("uploadEX")
	public void uploadEXGet() {
		log.info("uploadEX() form....................");
	}
	
	//파일 업로드 처리
//	@RequestMapping(value = "uploadEX", method = {RequestMethod.POST})
	@PostMapping("uploadEX")
	public void uploadEXPost(ArrayList<MultipartFile> files) {
		log.info("uploadEX()....................");
		files.forEach(file -> {
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			log.info("---------------------------------");
		});
	}
	
	@GetMapping("ex06")
	public ResponseEntity<String>  ex06() {
		log.info("ex06()....................");
	
		String msg = "{\"name\" : \"Ban\"\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
		
	}
	
	@GetMapping("ex05")
	public @ResponseBody SampleDTO ex05() {
		log.info("ex05()....................");
	
		SampleDTO sdto = new SampleDTO();
		sdto.setName("Dan");
		sdto.setAge(50);
		return sdto;
		
	}
	
	@GetMapping("ex04")
//	public void ex04(SampleDTO sdto, int pageNum) {
	public String ex04(SampleDTO sdto, Model model,
			@ModelAttribute("pageNum") int pageNum) {
			//파라미터로 전달받은 데이터를 요청객체에 담아서 뷰로 재전송
			//파라미터 데이터를 그대로 화면에서 다시 사용 가능
			//자바빈즈는 컨트롤러가 결과 화면까지 전달
		
		//결과 페이지로 code 속성에 1234를 추가하여 전달
		model.addAttribute("code", "1234");
		
		log.info("ex04()...................." + sdto);
		log.info("ex04()...................." + pageNum);
	
		//요청 URL과 결과 페이지가 같다면 return 생략 가능
		//다르다면 직접 지정 가능
			return "/sample/ex044";
	
	}
	
	@GetMapping("ex03")
	public void ex03(TodoDTO tdto) {
		log.info("ex03()...................." + tdto);
	}
	
	@GetMapping("ex02BeanList")
	public void ex02BeanList(SampleDTOList list) {
		log.info("ex02BeanList()...................." + list);
	}
	
	
	@GetMapping("ex02Array")
	public void ex02Array(@RequestParam("id") String[] ids) {
		log.info("ex02Array()...................." + Arrays.toString(ids));
	}
	
	@GetMapping("ex02List")
	public void ex02List(@RequestParam("id") ArrayList<String> ids) {
		log.info("ex02List()...................." + ids);
	}
	
	@GetMapping("ex02")
	public void ex02(@RequestParam("name") String name,
			@RequestParam("age") String age) {
		log.info("ex02()...................." + name);
		log.info("ex02()...................." + age);
	}
	
	@RequestMapping("ex01")
	public void ex01(SampleDTO sdto) {
		log.info("ex01()...................." + sdto);
	}
	
	
	@RequestMapping(value = "basicGP", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGetPost() {
		log.info("basicGetPost()....................");
	}
	
	@RequestMapping("basic")
	public void basicGet() {
		log.info("basicGet()....................");
	}
	
	@RequestMapping("")
	public void basicAll() {
		log.info("basicAll()....................");
	}

}

















