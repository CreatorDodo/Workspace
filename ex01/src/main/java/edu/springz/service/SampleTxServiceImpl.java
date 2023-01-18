package edu.springz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.springz.domain.ReplyVO;
import edu.springz.mapper.ReplyMapper;
import edu.springz.mapper.Sample1Mapper;
import edu.springz.mapper.Sample2Mapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class SampleTxServiceImpl implements SampleTxService {

	private Sample1Mapper mapper1;
	private Sample2Mapper mapper2;
	
	@Transactional
	@Override
	public void addCol(String str) {
		log.info("mapper1.........");
		mapper1.insertCol1(str);
		
		log.info("mapper2.........");
		mapper2.insertCol2(str);
		
	}

	



}
