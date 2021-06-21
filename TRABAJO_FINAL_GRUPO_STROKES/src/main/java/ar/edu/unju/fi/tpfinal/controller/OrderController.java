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
import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Controller
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@Autowired
	ICustomerService customerService;
	
	List<Customer> customers = new ArrayList<Customer>();
	
	@GetMapping("/compra/nueva")
	public String getOrderFormPage(Model model) {
		this.customers = customerService.getCustomers();
		model.addAttribute("order", orderService.getOrder());
		model.addAttribute("customers", customers);
		
		return "nuevaorder";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView saveNewOrder(Model model, @ModelAttribute(name = "order") Order order) {
		
		ModelAndView modelView = new ModelAndView("nuevaorder");
		model.addAttribute("order", orderService.getOrder());
		orderService.addOrder(order);
		
		return modelView;
	}
	
	@GetMapping("/compra/lista")
	public String getOrderListPage(Model model) {
		
		model.addAttribute("order", orderService.getOrder());
		model.addAttribute("orders", orderService.getOrders());
		
		return "listaorder";
	}
	
	@GetMapping("/compra/editar/{order}")
	public ModelAndView editOrder(@PathVariable Long order, Model model) {
		
		ModelAndView modelView = new ModelAndView("nuevaorder");
		Optional<Order> compra = orderService.getOrder(order);
		model.addAttribute("order", compra);
		
		return modelView;
	}
	
	@GetMapping("/compra/borrar/{order}")
	public String deleteOrder(@PathVariable Long order, Model model) {
		
		orderService.deleteOrder(order);
		
		return "redirect:/compra/lista";
	}
	
	@GetMapping("/compra/seleccionar/{order}")
	public String selectOrder(@PathVariable Long order, Model model) {
		
		Optional<Order> compra = orderService.getOrder(order);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + compra.get().getOrderNumber()+ " ";                        
		model.addAttribute("order", compra);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("orders", orderService.getOrder(order));
		
		return "listaorder";
	}
}
