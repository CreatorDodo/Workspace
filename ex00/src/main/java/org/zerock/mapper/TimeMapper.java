package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	public String getTimeTomorrow();	//XML 매퍼 이용
	
	@Select("SELECT SYSDATE FROM DUAL")	//쿼리 직접 명시
	public String getTime();
}
