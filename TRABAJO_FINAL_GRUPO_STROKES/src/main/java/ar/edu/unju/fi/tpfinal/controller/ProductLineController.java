package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Controller
public class ProductLineController {
	@Autowired
	IProductLineService productLineService;
	@GetMapping("/productline/nuevo")
	public String formProductLinePage(Model model) {
		model.addAttribute("productline", productLineService.getProductLine());
		return "nuevo-productline";
	}
	@PostMapping("/productline/guardar")
	public ModelAndView saveProductLine(Model model,@RequestParam("file") MultipartFile file, @ModelAttribute("productline")ProductLine productLine) {
		ModelAndView modelView = new ModelAndView("nuevo-productline");
		String mensaje="Objeto guardado en la base de datos correctamente, "+productLine.getProductLine()+": ";
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("productline", productLineService.getProductLine());
		productLineService.addProductLine(file, productLine);
		return modelView;
	}
	@GetMapping("/productline/lista")
	public String listProductLinePage(Model model) {
		model.addAttribute("productline", productLineService.getProductLine());
		model.addAttribute("productlines", productLineService.getProductLines());
		return "lista-productlines";
	}
	@GetMapping("/productline/editar/{productLine}")
	public ModelAndView editProductLine(@PathVariable String productLine, Model model) {
		Optional<ProductLine> prodLine = productLineService.getProductLine(productLine);
		model.addAttribute("productline", prodLine);
		ModelAndView modelView = new ModelAndView("nuevo-productline");
		return modelView;
	}
	@GetMapping("/productline/borrar/{productLine}")
	public String deletedProductLine(@PathVariable String productLine, Model model) {
		productLineService.deleteProductLine(productLine);
		return "redirect:/productline/lista";
	}
	@GetMapping("/productline/seleccionar/{productLine}")
	public String selectProductLine(@PathVariable String productLine, Model model) {
		Optional<ProductLine> prodLine = productLineService.getProductLine(productLine);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: "+prodLine.get().getProductLine()+" ";
		model.addAttribute("productline", prodLine);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("productlines", productLineService.getProductLines());
		return "lista-productlines";
	}
}
