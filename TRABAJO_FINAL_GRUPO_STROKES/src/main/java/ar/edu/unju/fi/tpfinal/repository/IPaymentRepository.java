package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Payment;

public interface IPaymentRepository extends CrudRepository<Payment, String>{
	public List<Payment> findAll();
	public Optional<Payment> findBycheckNumber(String checkNumber);
}
