package ar.edu.unju.fi.tpfinal.controller;

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
	public ModelAndView saveNewOffice(Model model , @Valid @ModelAttribute(name = "office") Office office, BindingResult result) {
		ModelAndView modelView;
		if (result.hasErrors()) {
			modelView = new ModelAndView("nuevaoffice");
			return modelView;
		} else {
			modelView = new ModelAndView("nuevaoffice");
			String mensaje="Objeto guardado en la base de datos correctamente, "+office.getOfficeCode()+": ";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("office", officeService.getOffice());
			officeService.addOffice(office);
			return modelView; 
		}
	}
	
	@GetMapping("/oficina/lista")
	public String GetOfficeListPage(Model model) {
		
		model.addAttribute("office", officeService.getOffice());
		model.addAttribute("offices", officeService.getOffices());
		
		return "listaoffice";
	}
	
	@GetMapping("/oficina/editar/{officeCode}")
	public ModelAndView editOffice(@PathVariable String officeCode, Model model) {
		
		ModelAndView modelView = new ModelAndView("nuevaoffice");
		Optional<Office> oficina = officeService.getOffice(officeCode);
		model.addAttribute("office", oficina);
		
		return modelView;
	}
	
	@GetMapping("/oficina/borrar/{officeCode}")
	public String deleteOffice(@PathVariable String officeCode, Model model) {
		
		officeService.deleteOffice(officeCode);
		
		return "redirect:/oficina/lista";
	}
	
	@GetMapping("/oficina/seleccionar/{officeCode}")
	public String selectOffice(@PathVariable String officeCode, Model model) {
		
		Optional<Office> oficina = officeService.getOffice(officeCode);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + oficina.get().getOfficeCode()+ " ";                        
		model.addAttribute("office", oficina);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("offices", officeService.getOffices());
		
		return "listaoffice";
	}
	
	@GetMapping("/oficina/busqueda")
	public String getOfficesFilter(@RequestParam(name = "country")String country, Model model, @ModelAttribute(name = "office") Office office) {
		
		model.addAttribute("office", officeService.getOffice());
		model.addAttribute("offices", officeService.findOffices(office.getCity(), country));
		
		return "listaoffice";
	}
}
