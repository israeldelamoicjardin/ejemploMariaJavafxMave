package es.israeldelamo.demomariadb;

import es.israeldelamo.demomariadb.bbdd.ConexionBBDD;
import es.israeldelamo.demomariadb.dao.DaoDni;
import es.israeldelamo.demomariadb.modelos.ModeloPersona;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * La clase principal que llama a las ventanas
 */
public class HelloApplication extends Application {
    /**
     * Método inicial de las JavaFX
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * La clase principal para lanzar la app
     * @param args sin argumentos
     */
    public static void main(String[] args)  {
        //prueba de conexion a la bbdd
        try {
            // creo la conexion a ver si tira
            ConexionBBDD conexioPrueba= new ConexionBBDD();
            //creo una persona de prueba
           // ModeloPersona personaPrueba = new ModeloPersona("69696969-Z");
            // hago una llamada al DAO
           // DaoDni.nuevoDNI(personaPrueba);


        } catch (SQLException e) {
            //todo hay que tratar esta excepción
            throw new RuntimeException(e);
        }


        launch();


    }
}