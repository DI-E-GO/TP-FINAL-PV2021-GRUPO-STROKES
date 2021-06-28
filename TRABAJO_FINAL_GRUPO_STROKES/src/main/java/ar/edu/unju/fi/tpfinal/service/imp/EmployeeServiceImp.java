/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

/**
 * @author Diego
 *
 */
@Service
public class EmployeeServiceImp implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Autowired
	Employee employee;

	@Override
	public Employee getEmployee() {
		// TODO Auto-generated method stub
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long employeeNumber) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employeeNumber);
	}

	@Override
	public Optional<Employee> getEmployee(Long employeeNumber) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employeeNumber);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee searchEmployee(Long numero, String email) {
		return employeeRepository.findByEmployeeNumberAndEmailGreaterThanEqual(numero, email);
	}

	@Override
	public List<Employee> searchEmployees(String lastName, String jobTitle) {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		if(!lastName.isEmpty() && !jobTitle.isEmpty()) {
			employees = employeeRepository.findByLastNameAndJobTitleLike(lastName, jobTitle);
		}else if (!lastName.isEmpty() && jobTitle == "") {
			employees = employeeRepository.findByLastNameLike(lastName);
			
		}else if (lastName == "" && !jobTitle.isEmpty()) {
			employees = employeeRepository.findByJobTitleLike(jobTitle);
		}else if(lastName == "" && jobTitle == "") {
			employees = employeeRepository.findAll();
		}
		return employees;
	}

}
