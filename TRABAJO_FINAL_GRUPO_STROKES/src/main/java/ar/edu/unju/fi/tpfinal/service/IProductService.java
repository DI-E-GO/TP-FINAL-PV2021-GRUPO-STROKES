package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Product;

public interface IProductService {
	public Product getProduct();
	public void addProduct(Product product);
	public void deleteProduct(String productCode);
	public Optional<Product> getProduct(String productCode);
	public List<Product> getProducts();
}
