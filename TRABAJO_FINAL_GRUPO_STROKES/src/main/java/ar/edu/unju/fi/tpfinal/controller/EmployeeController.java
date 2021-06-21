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

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Controller
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;
	
	@Autowired
	IOfficeService officeService;
	
	List<Office> offices = new ArrayList<Office>();
	
	@GetMapping("/empleados/nuevo")
	public String getEmployeeFormPage(Model model) {
		
		this.offices = officeService.getOffices();
		model.addAttribute("employees", employeeService.getEmployee());
		model.addAttribute("offices", offices);
		
		return "nuevoemployee";
	}
	
	@PostMapping("/empleado/guardar")
	public ModelAndView saveNewEmployee(Model model, @ModelAttribute(name = "employee") Employee employee) {
		
		ModelAndView modelView = new ModelAndView("nuevoemployee");
		model.addAttribute("employee", employeeService.getEmployee());
		employeeService.addEmployee(employee);
		
		return modelView; 
	}
	
	@GetMapping("/empleado/lista")
	public String getEmployeeListPage(Model model) {
		
		model.addAttribute("employee", employeeService.getEmployee());
		model.addAttribute("employees", employeeService.getEmployees());
		
		return "listaemployee";
	}

	@GetMapping("/empleado/editar/{employee}")
	public ModelAndView editEmployee(@PathVariable Long employee, Model model) {
		
		ModelAndView modelView = new ModelAndView("nuevoemployee");
		Optional<Employee> empleado = employeeService.getEmployee(employee);
		model.addAttribute("employee", empleado);
		
		return modelView;
	}
	
	@GetMapping("/empleado/borrar/{employee}")
	public String deleteEmployee(@PathVariable Long employee, Model model) {
		
		employeeService.deleteEmployee(employee);
		
		return "redirect:/empleado/lista";
	}
	
	@GetMapping("/empleado/seleccionar/{employee}")
	public String selectEmployee(@PathVariable Long employee, Model model) {
		
		Optional<Employee> empleado = employeeService.getEmployee(employee);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + empleado.get().getEmployeeNumber()+ " ";                        
		model.addAttribute("employee", empleado);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("employees", employeeService.getEmployees());
		
		return "listaemployee";
	}
}
