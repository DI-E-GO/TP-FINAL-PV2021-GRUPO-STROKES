package ar.edu.unju.fi.tpfinal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView saveNewProduct(Model model, @Valid @ModelAttribute(name = "product") Product product, BindingResult result) {
		ModelAndView modelView;
		if (result.hasErrors()) {
			modelView = new ModelAndView("nuevoproduct");
			modelView.addObject("productLines", productLineService.getProductLines());
			return modelView;
		} else {
			this.productLines = productLineService.getProductLines();
			modelView = new ModelAndView("nuevoproduct");
			String mensaje="Objeto guardado en la base de datos correctamente, "+product.getProductName()+": ";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("product", productService.getProduct());
			productService.addProduct(product);
			modelView.addObject("productLines", productLines);
			return modelView;
		}
	}
	
	@GetMapping("/producto/lista")
	public String getProductListPage(Model model) {
		
		model.addAttribute("product", productService.getProduct());
		model.addAttribute("products", productService.getProducts());
		
		return "listaproduct";
	}
	
	@GetMapping("/producto/editar/{productCode}")
	public ModelAndView editproduct(@PathVariable String productCode, Model model) {
		this.productLines = productLineService.getProductLines();
		ModelAndView modelView = new ModelAndView("nuevoproduct");
		Optional<Product> prod = productService.getProduct(productCode);
		model.addAttribute("product", prod);
		modelView.addObject("productLines", productLines);
		
		return modelView;
	}
	
	@GetMapping("/producto/borrar/{productCode}")
	public String deleteProduct(@PathVariable String productCode, Model model) {
		
		productService.deleteProduct(productCode);
		
		return "redirect:/producto/lista";
	}
	
	@GetMapping("/producto/seleccionar/{productCode}")
	public String selectProduct(@PathVariable String productCode, Model model) {
		
		Optional<Product> prod = productService.getProduct(productCode);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + prod.get().getProductCode()+ " ";                        
		model.addAttribute("product", prod);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("products", productService.getProducts());
		
		return "listaproduct";
	}
	
	@GetMapping("/producto/busqueda")
	public String getProductsFilters(@RequestParam(name = "buyPrice") double buyPrice , Model model,@ModelAttribute(name = "product") Product product ) {
		
		model.addAttribute("product", productService.getProduct());
		model.addAttribute("products", productService.findProducts(product.getProductLine().getProductLine(), buyPrice));
		
		return "listaproduct";
	}
}
