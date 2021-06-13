/**
 * 
 */
package ar.edu.unju.fi.tpfinal.model;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author Torrejon Cristian
 *
 */
/**
 * Clase que almacena los pagos realizados por el cliente
 */
@Component
public class Payment {

	//Atributos
	
	private int customerNumber;
	private String checkNumber;
	private Date paymentDate;
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
	public Payment(int customerNumber, String checkNumber, Date paymentDate, Double amount) {
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
	public int getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(int customerNumber) {
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
