
package co.edu.poli.model.piezas;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Pieza;
import co.edu.poli.model.Posicion;
import co.edu.poli.model.enums.Color;

/**
 * Representa el rey de ajedrez.
 *
 * @author Jsyh
 */
public class Rey extends Pieza {

    private boolean capturable = false;

    public Rey(int id, int valor, String nombre,
            Color color, String rutaImagen) {
        super(id, valor, nombre, color, rutaImagen);
    }

    /**
     * Obtiene los movimientos posibles del rey.
     *
     * El rey puede desplazarse una casilla en cualquier dirección,
     * siempre que no esté ocupada por una pieza de su color.
     *
     * @param tablero matriz que representa el tablero.
     * @param fila posición actual de la fila.
     * @param columna posición actual de la columna.
     * @return lista de posiciones posibles.
     */
    @Override
    public List<Posicion> obtenerMovimientosPosibles(
            Pieza[][] tablero, int fila, int columna) {

        List<Posicion> movimientos = new ArrayList<>();

        // Las ocho direcciones posibles del rey.
        int[][] direcciones = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };

        for (int[] direccion : direcciones) {

            int nuevaFila = fila + direccion[0];
            int nuevaColumna = columna + direccion[1];

            // Verificar que la posición esté dentro del tablero.
            if (nuevaFila >= 0 && nuevaFila < 8
                    && nuevaColumna >= 0 && nuevaColumna < 8) {

                Pieza piezaObjetivo = tablero[nuevaFila][nuevaColumna];

                // Puede moverse a una casilla vacía o capturar un enemigo.
                if (piezaObjetivo == null
                        || piezaObjetivo.getColor() != getColor()) {

                    movimientos.add(
                        new Posicion(nuevaFila, nuevaColumna)
                    );
                }
            }
        }

        return movimientos;
    }

    public boolean getCapturable() {
        return capturable;
    }

    public void setCapturable(boolean capturable) {
        this.capturable = capturable;
    }
}
