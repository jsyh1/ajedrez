package co.edu.poli.model.piezas;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Pieza;
import co.edu.poli.model.Posicion;
import co.edu.poli.model.enums.Color;

public class Caballo extends Pieza{

	public Caballo(int id, int valor, String nombre, Color color, String rutaImagen) {
		super(id, valor, nombre, color, rutaImagen);
	}

	 @Override
	    public List<Posicion> obtenerMovimientosPosibles(
	            Pieza[][] tablero, int fila, int columna) {

	        List<Posicion> movimientos = new ArrayList<>();

	        // Los ocho posibles movimientos en forma de L.
	        int[][] desplazamientos = {
	            {-2, -1},
	            {-2, 1},
	            {-1, -2},
	            {-1, 2},
	            {1, -2},
	            {1, 2},
	            {2, -1},
	            {2, 1}
	        };

	        for (int[] desplazamiento : desplazamientos) {

	            int nuevaFila = fila + desplazamiento[0];
	            int nuevaColumna = columna + desplazamiento[1];

	            // Verificar que la posición esté dentro del tablero.
	            if (nuevaFila >= 0 && nuevaFila < 8
	                    && nuevaColumna >= 0 && nuevaColumna < 8) {

	                Pieza piezaObjetivo = tablero[nuevaFila][nuevaColumna];

	                // Puede moverse a casillas vacías o capturar enemigos.
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

}
