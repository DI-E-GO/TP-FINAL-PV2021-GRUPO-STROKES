package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@SpringBootApplication
public class TrabajoFinalGrupoStrokesApplication implements CommandLineRunner{
	@Autowired
	IEmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(TrabajoFinalGrupoStrokesApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception{
		Employee e1 = new Employee(1000, "Pérez", "Pablo", "x5432", "pablito777@gmail.com", "Precidente");
		Employee e2 = new Employee(1010, "Méndez", "Roberta", "x2360", "rober1023@gmail.com", "Gerente");
		Employee e3 = new Employee(1020, "Rossi", "Francisco", "x3239", "fran090@gmail.com", "Vendedor");
		employeeService.addEmployee(e1);
		employeeService.addEmployee(e2);
		employeeService.addEmployee(e3);
	}
	
}
