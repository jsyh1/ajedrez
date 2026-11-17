package co.edu.poli.service;

import co.edu.poli.model.Pieza;
import co.edu.poli.model.enums.Color;
import co.edu.poli.model.piezas.Alfil;
import co.edu.poli.model.piezas.Caballo;
import co.edu.poli.model.piezas.Peon;
import co.edu.poli.model.piezas.Reina;
import co.edu.poli.model.piezas.Rey;
import co.edu.poli.model.piezas.Torre;

public class NuevaPartida {

    private Pieza[][] tableroModelo;

    public NuevaPartida() {
        tableroModelo = new Pieza[8][8];
        inicializarTablero();
    }

    public Pieza[][] getTableroModelo() {
        return tableroModelo;
    }

    private void inicializarTablero() {

		// =========================
		// PIEZAS NEGRAS (ARRIBA)
		// =========================

		tableroModelo[0][0] = new Torre(1, 5, "Torre", Color.NEGRO, "♜");
		tableroModelo[0][1] = new Caballo(2, 3, "Caballo", Color.NEGRO, "♞");
		tableroModelo[0][2] = new Alfil(3, 3, "Alfil", Color.NEGRO, "♝");
		tableroModelo[0][3] = new Reina(4, 9, "Reina", Color.NEGRO, "♛");
		tableroModelo[0][4] = new Rey(5, 200, "Rey", Color.NEGRO, "♚");
		tableroModelo[0][5] = new Alfil(6, 3, "Alfil", Color.NEGRO, "♝");
		tableroModelo[0][6] = new Caballo(7, 3, "Caballo", Color.NEGRO, "♞");
		tableroModelo[0][7] = new Torre(8, 5, "Torre", Color.NEGRO, "♜");

		// =========================
		// PIEZAS BLANCAS (ABAJO)
		// =========================

		tableroModelo[7][0] = new Torre(25, 5, "Torre", Color.BLANCO, "♖");
		tableroModelo[7][1] = new Caballo(26, 3, "Caballo", Color.BLANCO, "♘");
		tableroModelo[7][2] = new Alfil(27, 3, "Alfil", Color.BLANCO, "♗");
		tableroModelo[7][3] = new Reina(28, 9, "Reina", Color.BLANCO, "♕");
		tableroModelo[7][4] = new Rey(29, 200, "Rey", Color.BLANCO, "♔");
		tableroModelo[7][5] = new Alfil(30, 3, "Alfil", Color.BLANCO, "♗");
		tableroModelo[7][6] = new Caballo(31, 3, "Caballo", Color.BLANCO, "♘");
		tableroModelo[7][7] = new Torre(32, 5, "Torre", Color.BLANCO, "♖");

		// =========================
		// PEONES NEGROS
		// =========================

		// Fila 1
		for (int columna = 0; columna < 8; columna++) {
			tableroModelo[1][columna] = new Peon(columna + 9, 1, "Peón", Color.NEGRO, "♟");
		}

		// =========================
		// PEONES BLANCOS
		// =========================

		// Fila 6
		for (int columna = 0; columna < 8; columna++) {
			tableroModelo[6][columna] = new Peon(columna + 17, 1, "Peón", Color.BLANCO, "♙");
		}

	}

}
