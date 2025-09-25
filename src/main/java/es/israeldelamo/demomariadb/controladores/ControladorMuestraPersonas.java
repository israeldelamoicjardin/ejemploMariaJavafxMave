package es.israeldelamo.demomariadb.controladores;

import es.israeldelamo.demomariadb.dao.DaoDni;
import es.israeldelamo.demomariadb.modelos.ModeloPersona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Una clase controladora de ejemplo
 */

public class ControladorMuestraPersonas {
    /**
     * La persona que va a ser referenciada para crear la tabla
     */
    private ModeloPersona personaModelo;

    @FXML
    private Label welcomeText;

    /**
     * TAbla de personas
     */
    @FXML
    private TableView<ModeloPersona> tvDni;

    /**
     * Columna de dni de la tabla de personas
     */
    @FXML
    private TableColumn<ModeloPersona, String> tcDni;

    /**
     * Columna de nombre de la tabla de personas
     */
    @FXML
    private TableColumn<ModeloPersona, String> tcNombre;

    /**
     * Columna de apellido de la tabla de personas
     */
    @FXML
    private TableColumn<ModeloPersona, String> tcApellidos;


    @FXML
    /**
     * Boton para rellenar la tabla
     */
    protected void onHelloButtonClick() {
       // welcomeText.setText("Welcome to JavaFX Application!");
        rellenarTabla();

    }

    /**
     * Se dispara cada vez que se carga la ventana
     */
    public void initialize() {

        rellenarTabla();
    }


    /**
     * Rellena la tabla de personas pero usando una llamada sincrona a la base de datos
     * mediante su dao sin la palabra async
     */
    private void rellenarTabla(){
        //   DaoDni daoDNI = new DaoDNI(); como es estático, lo creo y destruyo en la misma llamada
        //formateo la columna
        tcDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        //limpio la tabla de mierdas
        tvDni.getItems().clear();
        //añado las entradas mediante un listao de dnis
        tvDni.getItems().addAll(DaoDni.cargarListadoDNI());
        //refresco la tabla
        tvDni.refresh();
    }


    /**
     * Rellena la tabla  de Personas pero haciendo una llamda asincrona a la base de datos
     * a através del su DAO async
     */
    private void rellenarTablaAsync(){
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
    }
}