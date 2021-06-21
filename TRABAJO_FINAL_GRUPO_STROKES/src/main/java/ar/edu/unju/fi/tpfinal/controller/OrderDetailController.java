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
		
		return "neworderservice";
	}
	
	@PostMapping("/detalle/guardar")
	public ModelAndView saveNewOrderDetail(Model model, @ModelAttribute(name = "orderDetail") OrderDetail orderDetail) {
		
		ModelAndView modelView = new ModelAndView("neworderservice"); 
		model.addAttribute("orderDetail", orderDetailService.getOrderDetail());
		orderDetailService.addOrderDetail(orderDetail);
		
		return modelView;
	}
	
	@GetMapping("/detalle/lista")
	public String getOrderDetailListPage(Model model) {
		
		model.addAttribute("orderDetail", orderDetailService.getOrderDetail());
		model.addAttribute("orderDetails", orderDetailService.getOrderDetails());
		
		return "listorderdetail";
	}
	
	@GetMapping("/detalle/editar/{orderDetail}")
	public ModelAndView editOrderDetail(@PathVariable Long orderDetail, Model model) {
		
		ModelAndView modelView = new ModelAndView("neworderdetail");
		Optional<OrderDetail> detail = orderDetailService.getOrderDetail(orderDetail);
		model.addAttribute("orderDetail", detail);
		
		return modelView;
	}
	
	@GetMapping("/detalle/borrar/{orderDetail}")
	public String deleteOrderDetail(@PathVariable Long orderDetail, Model model) {
		
		orderDetailService.deleteOrderDetail(orderDetail);
		
		return "redirect:/detalle/lista";
	}
	
	@GetMapping("/detalle/seleccionar/{orderDetail}")
	public String selectOrderDetail(@PathVariable Long orderDetail, Model model) {
		
		Optional<OrderDetail> detail = orderDetailService.getOrderDetail(orderDetail);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + detail.get().getId()+ " ";                        
		model.addAttribute("orderDetail", detail);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("orderDetails", orderDetailService.getOrderDetails());
		
		return "listaorderdetail";
	}

}
