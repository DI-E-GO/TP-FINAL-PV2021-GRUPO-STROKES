package ar.edu.unju.fi.tpfinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;

@Controller
public class LoginController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	IEmployeeService employeeService;
	
	@GetMapping("/auth/login")
	public String loginForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@GetMapping("/auth/registro")
	public String registroForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	@PostMapping("/auth/registro")
	public String registro(@RequestParam(name = "employeeNumber")int numero, @RequestParam(name = "email")String email, @Valid @ModelAttribute Usuario unUsuario, BindingResult result, Model model) {
		Employee employee = employeeService.searchEmployee(numero, email);
		String mensajeError = null;
		if (result.hasErrors()||employee==null) {
			mensajeError = "No se pudo registrar al usuario, campos incorrectos";
			model.addAttribute("mensaje", mensajeError);
			return "registro";
		} else {
			unUsuario.setEmployee(employee);
			model.addAttribute("usuario", usuarioService.registrar(unUsuario));
		}
		return "redirect:/auth/login";
	}
}
