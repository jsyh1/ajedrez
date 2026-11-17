package co.edu.poli.model;

/**
 * Representa una posición dentro del tablero.
 *
 * @author Jsyh
 */
public class Posicion {

    private int fila;
    private int columna;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}