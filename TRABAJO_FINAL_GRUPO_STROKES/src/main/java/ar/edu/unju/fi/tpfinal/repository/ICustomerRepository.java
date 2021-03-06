package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long>{
	public List<Customer> findAll();
	public Optional<Customer> findByCustomerNumber(Long customerNumber);
	public List<Customer> findByCountry(String country);
}
