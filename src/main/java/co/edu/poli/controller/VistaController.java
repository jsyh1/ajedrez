
package co.edu.poli.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Jugador;
import co.edu.poli.model.Partida;
import co.edu.poli.model.Pieza;
import co.edu.poli.model.Posicion;
import co.edu.poli.model.enums.Color;
import co.edu.poli.service.Cronometro;
import co.edu.poli.service.NuevaPartida;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Controlador principal de la interfaz del ajedrez.
 *
 * @author Jsyh
 */
public class VistaController {

	@FXML
	private GridPane tablero;

	@FXML
	private Label lblTurno;

	@FXML
	private Label lblCronometro;

	@FXML
	private Label lblEstado;

	private Partida partida;

	// Pieza que el usuario seleccionó.
	private Pieza piezaSeleccionada;

	// Posición actual de la pieza seleccionada.
	private Posicion posicionSeleccionada;

	// Casillas disponibles para mover la pieza.
	private List<Posicion> movimientosDisponibles = new ArrayList<>();

	// Turno actual.
	private Color turnoActual = Color.BLANCO;

	/**
	 * Inicializa la partida y el tablero.
	 */
	@FXML
	public void initialize() {

		Jugador jugadorA = new Jugador(0, 0, null, null, null, null);
		Jugador jugadorB = new Jugador(0, 0, null, null, null, null);

		NuevaPartida nuevaPartida = new NuevaPartida();

		Cronometro cronometro = new Cronometro(5);

		partida = new Partida(1, 0, LocalDate.now(), jugadorA, jugadorB, cronometro, nuevaPartida);

		ubicarPiezas();

		lblCronometro.setText(cronometro.obtenerTiempo());
		lblTurno.setText("Turno: Blancas");
		lblEstado.setText("Partida iniciada");
	}

	/**
	 * Dibuja el tablero y sus piezas.
	 */
	private void ubicarPiezas() {

		Pieza[][] tableroModelo = partida.getNuevaPartida().getTableroModelo();

		for (int fila = 0; fila < 8; fila++) {

			for (int columna = 0; columna < 8; columna++) {

				final int f = fila;
				final int c = columna;

				Pieza pieza = tableroModelo[fila][columna];

				StackPane casilla = new StackPane();
				casilla.setPrefSize(65, 65);

				boolean clara = (fila + columna) % 2 == 0;

				casilla.setStyle(clara ? "-fx-background-color: #FFFFFF;" : "-fx-background-color: #769656;");

				if (pieza != null) {

					Label simbolo = new Label(pieza.getRutaImagen());
					simbolo.setStyle("-fx-font-size: 40px;");

					casilla.getChildren().add(simbolo);
				}

				// Detectar clic sobre la casilla.
				casilla.setOnMouseClicked(event -> seleccionarCasilla(f, c));

				tablero.add(casilla, columna, fila);
			}
		}

		actualizarResaltado();
	}

	/**
	 * Procesa la selección de una casilla.
	 */
	private void seleccionarCasilla(int fila, int columna) {

		Pieza[][] tableroModelo = partida.getNuevaPartida().getTableroModelo();

		Pieza pieza = tableroModelo[fila][columna];

		// Si no hay ninguna pieza seleccionada.
		if (piezaSeleccionada == null) {

			if (pieza != null && pieza.getColor() == turnoActual) {

				piezaSeleccionada = pieza;
				posicionSeleccionada = new Posicion(fila, columna);

				movimientosDisponibles = pieza.obtenerMovimientosPosibles(tableroModelo, fila, columna);

				actualizarResaltado();
				lblEstado.setText("Pieza seleccionada: " + pieza.getNombre());
			}

			return;
		}

		// Si se selecciona otra pieza del mismo color.
		if (pieza != null && pieza.getColor() == turnoActual) {

			piezaSeleccionada = pieza;
			posicionSeleccionada = new Posicion(fila, columna);

			movimientosDisponibles = pieza.obtenerMovimientosPosibles(tableroModelo, fila, columna);

			actualizarResaltado();
			lblEstado.setText("Pieza seleccionada: " + pieza.getNombre());

			return;
		}

		// Comprobar si la casilla seleccionada es un destino válido.
		if (esMovimientoDisponible(fila, columna)) {

			moverPieza(fila, columna);

		} else {
			limpiarSeleccion();
		}
	}

	/**
	 * Comprueba si una posición está entre los movimientos disponibles.
	 */
	private boolean esMovimientoDisponible(int fila, int columna) {

		for (Posicion posicion : movimientosDisponibles) {

			if (posicion.getFila() == fila && posicion.getColumna() == columna) {

				return true;
			}
		}

		return false;
	}

	/**
	 * Ejecuta el movimiento de la pieza seleccionada.
	 */
	private void moverPieza(int fila, int columna) {

		Pieza[][] tableroModelo = partida.getNuevaPartida().getTableroModelo();

		// Detectar si había una pieza en el destino.
		Pieza piezaComida = tableroModelo[fila][columna];

		// Mover la pieza.
		tableroModelo[fila][columna] = piezaSeleccionada;

		tableroModelo[posicionSeleccionada.getFila()][posicionSeleccionada.getColumna()] = null;

		piezaSeleccionada.setSeHaMovido(true);

		if (piezaComida != null) {
			lblEstado.setText("Pieza capturada: " + piezaComida.getNombre());
		} else {
			lblEstado.setText("Movimiento realizado");
		}

		// Cambiar el turno.
		turnoActual = turnoActual == Color.BLANCO ? Color.NEGRO : Color.BLANCO;

		lblTurno.setText(turnoActual == Color.BLANCO ? "Turno: Blancas" : "Turno: Negras");

		limpiarSeleccion();

		// Dibujar nuevamente el tablero.
		tablero.getChildren().clear();
		ubicarPiezas();
	}

	/**
	 * Limpia la selección actual.
	 */
	private void limpiarSeleccion() {

		piezaSeleccionada = null;
		posicionSeleccionada = null;
		movimientosDisponibles.clear();

		actualizarResaltado();
	}

	/**
	 * Resalta la pieza seleccionada y sus destinos.
	 */
	private void actualizarResaltado() {

		for (javafx.scene.Node nodo : tablero.getChildren()) {

			Integer fila = GridPane.getRowIndex(nodo);
			Integer columna = GridPane.getColumnIndex(nodo);

			int f = fila == null ? 0 : fila;
			int c = columna == null ? 0 : columna;

			boolean clara = (f + c) % 2 == 0;

			String colorCasilla = clara ? "#FFFFFF" : "#769656";

			if (posicionSeleccionada != null && posicionSeleccionada.getFila() == f
					&& posicionSeleccionada.getColumna() == c) {

				colorCasilla = "#F7DC6F";
			}

			if (esMovimientoDisponible(f, c)) {

				colorCasilla = "#82E0AA";
			}

			((StackPane) nodo).setStyle("-fx-background-color: " + colorCasilla + ";");
		}
	}

	/**
	 * Inicia una nueva partida conservando los jugadores.
	 */
	@FXML
	private void nuevaPartida() {

		tablero.getChildren().clear();

		NuevaPartida nuevaPartida = new NuevaPartida();

		partida = new Partida(1, 0, LocalDate.now(), partida.getJugadorA(), partida.getJugadorB(), new Cronometro(5),
				nuevaPartida);

		turnoActual = Color.BLANCO;

		limpiarSeleccion();
		ubicarPiezas();

		lblTurno.setText("Turno: Blancas");
		lblEstado.setText("Nueva partida");
	}
}
