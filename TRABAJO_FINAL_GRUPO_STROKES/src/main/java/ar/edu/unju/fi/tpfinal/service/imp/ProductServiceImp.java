/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.repository.IProductRepository;
import ar.edu.unju.fi.tpfinal.service.IProductService;

/**
 * @author Diego
 *
 */
@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	IProductRepository productRepository;
	
	@Autowired
	Product product;
	
	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(String productCode) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productCode);
	}

	@Override
	public Optional<Product> getProduct(String productCode) {
		// TODO Auto-generated method stub
		return productRepository.findById(productCode);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
