/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

/**
 * @author Diego
 *
 */
@Service
public class PaymentServiceImp implements IPaymentService {
	
	@Autowired
	IPaymentRepository paymentRepository;
	
	@Autowired
	Payment payment;

	@Override
	public Payment getPayment() {
		// TODO Auto-generated method stub
		return payment;
	}

	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentRepository.save(payment);
	}

	@Override
	public void deletePayment(String checkNumber) {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(checkNumber);
	}

	@Override
	public Optional<Payment> getPayment(String checkNumber) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(checkNumber);
	}

	@Override
	public List<Payment> getPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public List<Payment> findPayments(Long customerNumber, double amount) {
		
		List<Payment> payments = new ArrayList<Payment>();
		
		if(customerNumber > 0 && amount ==0) {
			payments = paymentRepository.findByCustomerNumberCustomerNumberEquals(customerNumber);
		}else if(customerNumber==0 && amount > 0) {
			payments = paymentRepository.findByAmountGreaterThanEqual(amount);
		}else if(customerNumber > 0 && amount > 0) {
			payments = paymentRepository.findByCustomerNumberCustomerNumberAndAmountGreaterThanEqual(customerNumber, amount);
		}
		else if(customerNumber == 0 && amount == 0) {
			payments = paymentRepository.findAll();
		}
		
		return payments;
	}

	

}
