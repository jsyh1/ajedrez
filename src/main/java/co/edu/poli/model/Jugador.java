package co.edu.poli.model;

public class Jugador {

	int id;
	int elo;
	String idGenerado;// se genera un ide para cada jugador para distingir de el ide de base de datos
	String nombre;
	String correo;
	String pass;

	public Jugador(int id, int elo, String idGenerado, String nombre, String correo, String pass) {
		this.id = id;
		this.elo = elo;
		this.idGenerado = idGenerado;
		this.nombre = nombre;
		this.correo = correo;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	public String getIdGenerado() {
		return idGenerado;
	}

	public void setIdGenerado(String idGenerado) {
		this.idGenerado = idGenerado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
