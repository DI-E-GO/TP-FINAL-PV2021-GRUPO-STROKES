/**
 * 
 */
package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Diego
 *
 */
@Embeddable
public class OrderDetailId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "productCode")
	private Product productCode;
	@ManyToOne
	@JoinColumn(name = "orderNumber")
	private Order orderNumber;
	
	public OrderDetailId() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productCode
	 * @param orderNumber
	 */
	public OrderDetailId(Product productCode, Order orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}
	

}
