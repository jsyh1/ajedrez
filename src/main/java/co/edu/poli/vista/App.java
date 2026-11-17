
package co.edu.poli.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal que inicia la aplicación de ajedrez.
 *
 * @author Jsyh
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("Ajedrez"));
        stage.setMaximized(true);

        stage.setTitle("Ajedrez");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {

        var resource = App.class.getResource(fxml + ".fxml");

        if (resource == null) {
            throw new IOException("No se encontró el archivo FXML: " + fxml);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
