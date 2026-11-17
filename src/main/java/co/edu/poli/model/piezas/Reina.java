package co.edu.poli.model.piezas;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Pieza;
import co.edu.poli.model.Posicion;
import co.edu.poli.model.enums.Color;

public class Reina extends Pieza{

	public Reina(int id, int valor, String nombre, Color color, String rutaImagen) {
		super(id, valor, nombre, color, rutaImagen);
	}

	@Override
    public List<Posicion> obtenerMovimientosPosibles(
            Pieza[][] tablero, int fila, int columna) {

        List<Posicion> movimientos = new ArrayList<>();

        // Ocho direcciones: verticales, horizontales y diagonales.
        int[][] direcciones = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
        };

        for (int[] direccion : direcciones) {

            int nuevaFila = fila + direccion[0];
            int nuevaColumna = columna + direccion[1];

            while (nuevaFila >= 0 && nuevaFila < 8
                    && nuevaColumna >= 0 && nuevaColumna < 8) {

                Pieza piezaObjetivo = tablero[nuevaFila][nuevaColumna];

                if (piezaObjetivo == null) {

                    // La casilla está libre.
                    movimientos.add(
                        new Posicion(nuevaFila, nuevaColumna)
                    );

                } else {

                    // Puede capturar una pieza enemiga.
                    if (piezaObjetivo.getColor() != getColor()) {
                        movimientos.add(
                            new Posicion(nuevaFila, nuevaColumna)
                        );
                    }

                    // No puede atravesar otras piezas.
                    break;
                }

                nuevaFila += direccion[0];
                nuevaColumna += direccion[1];
            }
        }

        return movimientos;
    }

}
