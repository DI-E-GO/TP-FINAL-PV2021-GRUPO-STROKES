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
		model.addAttribute("customer", customers);
		return "nuevopayment";
	}
	
	@PostMapping("/pago/guardar")
	public ModelAndView saveNewPayment(Model model, @ModelAttribute(name = "payment") Payment payment) {
		
		ModelAndView modelView = new ModelAndView("nuevopayment");
		model.addAttribute("payment", paymentService.getPayment());
		paymentService.addPayment(payment);
		
		return modelView;
	}
	
	@GetMapping("/pagos/lista")
	public String getPaymentListPage(Model model) {
		
		model.addAttribute("payment", paymentService.getPayment());
		model.addAttribute("payments", paymentService.getPayments());
		
		return "listapayment";
	}
	
	@GetMapping("/pagos/editar/{payment}")
	public ModelAndView editPayment(@PathVariable String payment, Model model) {
		
		ModelAndView modelView = new ModelAndView("nuevopayment");
		Optional<Payment> pago = paymentService.getPayment(payment);
		model.addAttribute("payment", pago);
		
		return modelView;
	}
	
	@GetMapping("/pagos/borrar/{payment}")
	public String deletePayment(@PathVariable String payment, Model model) {
		
		paymentService.deletePayment(payment);
		
		return "redirect:/pagos/lista";
	}
	
	@GetMapping("/pago/seleccionar/{payment}")
	public String selectPayment(@PathVariable String payment, Model model) {
		
		Optional<Payment> pago = paymentService.getPayment(payment);
		String mensajeBorrar = "Usted está por eliminar un objeto de la base de datos: " + pago.get().getCheckNumber()+ " ";                        
		model.addAttribute("payment", pago);
		model.addAttribute("mensajeBorrar", mensajeBorrar);
		model.addAttribute("payments", paymentService.getPayments());
		
		return "listapayment";
	}
}
