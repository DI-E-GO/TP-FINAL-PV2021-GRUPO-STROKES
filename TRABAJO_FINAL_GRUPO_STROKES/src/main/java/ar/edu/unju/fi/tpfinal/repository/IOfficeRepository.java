package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Office;

public interface IOfficeRepository extends CrudRepository<Office, String>{
	public List<Office> findAll();
	public Optional<Office> findByOfficeCode(String officeCode);
	public List<Office> findByCityAndCountryLike(String city, String country);
	public List<Office> findByCityLike(String city);
	public List<Office> findByCountryLike(String country);
}
