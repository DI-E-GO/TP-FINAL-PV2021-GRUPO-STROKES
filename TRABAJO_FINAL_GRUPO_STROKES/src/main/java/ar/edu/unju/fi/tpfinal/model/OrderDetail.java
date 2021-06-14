package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_number_id")
	private Order orderNumber;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_code_id")
	private Product product;
	
	@Column(name = "quantity_ordered")
	private int quantityOrdered;
	
	@Column(name = "price_each")
	private double priceEach;
	
	@Column(name = "order_line_number")
	private short orderLineNumber;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param orderNumber
	 * @param product
	 * @param quantityOrdered
	 * @param priceEach
	 * @param orderLineNumber
	 */
	public OrderDetail(Order orderNumber, Product product, int quantityOrdered, double priceEach,
			short orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.product = product;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
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
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
		return "OrderDetail [orderNumber=" + orderNumber + ", product=" + product + ", quantityOrdered="
				+ quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}
	
}
