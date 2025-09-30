package es.israeldelamo.demomariadb.controladores;

import es.israeldelamo.demomariadb.AdministradorPersonas;
import es.israeldelamo.demomariadb.dao.DaoDni;
import es.israeldelamo.demomariadb.modelos.ModeloPersona;
import es.israeldelamo.demomariadb.util.Alertas;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

/**
 * Una clase controladora de ejemplo para muestraPersonas.fxml
 */

public class ControladorMuestraPersonas {

    /**
     * El bundle de idiomas para este controlador
     */
    private static ResourceBundle bundle;

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

    /**
     * Procedimiento para rellenar la tabla
     */
    @FXML
    protected void onActualizarButton() {

        rellenarTabla();
    }

    /**
     * Se dispara cada vez que se carga la ventana
     */
    public void initialize() {
        cargarBundleIdiomas();
        //cuando la queremos async
        rellenarTablaAsync();
        // cuando la queremos sync
        //  rellenarTabla();
    }


    /**
     * Carga el bundle de idiomas para que aparezcan las traducciones
     * podriamos haberlo traido de la clase anterior?
     */
    private void cargarBundleIdiomas(){
        // Cargar el idioma seleccionado
        Preferences prefs = Preferences.userNodeForPackage(AdministradorPersonas.class);
        String idioma = prefs.get("textos", "es"); // Valor por defecto "es"
        Locale locale = new Locale(idioma);
        bundle = ResourceBundle.getBundle("textos", locale);
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
        //añado las entradas mediante un listado de dnis
        tvDni.getItems().addAll(DaoDni.cargarListadoDNI());
        //refresco la tabla
        tvDni.refresh();
    }


    /**
     * Rellena la tabla de Personas pero haciendo una llamda asincrona a la base de datos
     * a través del su DAO async
     */
    private void rellenarTablaAsync(){
        ObservableList<ModeloPersona> listadoDePersonas= FXCollections.observableArrayList();
        tcDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        //limpio la tabla de mierdas
        tvDni.getItems().clear();

        //añado las entradas mediante un listado de dnis
        DaoDni.cargarListadoDNIAsync().thenAccept(listado -> {
            // Utiliza el listado de personas aquí
            // Asegúrate de que el acceso a elementos de la UI se haga en el hilo de JavaFX
            //aquí reside la mágia de lo asíncrono
            Platform.runLater(() -> {
                listadoDePersonas.addAll(listado);
                tvDni.setItems(listadoDePersonas);
                tvDni.refresh();
            });
        });
    }


    /**
     * Muestra una ventanita de información sobre el autor
     */
    @FXML
    private void onAcercaDeClick() {
        Alertas alertaAcercaDe = new Alertas();
        alertaAcercaDe.mostrarInformacion("Version 1.0 de la demo");
    }


    /**
     * Muestra una alerta de confirmación antes de salir del programa
     */
    @FXML
    private void onArchivoCerrar(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(bundle.getString("AlertaSalir"));
        Optional<ButtonType> action = alert.showAndWait();
        if (action.isPresent() && action.get() == ButtonType.OK) {
            Platform.exit();
        }
    }


    /**
     * Muestra una alerta de confirmación antes de eliminar una linea seleccionada del tableview
     */
    @FXML
    private void onEdicionEliminar(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(bundle.getString("AlertaEliminar"));
        Optional<ButtonType> action = alert.showAndWait();
        if (action.isPresent() && action.get() == ButtonType.OK) {

            eliminarFIlasSeleccionadasDeBBDD();
            eliminarFilasSeleccionadasDeTV();

        }


    }

    /**
     * Elimina las filas seleccionadas del tableview
     */
    private void eliminarFilasSeleccionadasDeTV() {
        tvDni.getSelectionModel().getSelectedItems().forEach(tvDni.getItems()::remove);
    }

    /**
     * Elimina las filas seleccionadas del tableview
     */

    private void eliminarFIlasSeleccionadasDeBBDD() {
        tvDni.getSelectionModel().getSelectedItems().forEach(persona -> {
            DaoDni.eliminarPersonaAsync(persona).thenAccept(result -> {
                if (result) {
                    Alertas alerta = new Alertas();
                    alerta.mostrarInformacion(bundle.getString("AlertaEliminacionExitosa"));
                } else {
                    Alertas alerta = new Alertas();
                    alerta.mostrarInformacion(bundle.getString("AlertaEliminacionFallida"));
                }
            });
        });
    }


}