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

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Controller
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@Autowired
	IEmployeeService employeeService;
	
	List<Employee> employees = new ArrayList<Employee>();
	
	@GetMapping("/cliente/nuevo")
	public String getFormCustomerPage(Model model) {
		this.employees = employeeService.getEmployees();
		
		model.addAttribute("customer", customerService.getCustomer());
		model.addAttribute("customers", employees);
		
		return "nuevocustomer";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView saveNewCustomer(Model model, @ModelAttribute(name = "customer") Customer customer) {
		
		ModelAndView modelView = new ModelAndView("nuevoCustomer");
		model.addAttribute("customer", customerService.getCustomer());
		customerService.addCustomer(customer);
		
		return modelView;
	}
	
	@GetMapping("/cliente/lista")
	public ModelAndView getCustomersListPage() {
		
		ModelAndView modelView = new ModelAndView("listacustomer");
		modelView.addObject("customers", customerService.getCustomers());
		
		return modelView;
	}
	
	@GetMapping("/cliente/editar/{customer}")
	public ModelAndView editCustomer(@PathVariable Long customer, Model model) {
		
		ModelAndView modelView = new ModelAndView("nuevocustomer");
		Optional<Customer> cliente = customerService.getCustomer(customer);
		model.addAttribute("customer", cliente);
		
		return modelView;
	}
	
	@GetMapping("/cliente/borrar/{customer}")
	public String deleteCustomer(@PathVariable Long customer, Model model) {
		
		customerService.deleteCustomer(customer);
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/cliente/seleccionar/{customer}")
	public String selectCustomer(@PathVariable Long customer, Model model) {
		
		Optional<Customer> cliente = customerService.getCustomer(customer);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + cliente.get().getCustomerNumber()+ " ";                        
		model.addAttribute("customer", cliente);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("customers", customerService.getCustomers());
		
		return "listacustomer";
	}

}
