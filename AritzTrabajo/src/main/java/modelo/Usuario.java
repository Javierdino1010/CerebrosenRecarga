package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String DNI;
	private String nombre;
	private String apellidos;
	private String email;
	private String pass;
	private String telefono;
	private String rol;
	private boolean estaLogeado;
	private int numTotalReservados;
	
	

	
	public Usuario(String DNI, String nombre, String apellidos, String email, String pass, String telefono, String rol, boolean estaLogeado, int numTotalReservados) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.pass = pass;
		this.telefono = telefono;
		this.rol = rol;
		this.estaLogeado = estaLogeado;
        this.numTotalReservados = numTotalReservados;
	}


	public Usuario() {
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public boolean isLogin() {
		return estaLogeado;
	}


	public void setLogin(boolean login) {
		this.estaLogeado = login;
	}


	public int getNumTotalReservados() {
		return numTotalReservados;
	}


	public void setNumTotalReservados(int numTotalReservados) {
		this.numTotalReservados = numTotalReservados;
	}

	
}
