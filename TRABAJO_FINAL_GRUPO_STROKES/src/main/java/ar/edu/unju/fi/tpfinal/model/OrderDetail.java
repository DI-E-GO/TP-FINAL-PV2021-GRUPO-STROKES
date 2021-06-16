package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ORDER_DETAILS")
@Component
public class OrderDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "productCode")
	private Product productCode;
	@ManyToOne
	@JoinColumn(name = "orderNumber")
	private Order orderNumber;
	
	@Column(name = "quantityOrdered")
	private int quantityOrdered;
	
	@Column(name = "priceEach")
	private double priceEach;
	
	@Column(name = "orderLineNumber")
	private short orderLineNumber;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param productCode
	 * @param orderNumber
	 * @param quantityOrdered
	 * @param priceEach
	 * @param orderLineNumber
	 */
	public OrderDetail(Long id, Product productCode, Order orderNumber, int quantityOrdered, double priceEach,
			short orderLineNumber) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.orderNumber = orderNumber;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the productCode
	 */
	public Product getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the orderNumber
	 */
	public Order getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the quantityOrdered
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	/**
	 * @return the priceEach
	 */
	public double getPriceEach() {
		return priceEach;
	}

	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	/**
	 * @return the orderLineNumber
	 */
	public short getOrderLineNumber() {
		return orderLineNumber;
	}

	/**
	 * @param orderLineNumber the orderLineNumber to set
	 */
	public void setOrderLineNumber(short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", productCode=" + productCode + ", orderNumber=" + orderNumber
				+ ", quantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber="
				+ orderLineNumber + "]";
	}
	
}
