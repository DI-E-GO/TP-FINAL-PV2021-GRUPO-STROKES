package ar.edu.unju.fi.tpfinal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	IProductLineService productLineService;

	@Autowired
	IProductService productService;
	
	List<ProductLine> productLines = new ArrayList<ProductLine>();
	
	@GetMapping("/producto/nuevo")
	public String getProductFormPage(Model model) {
		
		this.productLines = productLineService.getProductLines();
		model.addAttribute("product", productService.getProduct());
		model.addAttribute("productLines", productLines);
		
		return "nuevoproduct";
	}
	
	@PostMapping("/producto/guardar")
	public ModelAndView saveNewProduct(Model model, @ModelAttribute(name = "product") Product product) {
		
		ModelAndView modelView = new ModelAndView("nuevoproduct");
		model.addAttribute("product", productService.getProduct());
		productService.addProduct(product);
		
		return modelView;
	}
	
	@GetMapping("/producto/lista")
	public String getProductListPage(Model model) {
		
		model.addAttribute("product", productService.getProduct());
		model.addAttribute("products", productService.getProducts());
		
		return "listaproduct";
	}
	
	@GetMapping("/producto/editar/{product}")
	public ModelAndView editproduct(@PathVariable String product, Model model) {
		
		ModelAndView modelView = new ModelAndView("nuevoproduct");
		Optional<Product> prod = productService.getProduct(product);
		model.addAttribute("product", prod);
		
		return modelView;
	}
	
	@GetMapping("/producto/borrar/{product}")
	public String deleteProduct(@PathVariable String product, Model model) {
		
		productService.deleteProduct(product);
		
		return "redirect:/producto/lista";
	}
	
	@GetMapping("/producto/seleccionar/{product}")
	public String selectProduct(@PathVariable String product, Model model) {
		
		Optional<Product> prod = productService.getProduct(product);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + prod.get().getProductCode()+ " ";                        
		model.addAttribute("product", prod);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("products", productService.getProducts());
		
		return "listaproduct";
	}
}
