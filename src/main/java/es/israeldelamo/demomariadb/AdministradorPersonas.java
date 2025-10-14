package es.israeldelamo.demomariadb;

import es.israeldelamo.demomariadb.util.Alertas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;



/**
 * La clase principal que llama a las ventanas
 */
public class AdministradorPersonas extends Application {
    /**
     * Procedimiento inicial de las JavaFX
     * @param stage la ventana de trabajo
     * @throws IOException puede no encontrar el fxml
     */
    @Override
    public void start(Stage stage) throws IOException {

//
//        //prueba de conexión a la bbdd
//        try {
//            // creo la conexión a ver si tira
//            ConexionBBDD conexioPrueba= new ConexionBBDD();
//            //creo una persona de prueba
//            // ModeloPersona personaPrueba = new ModeloPersona("69696969-Z");
//            // hago una llamada al DAO
//            // DaoDni.nuevoDNI(personaPrueba);
//
//
//        } catch (SQLException e) {
//
//            throw new RuntimeException(e);
//        }

        // Cargar el idioma seleccionado
        Preferences prefs = Preferences.userNodeForPackage(AdministradorPersonas.class);
        String idioma = prefs.get("textos", "es"); // Valor por defecto "es"
        Locale locale = new Locale(idioma);
        ResourceBundle bundle = ResourceBundle.getBundle("textos", locale);



        //al cargar el fxml le pasamos también en bundle
        FXMLLoader fxmlLoader = new FXMLLoader(AdministradorPersonas.class.getResource("fxml/muestraPersonas.fxml"),bundle);
        Scene scene = new Scene(fxmlLoader.load());

        //ruta de la foto a poner en el logo de la ventanas stage.getIcons().add(imagen);
        Image icono = new Image(Objects.requireNonNull(getClass().getResourceAsStream("imagenes/icono.png")));
        stage.getIcons().add(icono);

        //prevengo el aplastamiento
        stage.setMinHeight(480);
        stage.setMinWidth(640);

        stage.setTitle("Lista los datos de Maria");
        stage.setScene(scene);
        stage.show();

        //un mensajito de bienvenida
        Alertas alertaInformacion = new Alertas();
        // esta linea seria monolingüe, la paso a bundle get key para que sea multi
        //alertaInformacion.mostrarInformacion("Bienvenido a la gestión de DNIs");
        alertaInformacion.mostrarInformacion(bundle.getString("TextoBienvenida"));
    }

}