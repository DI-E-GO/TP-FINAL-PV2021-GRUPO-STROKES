/**
 * 
 */
package ar.edu.unju.fi.tpfinal.model;

import org.springframework.stereotype.Component;

/**
 * @author Torrejon Cristian
 *
 */
/**
 * Clase que almacena lod datos del empleado
 */
@Component
public class Employee {
	
	//Atributos 
	
	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;
	
	/**
	 * Constructores
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeNumber
	 * @param lastName
	 * @param firstName
	 * @param extension
	 * @param email
	 * @param officeCode
	 * @param reportsTo
	 * @param jobTitle
	 */
	public Employee(int employeeNumber, String lastName, String firstName, String extension, String email,
			String officeCode, int reportsTo, String jobTitle) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}

	/**
	 * Getters y Setters
	 */
	/**
	 * @return the employeeNumber
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the officeCode
	 */
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * @param officeCode the officeCode to set
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	/**
	 * @return the reportsTo
	 */
	public int getReportsTo() {
		return reportsTo;
	}

	/**
	 * @param reportsTo the reportsTo to set
	 */
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	//Metodo toString
	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + "]";
	}
	
	
	

}