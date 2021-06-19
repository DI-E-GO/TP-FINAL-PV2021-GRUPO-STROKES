package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineService {
	public ProductLine getProductLine();
	public void addProductLine(MultipartFile file, ProductLine productLine);
	public void deleteProductLine(String productLine);
	public Optional<ProductLine> getProductLine(String productLine);
	public List<ProductLine> getProductLines();
}
