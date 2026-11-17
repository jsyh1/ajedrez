package co.edu.poli.model.piezas;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Pieza;
import co.edu.poli.model.Posicion;
import co.edu.poli.model.enums.Color;

public class Torre extends Pieza{

	public Torre(int id, int valor, String nombre, Color color, String rutaImagen) {
		super(id, valor, nombre, color, rutaImagen);
	}

    @Override
    public List<Posicion> obtenerMovimientosPosibles(
            Pieza[][] tablero, int fila, int columna) {

        List<Posicion> movimientos = new ArrayList<>();

        // Direcciones: arriba, abajo, izquierda y derecha.
        int[][] direcciones = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Recorrer las cuatro direcciones.
        for (int[] direccion : direcciones) {

            int nuevaFila = fila + direccion[0];
            int nuevaColumna = columna + direccion[1];

            // Continuar mientras no salga del tablero.
            while (nuevaFila >= 0 && nuevaFila < 8 &&
                   nuevaColumna >= 0 && nuevaColumna < 8) {

                Pieza piezaObjetivo =
                    tablero[nuevaFila][nuevaColumna];

                // Si la casilla está libre, puede moverse.
                if (piezaObjetivo == null) {

                    movimientos.add(
                        new Posicion(nuevaFila, nuevaColumna)
                    );

                } else {

                    // Si es una pieza contraria, puede capturarla.
                    if (piezaObjetivo.getColor() != getColor()) {

                        movimientos.add(
                            new Posicion(nuevaFila, nuevaColumna)
                        );
                    }

                    // No puede atravesar ninguna pieza.
                    break;
                }

                nuevaFila += direccion[0];
                nuevaColumna += direccion[1];
            }
        }

        return movimientos;
    }
}
