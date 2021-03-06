/**
 * 
 */
package ar.edu.unju.fi.tpfinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * @author Torrejon Cristian
 *
 */
/**
 * Clase que almacena lod datos del empleado
 */
@Component
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
	
	//Atributos 
	@NotNull(message = "Ingrese el numero de empleado")
	@Id
	@Column(name = "employee_number_id")
	private Long employeeNumber;
	@NotEmpty(message = "Ingrese un nombre para el empleado")
	@Column(name = "last_name")
	private String lastName;
	@NotEmpty(message = "Ingrese un apellido para el empleado")
	@Column(name = "first_name")
	private String firstName;
	@NotEmpty(message = "Falta codigo de extencion")
	@Column(name = "extension")
	private String extension;
	@Email(message = "Ingrese un correo válido")
	@NotEmpty(message = "Ingrese una dirección de correo")
	@Column(name = "email")
	private String email;
	@NotNull(message = "Seleccione una extención")
	@ManyToOne
	@JoinColumn(name = "office_code_id")
	private Office officeCode;
	
	@ManyToOne
	@JoinColumn(name = "reports_to", referencedColumnName = "employee_number_id")
	private Employee oneEmployee;
	
	@OneToMany(mappedBy = "oneEmployee")
	private List<Employee> reportsTo;
	
	@NotEmpty(message = "Ingrese el cargo del empleado")
	@Column(name = "job_title")
	private String jobTitle;
	
	@OneToMany(mappedBy = "salesRepEmployeeNumber",cascade = CascadeType.ALL)
	private List<Customer> customer;
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Usuario usuario;
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
	 * @param jobTitle
	 */
	public Employee(Long employeeNumber, String lastName, String firstName, String extension, String email,
			String jobTitle) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.jobTitle = jobTitle;
	}

	/**
	 * Getters y Setters
	 */

	/**
	 * @return the employeeNumber
	 */
	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(Long employeeNumber) {
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
	public Office getOfficeCode() {
		return officeCode;
	}

	/**
	 * @param officeCode the officeCode to set
	 */
	public void setOfficeCode(Office officeCode) {
		this.officeCode = officeCode;
	}

	/**
	 * @return the oneEmployee
	 */
	public Employee getOneEmployee() {
		return oneEmployee;
	}

	/**
	 * @param oneEmployee the oneEmployee to set
	 */
	public void setOneEmployee(Employee oneEmployee) {
		this.oneEmployee = oneEmployee;
	}

	/**
	 * @return the reportsTo
	 */
	public List<Employee> getReportsTo() {
		return reportsTo;
	}

	/**
	 * @param reportsTo the reportsTo to set
	 */
	public void setReportsTo(List<Employee> reportsTo) {
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

	/**
	 * @return the customer
	 */
	public List<Customer> getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//Metodo toString
	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + "]";
	}
}
