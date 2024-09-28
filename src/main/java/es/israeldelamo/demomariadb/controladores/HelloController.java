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

public class HelloController {
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

    @FXML
    /**
     * Boton para cambiar el texto de hola mundo
     */
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        //   DaoDni daoDNI = new DaoDNI(); como es estático, lo creo y destruyo en la misma llamada
        //formateo la columna
        tcDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        //limpio la tabla de mierdas
        tvDni.getItems().clear();
        //añado las entradas mediante un listao de dnis
        tvDni.getItems().addAll(DaoDni.cargarListadoDNI());
        //refresco la tabla
        tvDni.refresh();
    }
}