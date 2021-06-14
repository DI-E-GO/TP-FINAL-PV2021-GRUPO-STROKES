package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineService {
	public ProductLine getProductLine();
	public void addProductLine(ProductLine productLine);
	public void deleteProductLine(String productLine);
	public Optional<ProductLine> getProductLine(String productLine);
	public List<ProductLine> getProductLines();
}
