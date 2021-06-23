/**
 * 
 */
package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpfinal.service.IProductLineService;

/**
 * @author Diego
 *
 */
@Controller
@RequestMapping("/public")
public class PublicController {
	@Autowired
	IProductLineService productLineService;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("productlines", productLineService.getProductLines());
		return "logout";
	}
}
