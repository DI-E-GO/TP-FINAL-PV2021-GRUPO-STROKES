package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Product;

public interface IProductRepository extends CrudRepository<Product, String>{
	public List<Product> findAll();
	public Optional<Product> findByProductCode();
}
