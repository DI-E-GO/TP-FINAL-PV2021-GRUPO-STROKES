package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Customer;

public interface ICustomerService {
	public Customer getCustomer();
	public void addCustomer(Customer customer);
	public void deleteCustomer(Long customerNumber);
	public Optional<Customer> getCustomer(Long customerNumber);
	public List<Customer> getCustomers();
}
