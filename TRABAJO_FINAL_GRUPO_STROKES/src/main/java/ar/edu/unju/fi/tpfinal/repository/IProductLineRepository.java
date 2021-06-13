package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineRepository extends CrudRepository<ProductLine, String>{
	public List<ProductLine> findAll();
	public Optional<ProductLine> findByProductCode();
}
