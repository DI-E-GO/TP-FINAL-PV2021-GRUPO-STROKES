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
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentController {

	@Autowired
	IPaymentService paymentService;
	
	@Autowired
	ICustomerService customerService;
	
	List<Customer> customers = new ArrayList<Customer>();
	
	@GetMapping("/pagos/nuevo")
	public String getPaymentFormPage(Model model) {
		this.customers = customerService.getCustomers();
		model.addAttribute("payment", paymentService.getPayment());
		model.addAttribute("customers", customers);
		return "nuevopayment";
	}
	
	@PostMapping("/pago/guardar")
	public ModelAndView saveNewPayment(Model model, @ModelAttribute(name = "payment") Payment payment) {
		this.customers = customerService.getCustomers();
		ModelAndView modelView = new ModelAndView("nuevopayment");
		String mensaje="Objeto guardado en la base de datos correctamente, "+payment.getCheckNumber()+": ";
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("payment", paymentService.getPayment());
		paymentService.addPayment(payment);
		modelView.addObject("customers", customers);
		
		return modelView;
	}
	
	@GetMapping("/pagos/lista")
	public String getPaymentListPage(Model model) {
		
		model.addAttribute("payment", paymentService.getPayment());
		model.addAttribute("payments", paymentService.getPayments());
		
		return "listapayment";
	}
	
	@GetMapping("/pago/editar/{checkNumber}")
	public ModelAndView editPayment(@PathVariable String checkNumber, Model model) {
		this.customers = customerService.getCustomers();
		ModelAndView modelView = new ModelAndView("nuevopayment");
		Optional<Payment> pago = paymentService.getPayment(checkNumber);
		model.addAttribute("payment", pago);
		modelView.addObject("customers", customers);
		
		return modelView;
	}
	
	@GetMapping("/pago/borrar/{checkNumber}")
	public String deletePayment(@PathVariable String checkNumber, Model model) {
		
		paymentService.deletePayment(checkNumber);
		
		return "redirect:/pagos/lista";
	}
	
	@GetMapping("/pago/seleccionar/{checkNumber}")
	public String selectPayment(@PathVariable String checkNumber, Model model) {
		
		Optional<Payment> pago = paymentService.getPayment(checkNumber);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + pago.get().getCheckNumber()+ " ";                        
		model.addAttribute("payment", pago);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("payments", paymentService.getPayments());
		
		return "listapayment";
	}
}
