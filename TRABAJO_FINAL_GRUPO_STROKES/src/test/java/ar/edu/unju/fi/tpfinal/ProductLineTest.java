package ar.edu.unju.fi.tpfinal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.ProductLine;


@SpringBootTest
public class ProductLineTest {
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Test
	public void testProducLine() {
		
		ProductLine productLine = new ProductLine();
		
		productLine.setProductLine("1");
		productLine.setTextDescription("a");
		productLine.setHtmlDescription("as");
		productLine.setImage(null);
		
		List<ProductLine>plList = new ArrayList<>();
		
		plList.add(productLine);
		
		entityManager.persist(productLine);
		entityManager.flush();
		
		
	}
	
	
	
	

}
