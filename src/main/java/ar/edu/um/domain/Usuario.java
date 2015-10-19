package ar.edu.um.domain;

import org.hibernate.validator.constraints.Email;

public class Usuario {

	private Integer id;
	private Rol rol;
	@Email
	private String email;
	private String nombre;
	private String contraseña;

}
