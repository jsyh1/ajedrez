
package co.edu.poli.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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
    private Label lblEstado;

    /**
     * Inicializa el tablero y los componentes visuales.
     */
    @FXML
    public void initialize() {

        crearTablero();

        lblTurno.setText("Turno: Blancas");
        lblEstado.setText("Partida iniciada");
    }

    /**
     * Construye las 64 casillas del tablero.
     */
    private void crearTablero() {

        for (int fila = 0; fila < 8; fila++) {

            for (int columna = 0; columna < 8; columna++) {

                Button casilla = new Button();

                casilla.setPrefSize(65, 65);

                boolean clara = (fila + columna) % 2 == 0;

                casilla.setStyle(
                    clara
                    ? "-fx-background-color: #F0D9B5;"
                    : "-fx-background-color: #B58863;"
                );

                tablero.add(casilla, columna, fila);
            }
        }
    }

    /**
     * Reinicia la partida.
     */
    @FXML
    private void nuevaPartida() {

        tablero.getChildren().clear();

        crearTablero();

        lblTurno.setText("Turno: Blancas");
        lblEstado.setText("Nueva partida");
    }
}
