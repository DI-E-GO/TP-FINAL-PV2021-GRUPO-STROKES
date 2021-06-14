/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IProductLineRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

/**
 * @author Diego
 *
 */
@Service
public class ProductLineServiceImp implements IProductLineService {
	
	@Autowired
	IProductLineRepository productLineRepository;
	
	@Autowired
	ProductLine productLine;

	@Override
	public ProductLine getProductLine() {
		// TODO Auto-generated method stub
		return productLine;
	}

	@Override
	public void addProductLine(ProductLine productLine) {
		// TODO Auto-generated method stub
		productLineRepository.save(productLine);
	}

	@Override
	public void deleteProductLine(String productLine) {
		// TODO Auto-generated method stub
		productLineRepository.deleteById(productLine);
	}

	@Override
	public Optional<ProductLine> getProductLine(String productLine) {
		// TODO Auto-generated method stub
		return productLineRepository.findById(productLine);
	}

	@Override
	public List<ProductLine> getProductLines() {
		// TODO Auto-generated method stub
		return productLineRepository.findAll();
	}

}
