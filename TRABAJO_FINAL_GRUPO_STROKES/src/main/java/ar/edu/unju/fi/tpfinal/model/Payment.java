/**
 * 
 */
package ar.edu.unju.fi.tpfinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author Torrejon Cristian
 *
 */
/**
 * Clase que almacena los pagos realizados por el cliente
 */
@Component
@Entity
@Table(name = "PAYMENTS")
public class Payment{

	//Atributos

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_number")
	private Customer customerNumber;
	
	@Id
	@Column(name = "check_number_id")
	private String checkNumber;
	
	@Column(name = "payment_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date paymentDate;
	
	@Column(name = "amount")
	private Double amount;
	
	
	
	/**
	 * Constructores
	 */
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param customerNumber
	 * @param checkNumber
	 * @param paymentDate
	 * @param amount
	 */
	public Payment(Customer customerNumber, String checkNumber, Date paymentDate, Double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	/**
	 * Getters y setters
	 */
	
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
	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	//Metodo toString
	@Override
	public String toString() {
		return "Payment [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}
	
	
}
