package modelo;

public class Contacto {

	private int id;
	private String nombre;
	private String apellido;
	private int telefono;
	private char sexo;

	public Contacto(String nombre, String apellido) {
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public Contacto(String nombre, String apellido, int telefono, char sexo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
