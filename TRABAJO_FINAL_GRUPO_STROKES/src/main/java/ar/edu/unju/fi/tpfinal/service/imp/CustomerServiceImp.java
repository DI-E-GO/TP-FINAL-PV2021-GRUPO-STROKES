/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.repository.ICustomerRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;

/**
 * @author Diego
 *
 */
@Service
public class CustomerServiceImp implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	Customer customer;

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return customer;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long customerNumber) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerNumber);
	}

	@Override
	public Optional<Customer> getCustomer(Long customerNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerNumber);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> buscarPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return customerRepository.findByCountry(ciudad);
	}

}
