package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Office;

public interface IOfficeService {
	public Office getOffice();
	public void addOffice(Office office);
	public void deleteOffice(String officeCode);
	public Optional<Office> getOffice(String officeCode);
	public List<Office> getOffices();
}
