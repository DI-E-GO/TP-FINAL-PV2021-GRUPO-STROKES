package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderRepository extends CrudRepository<Order, Long>{
	public List<Order> findAll();
	public Optional<Order> findByOrderNumber(Long orderNumber);
	public List<Order> findByStatus(String status);
}
