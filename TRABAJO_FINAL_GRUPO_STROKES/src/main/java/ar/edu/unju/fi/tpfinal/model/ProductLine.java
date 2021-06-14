package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCT_LINES")
public class ProductLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_line_id")
	private String productLine;
	
	@Column(name = "text_description")
	private String textDescription;
	
	@Column(name = "html_description")
	private String htmlDescription;
	
	@Column(name = "image")
	private String image;
	
	@OneToMany(mappedBy = "product_line", cascade = CascadeType.ALL)
	private Product product;
	
	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productLine
	 * @param textDescription
	 * @param htmlDescription
	 * @param image
	 * @param product
	 */
	public ProductLine(String productLine, String textDescription, String htmlDescription, String image,
			Product product) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
		this.product = product;
	}

	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return productLine;
	}

	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	/**
	 * @return the textDescription
	 */
	public String getTextDescription() {
		return textDescription;
	}

	/**
	 * @param textDescription the textDescription to set
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	/**
	 * @return the htmlDescription
	 */
	public String getHtmlDescription() {
		return htmlDescription;
	}

	/**
	 * @param htmlDescription the htmlDescription to set
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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

	@Override
	public String toString() {
		return "ProductLine [productLine=" + productLine + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + image + "]";
	}
	
}
