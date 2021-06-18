package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ModelAndView saveProductLine(Model model, @ModelAttribute("productline")ProductLine productLine) {
		ModelAndView modelView = new ModelAndView("nuevo-productline");
		String mensaje="Objeto guardado en la base de datos correctamente, "+productLine.getTextDescription()+": ";
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("productline", productLineService.getProductLine());
		productLineService.addProductLine(productLine);
		return modelView;
	}
	@GetMapping("/productline/lista")
	public String listProductLinePage(Model model) {
		model.addAttribute("productline", productLineService.getProductLine());
		model.addAttribute("productlines", productLineService.getProductLines());
		return "lista-productlines";
	}
}
