package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Payment;

public interface IPaymentService {
	public Payment getPayment();
	public void addPayment(Payment customer);
	public void deletePayment(String checkNumber);
	public Optional<Payment> getPayment(String checkNumber);
	public List<Payment> getPayments();
}
