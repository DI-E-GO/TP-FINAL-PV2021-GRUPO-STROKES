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
		
		model.addAttribute(customerService.getCustomer());
		model.addAttribute("employees", employees);
		
		return "nuevocustomer";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView saveNewCustomer(Model model, @Valid @ModelAttribute("customer") Customer customer, BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			this.employees = employeeService.getEmployees();
			modelView = new ModelAndView("nuevoCustomer");
			return modelView;
		} else {
			this.employees = employeeService.getEmployees();
			modelView = new ModelAndView("nuevoCustomer");
			String mensaje="Objeto guardado en la base de datos correctamente, "+customer.getCustomerName()+": ";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("customer", customerService.getCustomer());
			customerService.addCustomer(customer);
			modelView.addObject("employees", employees);
			return modelView;
		}
	}
	
	@GetMapping("/cliente/lista")
	public ModelAndView getCustomersListPage() {
		
		ModelAndView modelView = new ModelAndView("listacustomer");
		modelView.addObject("customers", customerService.getCustomers());
		
		return modelView;
	}
	
	@GetMapping("/cliente/editar/{customerNumber}")
	public ModelAndView editCustomer(@PathVariable Long customerNumber, Model model) {
		this.employees = employeeService.getEmployees();
		ModelAndView modelView = new ModelAndView("nuevocustomer");
		Optional<Customer> cliente = customerService.getCustomer(customerNumber);
		model.addAttribute("customer", cliente);
		modelView.addObject("employees", employees);
		return modelView;
	}
	
	@GetMapping("/cliente/borrar/{customerNumber}")
	public String deleteCustomer(@PathVariable Long customerNumber, Model model) {
		
		customerService.deleteCustomer(customerNumber);
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/cliente/seleccionar/{customerNumber}")
	public String selectCustomer(@PathVariable Long customerNumber, Model model) {
		
		Optional<Customer> cliente = customerService.getCustomer(customerNumber);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + cliente.get().getCustomerNumber()+ " ";                        
		model.addAttribute("customer", cliente);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("customers", customerService.getCustomers());
		
		return "listacustomer";
	}
	@GetMapping("/cliente/buscar")
	public String searchCustomerByCountry(Model model, @RequestParam(name = "ciudad")String ciudad) {
		model.addAttribute("customers", customerService.buscarPorCiudad(ciudad));
		return "listacustomer";
	}
}
