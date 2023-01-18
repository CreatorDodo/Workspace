package edu.springz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;

public interface Sample1Mapper {
	
	@Insert(value = { "INSERT INTO tbl_sample1 VALUES(#{data})" })
	public int insertCol1(String data);
	
	
	
}
