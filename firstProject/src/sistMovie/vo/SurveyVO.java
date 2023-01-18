package sistMovie.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Model class of 설문조사.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class SurveyVO implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** 설문번호. */
	private int surveyNo;  
	/** 설문제목. */
	private String surveytitle;
	/** 설문항목1. */
	private String one;
	/** 설문항목2. */
	private String two;
	/** 설문1_득표수. */
	private Integer oneCnt;
	/** 설문2_득표수. */
	private Integer twoCnt;
	/** 설문시작일. */
	private String startDate;
	/** 설문 끝일. */
	private String endDate;
	/** 등록일. */
	private String regDate;
	/** 수정일. */
	private String modDate;
	/** 이벤트 당첨자 */
	private String winner;

	
	public String getOne() {
		return one;
	}
	public void setOne(String one) {
		this.one = one;
	}
	public String getTwo() {
		return two;
	}
	public void setTwo(String two) {
		this.two = two;
	}
	public int getSurveyNo() {
		return surveyNo;
	}
	public void setSurveyNo(int surveyNo) {
		this.surveyNo = surveyNo;
	}
	public String getsurveyTitle() {
		return surveytitle;
	}
	public void setsurveyTitle(String surveytitle) {
		this.surveytitle = surveytitle;
	}
	
	public Integer getOneCnt() {
		return oneCnt;
	}
	public void setOneCnt(Integer oneCnt) {
		this.oneCnt = oneCnt;
	}
	public Integer getTwoCnt() {
		return twoCnt;
	}
	public void setTwoCnt(Integer twoCnt) {
		this.twoCnt = twoCnt;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
