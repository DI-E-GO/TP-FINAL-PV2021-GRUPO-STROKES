package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeeService {
	public Employee getEmployee();
	public void addEmployee(Employee employee);
	public void deleteEmployee(Long employeeNumber);
	public Optional<Employee> getEmployee(Long employeeNumber);
	public List<Employee> getEmployees();
}
