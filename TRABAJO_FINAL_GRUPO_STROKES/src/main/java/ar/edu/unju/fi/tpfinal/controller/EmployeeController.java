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
	
	@GetMapping("/empleado/nuevo")
	public String getEmployeeFormPage(Model model) {
		
		this.offices = officeService.getOffices();
		model.addAttribute("employee", employeeService.getEmployee());
		model.addAttribute("offices", offices);
		model.addAttribute("employees", employeeService.getEmployees());
		return "nuevoemployee";
	}
	
	@PostMapping("/empleado/guardar")
	public ModelAndView saveNewEmployee(Model model, @Valid @ModelAttribute(name = "employee") Employee employee, BindingResult result) {
		ModelAndView modelView;
		if (result.hasErrors()) {
			this.offices = officeService.getOffices();
			modelView = new ModelAndView("nuevoemployee");
			model.addAttribute("employees", employeeService.getEmployees());			
			modelView.addObject("offices", offices);
			return modelView;
		} else {
			this.offices = officeService.getOffices();
			modelView = new ModelAndView("nuevoemployee");
			String mensaje="Objeto guardado en la base de datos correctamente, "+employee.getFirstName()+": ";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("employee", employeeService.getEmployee());
			modelView.addObject("offices", offices);
			employeeService.addEmployee(employee);
			return modelView; 
		}
	}
	
	@GetMapping("/empleado/lista")
	public String getEmployeeListPage(Model model) {
		
		model.addAttribute("employee", employeeService.getEmployee());
		model.addAttribute("employees", employeeService.getEmployees());
		
		return "listaemployee";
	}

	@GetMapping("/empleado/editar/{employeeNumber}")
	public ModelAndView editEmployee(@PathVariable Long employeeNumber, Model model) {
		this.offices = officeService.getOffices();
		ModelAndView modelView = new ModelAndView("nuevoemployee");
		Optional<Employee> empleado = employeeService.getEmployee(employeeNumber);
		model.addAttribute("employee", empleado);
		modelView.addObject("offices", offices);
		
		return modelView;
	}
	
	@GetMapping("/empleado/borrar/{employeeNumber}")
	public String deleteEmployee(@PathVariable Long employeeNumber, Model model) {
		
		employeeService.deleteEmployee(employeeNumber);
		
		return "redirect:/empleado/lista";
	}
	
	@GetMapping("/empleado/seleccionar/{employeeNumber}")
	public String selectEmployee(@PathVariable Long employeeNumber, Model model) {
		
		Optional<Employee> empleado = employeeService.getEmployee(employeeNumber);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + empleado.get().getEmployeeNumber()+ " ";                        
		model.addAttribute("employee", empleado);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("employees", employeeService.getEmployees());
		
		return "listaemployee";
	}
	
	@GetMapping("/empleado/busqueda")
	public String getEmployeesFilter(@RequestParam(name = "jobTitle") String jobTitle, Model model, @ModelAttribute(name = "employee") Employee employee) {
		
		model.addAttribute("employee", employeeService.getEmployee());
		model.addAttribute("employees", employeeService.searchEmployees(employee.getLastName(), jobTitle));
		
		return "listaemployee";
	}
}
