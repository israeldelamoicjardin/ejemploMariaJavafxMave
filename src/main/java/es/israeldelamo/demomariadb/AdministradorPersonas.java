package es.israeldelamo.demomariadb;

import es.israeldelamo.demomariadb.util.Alertas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * La clase principal que llama a las ventanas
 */
public class AdministradorPersonas extends Application {
    /**
     * Método inicial de las JavaFX
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

//
//        //prueba de conexion a la bbdd
//        try {
//            // creo la conexion a ver si tira
//            ConexionBBDD conexioPrueba= new ConexionBBDD();
//            //creo una persona de prueba
//            // ModeloPersona personaPrueba = new ModeloPersona("69696969-Z");
//            // hago una llamada al DAO
//            // DaoDni.nuevoDNI(personaPrueba);
//
//
//        } catch (SQLException e) {
//            //todo hay que tratar esta excepción
//            throw new RuntimeException(e);
//        }

        FXMLLoader fxmlLoader = new FXMLLoader(AdministradorPersonas.class.getResource("fxml/muestraPersonas.fxml"));
        Scene scene = new Scene(fxmlLoader.load());


        Image icono = new Image(Objects.requireNonNull(getClass().getResourceAsStream("imagenes/icono.png")));
        //ruta de la foto a poner en el logo de la ventanas stage.getIcons().add(imagen);
        stage.getIcons().add(icono);

        //prevengo el aplastamiento
        stage.setMinHeight(480);
        stage.setMinWidth(640);

        stage.setTitle("Lista los datos de Maria");
        stage.setScene(scene);
        stage.show();
        Alertas alertaInformacion = new Alertas();
        alertaInformacion.mostrarInformacion("He cargado la ventana con éxito");
    }

}