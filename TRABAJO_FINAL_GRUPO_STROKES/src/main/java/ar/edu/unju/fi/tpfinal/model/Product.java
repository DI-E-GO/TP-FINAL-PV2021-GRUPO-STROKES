package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTS")
public class Product {
	@NotEmpty(message = "Ingrese un código de producto")
	@Id
	@Column(name = "product_code_id")
	private String productCode;
	@NotEmpty(message = "Ingrese el nombre del producto")
	@Column(name = "product_name")
	private String productName;
	@NotNull(message = "Seleccione una linea de Producto")
	@ManyToOne()
	@JoinColumn(name = "product_line_id")
	private ProductLine productLine;
	@NotEmpty(message = "Ingrese una escala del producto. ej:'1:10'")
	@Column(name = "product_scale")
	private String productScale;
	@NotEmpty(message = "Ingrese el nombre del vendedor de producto")
	@Column(name = "product_vendor")
	private String productVendor;
	@NotEmpty(message = "Ingrese una breve descripción del producto")
	@Column(name = "product_description")
	private String productDescription;
	@NotNull(message = "Ingrese la cantidad de stock disponible")
	@Min(value = 1, message = "No se aceptan valores negativos o cero")
	@Column(name = "quantity_in_stock")
	private short quantityInStock;
	@NotNull(message = "Ingrese el precio del producto")
	@Min(value = 1, message = "No se aceptan valores negativos o cero")
	@Column(name = "buy_price")
	private double buyPrice;
	@NotNull(message = "Ingrese el precio sugerido para la venta")
	@Min(value = 1, message = "No se permiten numeros negativos o cero")
	@Column(name = "msrp")
	private double MSRP;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productCode
	 * @param productName
	 * @param productScale
	 * @param productVendor
	 * @param productDescription
	 * @param quantityInStock
	 * @param buyPrice
	 * @param mSRP
	 */
	public Product(String productCode, String productName, String productScale, String productVendor,
			String productDescription, short quantityInStock, double buyPrice, double mSRP) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.MSRP = mSRP;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productLine
	 */
	public ProductLine getProductLine() {
		return productLine;
	}

	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	/**
	 * @return the productScale
	 */
	public String getProductScale() {
		return productScale;
	}

	/**
	 * @param productScale the productScale to set
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	/**
	 * @return the productVendor
	 */
	public String getProductVendor() {
		return productVendor;
	}

	/**
	 * @param productVendor the productVendor to set
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the quantityInStock
	 */
	public short getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/**
	 * @return the buyPrice
	 */
	public double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the mSRP
	 */
	public double getMSRP() {
		return MSRP;
	}

	/**
	 * @param mSRP the mSRP to set
	 */
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}
	
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP="
				+ MSRP + "]";
	}
	
}
