/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.repository.IOfficeRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

/**
 * @author Diego
 *
 */
@Service
public class OfficeServiceImp implements IOfficeService {
	
	@Autowired
	IOfficeRepository officeRepository;
	
	@Autowired
	Office office;

	@Override
	public Office getOffice() {
		// TODO Auto-generated method stub
		return office;
	}

	@Override
	public void addOffice(Office office) {
		// TODO Auto-generated method stub
		officeRepository.save(office);
	}

	@Override
	public void deleteOffice(String officeCode) {
		// TODO Auto-generated method stub
		officeRepository.deleteById(officeCode);
	}

	@Override
	public Optional<Office> getOffice(String officeCode) {
		// TODO Auto-generated method stub
		return officeRepository.findById(officeCode);
	}

	@Override
	public List<Office> getOffices() {
		// TODO Auto-generated method stub
		return officeRepository.findAll();
	}

	@Override
	public List<Office> findOffices(String city, String country) {
		
		List<Office> offices = new ArrayList<Office>();
		
		if(!city.isEmpty() && !country.isEmpty()) {
			offices = officeRepository.findByCityAndCountryLike(city, country);
		}else if (!city.isEmpty() && country.isEmpty()) {
			offices = officeRepository.findByCityLike(city);
		}else if (city.isEmpty() && !country.isEmpty()) {
			offices = officeRepository.findByCountryLike(country);
		}else if(city.isEmpty() && country.isEmpty()) {
			offices = officeRepository.findAll();
		}
		
		return offices;
	}

}
