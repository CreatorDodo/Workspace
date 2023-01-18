package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor		//생성자 인젝션 - 모든 필드 대상
@RequiredArgsConstructor	//생성자 인젝션 - final 필드 또는
public class Hotel {		//			   @NonNull 필드 대상
//	@Setter(onMethod_ = @Autowired)	//세터 인젝션
	
	@NonNull
	private Chef chef;
	
//	public Hotel(Chef chef) {	//생성자
//		this.chef = chef;
//	}
	
//	public void setChef(Chef chef) {	/세터
//		this.chef = chef;
//	}
	
	
}
