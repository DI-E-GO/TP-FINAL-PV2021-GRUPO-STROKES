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

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class OrderDetailController {

	@Autowired
	IOrderDetailService orderDetailService;
	
	@Autowired
	IProductService productService;
	
	List<Product> products = new ArrayList<Product>();
	
	@Autowired
	IOrderService orderService;
	
	List<Order> orders = new ArrayList<Order>();
	
	@GetMapping("/detalle/nuevo")
	public String getOrderDetailFormPage(Model model) {
		
		this.products = productService.getProducts();
		this.orders = orderService.getOrders();
		
		model.addAttribute("orderDetail", orderDetailService.getOrderDetail());
		model.addAttribute("products", products);
		model.addAttribute("orders", orders);
		
		return "neworderdetail";
	}
	
	@PostMapping("/detalle/guardar")
	public ModelAndView saveNewOrderDetail(Model model, @Valid @ModelAttribute(name = "orderDetail") OrderDetail orderDetail, BindingResult result) {
		ModelAndView modelView;
		if (result.hasErrors()) {
			modelView = new ModelAndView("neworderdetail");
			modelView.addObject("orders", orderService.getOrders());
			modelView.addObject("products", productService.getProducts());
			return modelView;
		} else {
			this.orders = orderService.getOrders();
			this.products = productService.getProducts();
			modelView = new ModelAndView("neworderdetail"); 
			String mensaje="Objeto guardado en la base de datos correctamente, "+orderDetail.getOrderLineNumber()+": ";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("orderDetail", orderDetailService.getOrderDetail());
			orderDetailService.addOrderDetail(orderDetail);
			modelView.addObject("orders", orders);
			modelView.addObject("products", products);
			return modelView;
		}
	}
	
	@GetMapping("/detalle/lista")
	public String getOrderDetailListPage(Model model) {
		
		model.addAttribute("orderDetail", orderDetailService.getOrderDetail());
		model.addAttribute("orderDetails", orderDetailService.getOrderDetails());
		
		return "listaorderdetail";
	}
	
	@GetMapping("/detalle/editar/{id}")
	public ModelAndView editOrderDetail(@PathVariable Long id, Model model) {
		this.orders = orderService.getOrders();
		this.products = productService.getProducts();
		ModelAndView modelView = new ModelAndView("neworderdetail");
		Optional<OrderDetail> detail = orderDetailService.getOrderDetail(id);
		model.addAttribute("orderDetail", detail);
		modelView.addObject("orders", orders);
		modelView.addObject("products", products);
		
		return modelView;
	}
	
	@GetMapping("/detalle/borrar/{id}")
	public String deleteOrderDetail(@PathVariable Long id, Model model) {
		
		orderDetailService.deleteOrderDetail(id);
		
		return "redirect:/detalle/lista";
	}
	
	@GetMapping("/detalle/seleccionar/{id}")
	public String selectOrderDetail(@PathVariable Long id, Model model) {
		
		Optional<OrderDetail> detail = orderDetailService.getOrderDetail(id);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + detail.get().getId()+ " ";                        
		model.addAttribute("orderDetail", detail);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("orderDetails", orderDetailService.getOrderDetails());
		
		return "listaorderdetail";
	}

}
