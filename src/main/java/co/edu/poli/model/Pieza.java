
package co.edu.poli.model;

import java.util.List;

import co.edu.poli.model.enums.Color;

/**
 * Clase abstracta que representa una pieza de ajedrez.
 *
 * @author Jsyh
 */
public abstract class Pieza {

	int id;
	int valor; // Costo de cada pieza.
	String nombre;
	Color color;
	String rutaImagen;

	private boolean seHaMovido;

	public Pieza(int id, int valor, String nombre, Color color, String rutaImagen) {

		this.id = id;
		this.valor = valor;
		this.nombre = nombre;
		this.color = color;
		this.rutaImagen = rutaImagen;
		this.seHaMovido = false;
	}

	/**
	 * Obtiene los movimientos posibles de la pieza.
	 *
	 * @param tablero matriz que representa el tablero.
	 * @param fila    posición actual de la fila.
	 * @param columna posición actual de la columna.
	 * @return lista de posiciones posibles.
	 */
	public abstract List<Posicion> obtenerMovimientosPosibles(Pieza[][] tablero, int fila, int columna);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public boolean isSeHaMovido() {
		return seHaMovido;
	}

	public void setSeHaMovido(boolean seHaMovido) {
		this.seHaMovido = seHaMovido;
	}
}
