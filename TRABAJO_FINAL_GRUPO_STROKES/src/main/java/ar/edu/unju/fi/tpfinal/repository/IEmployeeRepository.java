package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long>{
	public List<Employee> findAll();
	public Optional<Employee> findByEmployeeNumber(Long employeeNumber);
	public Employee findByEmployeeNumberAndEmailGreaterThanEqual(Long numero, String email);
	public List<Employee> findByLastNameAndJobTitleLike(String lastName, String jobTitle);
	public List<Employee> findByJobTitleLike(String jobTitle);
	public List<Employee> findByLastNameLike(String lastName);
}
