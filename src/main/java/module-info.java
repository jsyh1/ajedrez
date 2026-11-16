module co.edu.poli.vista {

	// JavaFX
	requires javafx.controls;
	requires javafx.fxml;

	// Acceso de JavaFX a los controladores
	opens co.edu.poli.controller to javafx.fxml;

	// Acceso al paquete principal
	exports co.edu.poli.vista;
}
