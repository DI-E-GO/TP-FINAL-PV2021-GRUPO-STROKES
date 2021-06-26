/**
 * 
 */
package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author Diego
 *
 */
@Entity
@Table(name = "ACCOUNTS")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Ingrese un usuario")
	@NotBlank(message = "No se permiten espacios en blanco para el nombre de usuario")
	private String username;
	@NotEmpty(message = "Ingrese una contraseña")
	private String password;
	@JoinColumn(name = "employee_id")
    @OneToOne(fetch = FetchType.LAZY)	
	private Employee employee;
	private String rol;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 */
	public Usuario(Long id, String username, String password, Employee employee, String rol) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.employee = employee;
		this.rol = rol;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the employee
	 */

	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", employee=" + employee
				+ "]";
	}

}
