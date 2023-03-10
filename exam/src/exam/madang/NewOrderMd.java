package exam.madang;

import java.io.Serializable;
import java.util.Date;

/**
 * 주문 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class NewOrderMd implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 주문번호. */
	private Integer orderid;

	/** 도서. */
	private NewBookMd newBook;

	/** 고객. */
	private NewCustomerMd newCustomer;

	/** 주문일자. */
	private Date orderdate;

	/** 주문금액. */
	private Integer saleprice;

	/**
	 * 생성자.
	 */
	public NewOrderMd() {
	}

	/**
	 * 주문번호을 설정합니다..
	 * 
	 * @param orderid
	 *            주문번호
	 */
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	/**
	 * 주문번호을 가져옵니다..
	 * 
	 * @return 주문번호
	 */
	public Integer getOrderid() {
		return this.orderid;
	}

	/**
	 * 도서을 설정합니다..
	 * 
	 * @param newBook
	 *            도서
	 */
	public void setNewBook(NewBookMd newBook) {
		this.newBook = newBook;
	}

	/**
	 * 도서을 가져옵니다..
	 * 
	 * @return 도서
	 */
	public NewBookMd getNewBook() {
		return this.newBook;
	}

	/**
	 * 고객을 설정합니다..
	 * 
	 * @param newCustomer
	 *            고객
	 */
	public void setNewCustomer(NewCustomerMd newCustomer) {
		this.newCustomer = newCustomer;
	}

	/**
	 * 고객을 가져옵니다..
	 * 
	 * @return 고객
	 */
	public NewCustomerMd getNewCustomer() {
		return this.newCustomer;
	}

	/**
	 * 주문일자을 설정합니다..
	 * 
	 * @param orderdate
	 *            주문일자
	 */
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	/**
	 * 주문일자을 가져옵니다..
	 * 
	 * @return 주문일자
	 */
	public Date getOrderdate() {
		return this.orderdate;
	}

	/**
	 * 주문금액을 설정합니다..
	 * 
	 * @param saleprice
	 *            주문금액
	 */
	public void setSaleprice(Integer saleprice) {
		this.saleprice = saleprice;
	}

	/**
	 * 주문금액을 가져옵니다..
	 * 
	 * @return 주문금액
	 */
	public Integer getSaleprice() {
		return this.saleprice;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
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
		NewOrderMd other = (NewOrderMd) obj;
		if (orderid == null) {
			if (other.orderid != null) {
				return false;
			}
		} else if (!orderid.equals(other.orderid)) {
			return false;
		}
		return true;
	}

}
