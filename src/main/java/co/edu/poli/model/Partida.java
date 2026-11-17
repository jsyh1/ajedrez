package co.edu.poli.model;

import java.time.LocalDate;

import co.edu.poli.service.Cronometro;
import co.edu.poli.service.NuevaPartida;

public class Partida extends NuevaPartida {

	private int id;
	private int puntaje;
	private LocalDate fecha;
	private Jugador jugadorA;
	private Jugador jugadorB;

	private Cronometro cronometro;
	private NuevaPartida nuevaPartida;

	public Partida(int id, int puntaje, LocalDate fecha, Jugador jugadorA, Jugador jugadorB, Cronometro cronometro,
			NuevaPartida nuevaPartida) throws IllegalArgumentException {

		if (jugadorA == null || jugadorB == null) {
			throw new IllegalArgumentException("Se necesitan dos jugadores para iniciar una partida.");
		}

		if (jugadorA.equals(jugadorB)) {
			throw new IllegalArgumentException("Los jugadores deben ser diferentes.");
		}

		this.id = id;
		this.puntaje = puntaje;
		this.fecha = fecha;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		this.cronometro = cronometro;
		this.nuevaPartida = nuevaPartida;
	}

	public NuevaPartida getNuevaPartida() {
		return nuevaPartida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Jugador getJugadorA() {
		return jugadorA;
	}

	public void setJugadorA(Jugador jugadorA) {
		this.jugadorA = jugadorA;
	}

	public Jugador getJugadorB() {
		return jugadorB;
	}

	public void setJugadorB(Jugador jugadorB) {
		this.jugadorB = jugadorB;
	}

	public Cronometro getCronometro() {
		return cronometro;
	}

	public void setCronometro(Cronometro cronometro) {
		this.cronometro = cronometro;
	}
}