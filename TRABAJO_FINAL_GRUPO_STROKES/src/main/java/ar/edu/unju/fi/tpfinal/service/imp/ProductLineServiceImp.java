/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public void addProductLine(MultipartFile file, ProductLine productLine) {
		// TODO Auto-generated method stub
		
		try {
			productLine.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productLineRepository.save(productLine);
	}

}
