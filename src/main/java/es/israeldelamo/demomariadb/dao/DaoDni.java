package es.israeldelamo.demomariadb.dao;

import es.israeldelamo.demomariadb.bbdd.ConexionBBDD;
import es.israeldelamo.demomariadb.modelos.ModeloPersona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoDni {



        /**
         * Metodo que carga los datos de la tabla DNI y los devuelve para usarlos en un listado de personas
         *
         * @return listado de paises para cargar en un tableview
         */
        public static ObservableList<ModeloPersona> cargarListadoDNI() {
            ConexionBBDD conexion;
            ObservableList<ModeloPersona> listadoDePersonas= FXCollections.observableArrayList();

            try{
                conexion = new ConexionBBDD();

                String consulta = "SELECT dni FROM DNI";
                PreparedStatement pstmt = conexion.getConexion().prepareStatement(consulta);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String dni = rs.getString("dni");
                    ModeloPersona mp = new ModeloPersona(dni);
                    listadoDePersonas.add(mp);

                }
                rs.close();
                conexion.CloseConexion();
            }catch (
                    SQLException e) {
                // O lo trato aquí arriesgandome a qu fxml no este
                /*
                Alertas alertaError = new Alertas();
                alertaError.mostrarError("No he podido cargar el listado de paises");
                alertaError.mostrarError(e.getMessage());
                */
                // o lo trato aquí mostrandolo por consola
                System.out.println(e.getMessage());
            }
            return listadoDePersonas;
        }






        /**
         * Metodo que modifica los datos de un dni  en la BD
         *
         * @param dni		Instancia de la persona con datos nuevos
         * @param nuevoDni Nuevo dni de la persona a modificar
         * @return			true/false
         */
        public static  boolean modificarPais(ModeloPersona dni, String nuevoDni) {
            ConexionBBDD conexion;
            PreparedStatement pstmt;

            try {
                conexion = new ConexionBBDD();
                // UPDATE `DNI`.`PAISES` SET `pais` = 'BulgariaK' WHERE (`pais` = 'Bulgaria');

                String consulta = "UPDATE DNI SET dni = ? WHERE dni = ?";
                pstmt = conexion.getConexion().prepareStatement(consulta);

                pstmt.setString(1, nuevoDni);
                pstmt.setString(2, dni.getDni());

                int filasAfectadas = pstmt.executeUpdate();

                System.out.println("Actualizada dnis");
                //if (pstmt != null)
                pstmt.close();
                //if (conexion != null)
                conexion.CloseConexion();
                return filasAfectadas > 0;
            } catch (SQLException e) {
               /* Alertas alertaError = new Alertas();
                alertaError.mostrarError("No he podido cargar el listado de paises");
                alertaError.mostrarError(e.getMessage());*/
                System.out.println(e.getMessage());
                return false;

            }

        }



        /**
         * Metodo que CREA un nuevo un dni en la BD
         *
         * @param persona		Instancia del modelo persona con datos nuevos
         * @return			true/false
         */
        public  static boolean nuevoDNI(ModeloPersona persona) {
            ConexionBBDD conexion;
            PreparedStatement pstmt;

            try {
                conexion = new ConexionBBDD();
                // INSERT INTO `DNI`.`dni` (`dni`) VALUES ('el nuevo');

                String consulta = "INSERT INTO DNI (dni) VALUES (?) ";
                pstmt = conexion.getConexion().prepareStatement(consulta);

                pstmt.setString(1, persona.getDni());

                int filasAfectadas = pstmt.executeUpdate();
                //if (pstmt != null)
                pstmt.close();
                //if (conexion != null)
                conexion.CloseConexion();
                System.out.println("Nueva entrada en  dni");
                return filasAfectadas > 0;
            } catch (SQLException e) {
               /* Alertas alertaError = new Alertas();
                alertaError.mostrarError("No he podido cargar el listado de dnis");
                alertaError.mostrarError(e.getMessage());*/
                System.out.println(e.getMessage());
                return false;

            }

        }

        /**
         * Elimina una persona en función del modelo Persona que le hayamos pasado
         *
         * @param personaAEliminar Persona a eliminar
         * @return a boolean
         */
        public  static boolean eliminarPersona (ModeloPersona personaAEliminar){

            ConexionBBDD conexion;
            PreparedStatement pstmt;
            try {
                conexion = new ConexionBBDD();
                //DELETE FROM `DNI`.`dni` WHERE (`dni` = 'asdasd');
                String consulta = "DELETE FROM DNI WHERE (dni = ?)";
                pstmt = conexion.getConexion().prepareStatement(consulta);
                pstmt.setString(1, personaAEliminar.getDni());
                int filasAfectadas = pstmt.executeUpdate();
                pstmt.close();
                conexion.CloseConexion();
                System.out.println("Eliminado con éxito");
                return filasAfectadas > 0;

            } catch (SQLException e) {
                /*
                Alertas alertaError = new Alertas();
                alertaError.mostrarError("No he podido borrar ese registro");
                alertaError.mostrarError(e.getMessage());*/
                System.out.println(e.getMessage());
                return false;
            }
        }

    }


