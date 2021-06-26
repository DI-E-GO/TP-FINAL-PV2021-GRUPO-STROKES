package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;

public interface IOrderDetailRepository extends CrudRepository<OrderDetail, Long>{
	public List<OrderDetail> findAll();
	public Optional<OrderDetail> findById(Long id);
	public List<OrderDetail> findAllByOrderLineNumber(Long numero);
}
