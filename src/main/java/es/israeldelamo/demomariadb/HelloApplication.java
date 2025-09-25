package es.israeldelamo.demomariadb;

import es.israeldelamo.demomariadb.bbdd.ConexionBBDD;
import es.israeldelamo.demomariadb.dao.DaoDni;
import es.israeldelamo.demomariadb.modelos.ModeloPersona;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

//
//
//        ObservableList<ModeloPersona> listadoDePersonas= FXCollections.observableArrayList();
//
//        ModeloPersona personaPrueba = new ModeloPersona("6969");
//        //parte de la pruebas con Asyncrono
//        DaoDni.cargarListadoDNIAsync().thenAccept(listado -> {
//            // Utiliza el listado de personas aquí
//            System.out.println(listadoDePersonas);
//        });
//        //y modifica
//        DaoDni.modificarPaisAsync(personaPrueba, "NuevoDni").thenAccept(exito -> {
//            // Maneja el éxito o fracaso
//            if (exito) {
//                System.out.println("Modificación exitosa");
//            } else {
//                System.out.println("Error al modificar");
//            }
//        });






        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/hello-view.fxml"));
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


        launch();


    }
}