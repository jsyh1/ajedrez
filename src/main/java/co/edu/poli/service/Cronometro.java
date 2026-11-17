package co.edu.poli.service;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Cronometro {

	private int segundos;
	private Timeline timeline;

	public Cronometro(int minutos) {
		this.segundos = minutos * 60;
	}

	public void iniciar() {

		timeline = new Timeline(new KeyFrame(Duration.seconds(1), evento -> {
			segundos--;
			System.out.println(obtenerTiempo());
		}));

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	public void detener() {
		if (timeline != null) {
			timeline.stop();
		}
	}

	public void reiniciar(int minutos) {
		detener();
		segundos = minutos * 60;
	}

	public String obtenerTiempo() {

		int minutos = segundos / 60;
		int segundosRestantes = segundos % 60;

		return String.format("%02d:%02d", minutos, segundosRestantes);
	}
}