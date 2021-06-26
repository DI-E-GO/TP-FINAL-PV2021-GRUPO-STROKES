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
	public ModelAndView saveNewOrder(Model model, @Valid @ModelAttribute(name = "order") Order order, BindingResult result) {
		ModelAndView modelView;
		if (result.hasErrors()) {
			modelView = new ModelAndView("nuevaorder");
			modelView.addObject("customers", customerService.getCustomers());
			return modelView;
		} else {
			this.customers = customerService.getCustomers();
			modelView = new ModelAndView("nuevaorder");
			String mensaje="Objeto guardado en la base de datos correctamente, "+order.getOrderNumber()+": ";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("order", orderService.getOrder());
			orderService.addOrder(order);
			modelView.addObject("customers", customers);
			return modelView;
		}
	}
	
	@GetMapping("/compra/lista")
	public String getOrderListPage(Model model) {
		
		model.addAttribute("order", orderService.getOrder());
		model.addAttribute("orders", orderService.getOrders());
		
		return "listaorder";
	}
	
	@GetMapping("/compra/editar/{orderNumber}")
	public ModelAndView editOrder(@PathVariable Long orderNumber, Model model) {
		this.customers = customerService.getCustomers();
		ModelAndView modelView = new ModelAndView("nuevaorder");
		Optional<Order> compra = orderService.getOrder(orderNumber);
		model.addAttribute("order", compra);
		modelView.addObject("customers", customers);
		return modelView;
	}
	
	@GetMapping("/compra/borrar/{orderNumber}")
	public String deleteOrder(@PathVariable Long orderNumber, Model model) {
		
		orderService.deleteOrder(orderNumber);
		
		return "redirect:/compra/lista";
	}
	
	@GetMapping("/compra/seleccionar/{orderNumber}")
	public String selectOrder(@PathVariable Long orderNumber, Model model) {
		
		Optional<Order> compra = orderService.getOrder(orderNumber);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + compra.get().getOrderNumber()+ " ";                        
		model.addAttribute("order", compra);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("orders", orderService.getOrder());
		
		return "listaorder";
	}
}
