package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_number")
	private int orderNumber;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@Column(name = "requires_date")
	private LocalDate requiredDate;
	
	@Column(name = "shipped_date")
	private LocalDate shippedDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "comments")
	private String comments;
	
	@ManyToOne()
	@JoinColumn(name = "customer_number_id")
	private Customer customer;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private OrderDetail orderDetail;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderNumber
	 * @param orderDate
	 * @param requiredDate
	 * @param shippedDate
	 * @param status
	 * @param comments
	 * @param customer
	 */
	public Order(int orderNumber, LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate, String status,
			String comments, Customer customer) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customer = customer;
	}

	/**
	 * @return the orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the requiredDate
	 */
	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	/**
	 * @param requiredDate the requiredDate to set
	 */
	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	/**
	 * @return the shippedDate
	 */
	public LocalDate getShippedDate() {
		return shippedDate;
	}

	/**
	 * @param shippedDate the shippedDate to set
	 */
	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customer="
				+ customer + "]";
	}
	
}
