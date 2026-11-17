package co.edu.poli.model.piezas;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Pieza;
import co.edu.poli.model.Posicion;
import co.edu.poli.model.enums.Color;

public class Peon extends Pieza {

    public Peon(int id, int valor, String nombre, Color color, String rutaImagen) {
        super(id, valor, nombre, color, rutaImagen);
    }

    @Override
    public List<Posicion> obtenerMovimientosPosibles(
            Pieza[][] tablero, int fila, int columna) {

        List<Posicion> movimientos = new ArrayList<>();

        int direccion = getColor() == Color.BLANCO ? -1 : 1;

        int nuevaFila = fila + direccion;

        // Comprobar que no salga del tablero.
        if (nuevaFila < 0 || nuevaFila >= 8) {
            return movimientos;
        }

        // Avanzar una casilla si está libre.
        if (tablero[nuevaFila][columna] == null) {

            movimientos.add(new Posicion(nuevaFila, columna));

            // Avanzar dos casillas si todavía no se ha movido.
            int filaInicial = getColor() == Color.BLANCO ? 6 : 1;

            if (!isSeHaMovido() && fila == filaInicial) {

                int dosCasillas = fila + (direccion * 2);

                if (tablero[dosCasillas][columna] == null) {
                    movimientos.add(new Posicion(dosCasillas, columna));
                }
            }
        }

        // Comprobar capturas diagonales.
        for (int desplazamiento : new int[]{-1, 1}) {

            int nuevaColumna = columna + desplazamiento;

            if (nuevaColumna >= 0 && nuevaColumna < 8) {

                Pieza objetivo = tablero[nuevaFila][nuevaColumna];

                if (objetivo != null &&
                    objetivo.getColor() != getColor()) {

                    movimientos.add(
                        new Posicion(nuevaFila, nuevaColumna)
                    );
                }
            }
        }

        return movimientos;
    }
}
