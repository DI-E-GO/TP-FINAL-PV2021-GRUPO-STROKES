package ar.edu.unju.fi.tpfinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCT_LINES")
public class ProductLine {
	@NotEmpty(message = "Ingrese una nueva linea de producto")
	@Id
	@Column(name = "product_line_id")
	private String productLine;
	@NotEmpty(message = "Ingrese una descripcion sobre la linea de producto")
	@Size(max = 4000)
	@Column(name = "text_description")
	private String textDescription;
	
	@Column(name = "html_description")
	private String htmlDescription;
	
	@Column(name = "image", columnDefinition = "MEDIUMBLOB")
	private String image;
	
	@OneToMany(mappedBy = "productLine", cascade = CascadeType.ALL)
	private List<Product> product;
	
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
	public ProductLine(String productLine, String textDescription, String htmlDescription, String image) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
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
	public List<Product> getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductLine [productLine=" + productLine + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + image + ", product=" + product + "]";
	}
	
}
