package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Controller
public class OfficeController {

	@Autowired
	IOfficeService officeService;

	@GetMapping("/oficina/nueva")
	public String getOfficePage(Model model) {
		
		model.addAttribute("office", officeService.getOffice());
		
		return "nuevaoffice";
	}
	
	@PostMapping("/oficina/guardar")
	public ModelAndView saveNewOffice(Model model , @ModelAttribute(name = "office") Office office) {
		
		ModelAndView modelView = new ModelAndView("nuevaoffice");
		model.addAttribute("office", officeService.getOffice());
		officeService.addOffice(office);
		
		return modelView; 
	}
	
	@GetMapping("/oficina/lista")
	public String GetOfficeListPage(Model model) {
		
		model.addAttribute("office", officeService.getOffice());
		model.addAttribute("offices", officeService.getOffices());
		
		return "listaoffice";
	}
	
	@GetMapping("/oficina/editar/{office}")
	public ModelAndView editOffice(@PathVariable String office, Model model) {
		
		ModelAndView modelView = new ModelAndView("nuevaoffice");
		Optional<Office> oficina = officeService.getOffice(office);
		model.addAttribute("office", oficina);
		
		return modelView;
	}
	
	@GetMapping("/oficina/borrar/{office}")
	public String deleteOffice(@PathVariable String office, Model model) {
		
		officeService.deleteOffice(office);
		
		return "redirect:/oficina/lista";
	}
	
	@GetMapping("/oficina/seleccionar/{office}")
	public String selectOffice(@PathVariable String office, Model model) {
		
		Optional<Office> oficina = officeService.getOffice(office);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + oficina.get().getOfficeCode()+ " ";                        
		model.addAttribute("office", oficina);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("offices", officeService.getOffices());
		
		return "listaoffice";
	}
}