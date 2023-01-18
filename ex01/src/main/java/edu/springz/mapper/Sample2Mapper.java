package edu.springz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import edu.springz.domain.Criteria;
import edu.springz.domain.ReplyVO;

public interface Sample2Mapper {
	
	@Insert(value = { "INSERT INTO tbl_sample2 VALUES(#{data})" })
	public int insertCol2(String data);
	
	
	
	
}
