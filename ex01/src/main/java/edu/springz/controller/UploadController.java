package edu.springz.controller;

import java.util.ArrayList;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import edu.springz.domain.AttachFileDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("deleteFile : " + fileName);
		
		try {
			File file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();	//파일 삭제
			
			if(type.equals("image")) {//이미지 파일이면 원본 파일 삭제
				String originFile = file.getAbsolutePath().replace("s_", "");	//원본 파일명
				file = new File(originFile);
				file.delete(); //원본 이미지 삭제
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("deleted", HttpStatus.OK);
		
	}

	
	
	@GetMapping("/upload/ajaxAction")
	public void uploadAjax() {
		log.info("upload ajaxAction");
	}
	
	
	//현재 시점의 '연/월/일' 폴더 경로 문자열 생성하여 반환
	public String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(new Date());
		
		return str.replace("-", File.separator);
	}
	
	//이미지 파일 여부 확인
	public boolean checkImgType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//썸네일 이미지 전송
	@GetMapping("/display")
	public ResponseEntity<byte[]> display(String fileName){
		File file = new File("c:\\upload\\" + fileName);
		ResponseEntity<byte[]> result = null;
		
		HttpHeaders header = new HttpHeaders();
		
		try {
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//파일 다운로드
	@GetMapping(value = "/download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> download(String fileName){
		Resource resource = new FileSystemResource("c:\\upload\\" + fileName.substring(fileName.indexOf("_") + 1)); //UUID 제거
		log.info("resource : " + resource);
		
		if(resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String fileNm = resource.getFilename();
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-Disposition", "attachment; filename=" + new String(fileNm.getBytes("UTF-8"), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(resource, header, HttpStatus.OK);
	}
	
	@PostMapping("/upload/ajaxAction")
	public ResponseEntity<List<AttachFileDTO>> uploadAjax(MultipartFile[] uploadFile) {
		log.info("upload action");
		String upPath = "c:\\upload";
		
		List<AttachFileDTO> attachList = new ArrayList<>();
		
		
		
		
		// 연/월/일 폴더 생성
		File upFolder = new File(upPath, getFolder());
		log.info("upFolder : " + upFolder);
		
		//업로드 경로에 해당 폴더가 없는 경우에는 생성
		if( !upFolder.exists() ) {
			upFolder.mkdirs();
			
		}
		
		
		for(MultipartFile multi : uploadFile) {
			log.info("-----------------------------");
			log.info("file name : " + multi.getOriginalFilename());
			log.info("file size : " + multi.getSize());
		
			
			UUID uuid = UUID.randomUUID();
			log.info("uuid : " + uuid);
			
			String upFileName = uuid + "_" + multi.getOriginalFilename();
			
//			File saveFile = new File(upPath, multi.getOriginalFilename());
			File saveFile = new File(upFolder, upFileName);
			
		
			AttachFileDTO adto = new AttachFileDTO();
			
			adto.setUpFolder(getFolder());
//			adto.setFileName(upFileName);
			adto.setFileName(multi.getOriginalFilename());
			adto.setUuid(uuid.toString());
			
			try {
				multi.transferTo(saveFile); //파일 업로드 처리
				
				if(checkImgType(saveFile)) { //이미지 파일의 경우 
					
					adto.setImage(true);
					
					FileOutputStream fos = new FileOutputStream(new File(upFolder, "s_" + upFileName));
				
						
						
						
						
					
				Thumbnailator.createThumbnail( //섬네일 이미지 생성
						multi.getInputStream(), fos, 100, 100);
					fos.close();
				}
			} catch (Exception e) {
				log.info(e.getMessage());
			}
		attachList.add(adto);
		}//END for
		
		return new ResponseEntity<>(attachList, HttpStatus.OK);
		
		
		
	}//END uploadAjax
	
	
	@GetMapping("/upload/formAction")
	public void uploadForm() {
		log.info("upload formAction");
	}
	
	@PostMapping("/upload/formAction")
	public void uploadAction(MultipartFile[] uploadFile) {
		log.info("upload action");
		String upPath = "c:\\upload";
		for(MultipartFile multi : uploadFile) {
			log.info("-----------------------------");
			log.info("file name : " + multi.getOriginalFilename());
			log.info("file size : " + multi.getSize());
		
			File saveFile = new File(upPath, multi.getOriginalFilename());
			
			try {
				multi.transferTo(saveFile); //파일 업로드 처리
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}

}
