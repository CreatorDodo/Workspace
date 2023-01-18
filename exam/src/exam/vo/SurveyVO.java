package exam.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 설문조사 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class SurveyVO implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** 설문번호. */
	private Integer surveyNo;

	/** 설문제목. */
	private String title;

	/** 설문항목1. */
	private String one;

	/** 설문항목1득표수. */
	private Integer oneCnt;

	/** 설문항목2. */
	private String two;

	/** 설문항목2득표수. */
	private Integer twoCnt;

	/** 설문시작일. */
	private String startDate;

	private String endDate;
	
	/** 등록일. */
	private Date regDate;

	/** 수정일. */
	private Date modDate;

	/** 설문참여 목록. */
	private List<VoteVO> tVoteList;

	
	
	public SurveyVO(Integer surveyNo, String title, String one, Integer oneCnt, String two, Integer twoCnt,
			String startDate, String endDate) {
		this.surveyNo = surveyNo;
		this.title = title;
		this.one = one;
		this.oneCnt = oneCnt;
		this.two = two;
		this.twoCnt = twoCnt;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public SurveyVO(Integer surveyNo, String title, Integer oneCnt, Integer twoCnt, String startDate, String endDate) {
		this.surveyNo = surveyNo;
		this.title = title;
		this.oneCnt = oneCnt;
		this.twoCnt = twoCnt;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * 생성자.
	 */
	public SurveyVO() {
	}

	/**
	 * 설문번호을 설정합니다..
	 * 
	 * @param surveyNo
	 *            설문번호
	 */
	public void setSurveyNo(Integer surveyNo) {
		this.surveyNo = surveyNo;
	}

	/**
	 * 설문번호을 가져옵니다..
	 * 
	 * @return 설문번호
	 */
	public Integer getSurveyNo() {
		return this.surveyNo;
	}

	/**
	 * 설문제목을 설정합니다..
	 * 
	 * @param title
	 *            설문제목
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 설문제목을 가져옵니다..
	 * 
	 * @return 설문제목
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 설문항목1을 설정합니다..
	 * 
	 * @param one
	 *            설문항목1
	 */
	public void setOne(String one) {
		this.one = one;
	}

	/**
	 * 설문항목1을 가져옵니다..
	 * 
	 * @return 설문항목1
	 */
	public String getOne() {
		return this.one;
	}

	/**
	 * 설문항목1득표수을 설정합니다..
	 * 
	 * @param oneCnt
	 *            설문항목1득표수
	 */
	public void setOneCnt(Integer oneCnt) {
		this.oneCnt = oneCnt;
	}

	/**
	 * 설문항목1득표수을 가져옵니다..
	 * 
	 * @return 설문항목1득표수
	 */
	public Integer getOneCnt() {
		return this.oneCnt;
	}

	/**
	 * 설문항목2을 설정합니다..
	 * 
	 * @param two
	 *            설문항목2
	 */
	public void setTwo(String two) {
		this.two = two;
	}

	/**
	 * 설문항목2을 가져옵니다..
	 * 
	 * @return 설문항목2
	 */
	public String getTwo() {
		return this.two;
	}

	/**
	 * 설문항목2득표수을 설정합니다..
	 * 
	 * @param twoCnt
	 *            설문항목2득표수
	 */
	public void setTwoCnt(Integer twoCnt) {
		this.twoCnt = twoCnt;
	}

	/**
	 * 설문항목2득표수을 가져옵니다..
	 * 
	 * @return 설문항목2득표수
	 */
	public Integer getTwoCnt() {
		return this.twoCnt;
	}

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * 등록일을 설정합니다..
	 * 
	 * @param regDate
	 *            등록일
	 */
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	/**
	 * 등록일을 가져옵니다..
	 * 
	 * @return 등록일
	 */
	public Date getRegDate() {
		return this.regDate;
	}

	/**
	 * 수정일을 설정합니다..
	 * 
	 * @param modDate
	 *            수정일
	 */
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	/**
	 * 수정일을 가져옵니다..
	 * 
	 * @return 수정일
	 */
	public Date getModDate() {
		return this.modDate;
	}

	/**
	 * 설문참여 목록을 설정합니다..
	 * 
	 * @param tVoteSet
	 *            설문참여 목록
	 */
	public void setTVoteList(List<VoteVO> tVoteList) {
		this.tVoteList = tVoteList;
	}

	/**
	 * 설문참여를 추가합니다..
	 * 
	 * @param tVote
	 *            설문참여
	 */
	public void addTVote(VoteVO tVote) {
		this.tVoteList.add(tVote);
	}

	/**
	 * 설문참여 목록을 가져옵니다..
	 * 
	 * @return 설문참여 목록
	 */
	public List<VoteVO> getTVoteList() {
		return this.tVoteList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((surveyNo == null) ? 0 : surveyNo.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SurveyVO other = (SurveyVO) obj;
		if (surveyNo == null) {
			if (other.surveyNo != null) {
				return false;
			}
		} else if (!surveyNo.equals(other.surveyNo)) {
			return false;
		}
		return true;
	}

}