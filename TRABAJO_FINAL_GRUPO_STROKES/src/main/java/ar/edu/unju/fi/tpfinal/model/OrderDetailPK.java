package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

public class OrderDetailPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderNumber;
	private String productCode;
	
	public OrderDetailPK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderNumber
	 * @param productCode
	 */
	public OrderDetailPK(int orderNumber, String productCode) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNumber;
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailPK other = (OrderDetailPK) obj;
		if (orderNumber != other.orderNumber)
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}
	
}
