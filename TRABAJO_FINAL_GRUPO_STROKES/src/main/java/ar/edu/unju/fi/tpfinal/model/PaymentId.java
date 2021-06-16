/**
 * 
 */
package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Diego
 *
 */
@Embeddable
public class PaymentId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerNumber")
	private Customer customerNumber;
	@Id
	@Column(name = "checkNumber")
	private String checkNumber;
	
	public PaymentId() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param customerNumber
	 * @param checkNumber
	 */
	public PaymentId(Customer customerNumber, String checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}

	/**
	 * @return the customerNumber
	 */
	public Customer getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}

	/**
	 * @param checkNumber the checkNumber to set
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	
}
