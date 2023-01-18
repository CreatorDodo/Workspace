package edu.springz.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import edu.springz.domain.SampleVO;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample/")
@Log4j
public class SampleController {
	
	

	
	@PostMapping("sample")
	public SampleVO sample(@RequestBody SampleVO svo) {
		log.info("sample : " + svo);
		return svo;
	}
	
	
	@GetMapping("product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,
							@PathVariable("pid") int pid) {
							//URL 경로의 일부를 파라미터로 이용
		return new String[] {"category:" + cat, "product id:" + pid }; 
	}
	
	@GetMapping(value = "check")
	public ResponseEntity<SampleVO> check(int height, int weight) {
		SampleVO svo = new SampleVO(6, "Six", "Yuk");
		ResponseEntity<SampleVO> resp = null;
		
		if(height > 100) {
			resp = ResponseEntity.status(HttpStatus.OK)
								 .body(svo);
		}else {
			resp = ResponseEntity.status(HttpStatus.BAD_GATEWAY)
					 .body(svo);
		}
		return resp;
	}
	
	@GetMapping("getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("Han", new SampleVO(5, "San", "Han"));
		return map;
}
	
	@GetMapping(value = "getList")
	public List<SampleVO> getList() {
			return IntStream.range(1, 5)
							.mapToObj(i -> new SampleVO(i, "Anony"+i, "Laa"))
							.collect(Collectors.toList());
	}
	
	@GetMapping(value = "getSample", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
			return new SampleVO(1, "Ben", "Lee");
	}
	
	@GetMapping(value = "getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("getText().................MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "Hello World!~";
	}
}
