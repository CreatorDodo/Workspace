package exam.madang;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 출판사 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class NewPublisherMd implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 출판사이름. */
	private String pubname;

	/** 담당자이름. */
	private String stname;

	/** 전화번호. */
	private String officephone;

	/** 도서 목록. */
	private Set<NewBookMd> newBookSet;

	/**
	 * 생성자.
	 */
	public NewPublisherMd() {
		this.newBookSet = new HashSet<NewBookMd>();
	}

	/**
	 * 출판사이름을 설정합니다..
	 * 
	 * @param pubname
	 *            출판사이름
	 */
	public void setPubname(String pubname) {
		this.pubname = pubname;
	}

	/**
	 * 출판사이름을 가져옵니다..
	 * 
	 * @return 출판사이름
	 */
	public String getPubname() {
		return this.pubname;
	}

	/**
	 * 담당자이름을 설정합니다..
	 * 
	 * @param stname
	 *            담당자이름
	 */
	public void setStname(String stname) {
		this.stname = stname;
	}

	/**
	 * 담당자이름을 가져옵니다..
	 * 
	 * @return 담당자이름
	 */
	public String getStname() {
		return this.stname;
	}

	/**
	 * 전화번호을 설정합니다..
	 * 
	 * @param officephone
	 *            전화번호
	 */
	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	/**
	 * 전화번호을 가져옵니다..
	 * 
	 * @return 전화번호
	 */
	public String getOfficephone() {
		return this.officephone;
	}

	/**
	 * 도서 목록을 설정합니다..
	 * 
	 * @param newBookSet
	 *            도서 목록
	 */
	public void setNewBookSet(Set<NewBookMd> newBookSet) {
		this.newBookSet = newBookSet;
	}

	/**
	 * 도서를 추가합니다..
	 * 
	 * @param newBook
	 *            도서
	 */
	public void addNewBook(NewBookMd newBook) {
		this.newBookSet.add(newBook);
	}

	/**
	 * 도서 목록을 가져옵니다..
	 * 
	 * @return 도서 목록
	 */
	public Set<NewBookMd> getNewBookSet() {
		return this.newBookSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pubname == null) ? 0 : pubname.hashCode());
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
		NewPublisherMd other = (NewPublisherMd) obj;
		if (pubname == null) {
			if (other.pubname != null) {
				return false;
			}
		} else if (!pubname.equals(other.pubname)) {
			return false;
		}
		return true;
	}

}