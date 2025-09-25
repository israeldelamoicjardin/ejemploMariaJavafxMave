package es.israeldelamo.demomariadb.bbdd;

import es.israeldelamo.demomariadb.util.Propiedades;
import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

/**
     * Clase de conexión a la bbdd
     *
     * @author israel
     * @version $Id: $Id
     */
    public class ConexionBBDD {
        private final Connection conexion;


    private Properties connConfig = new Properties();




        /**
         * Es el constructor que se llama al crear un objeto de esta clase, lanzado la conexión
         *
         * @throws java.sql.SQLException Hay que controlar errores de SQL
         */
        public ConexionBBDD() throws SQLException {
            // los parametros de la conexion leidos desde fuera
            String user = Propiedades.getValor("user");
            String password = Propiedades.getValor("password");
            // las propiedades de la conexión
            connConfig = new Properties();
            connConfig.setProperty("user", user);
            connConfig.setProperty("password", password);
            //la conexion en sí
            conexion = DriverManager.getConnection("jdbc:mariadb://localhost/DNI", connConfig);
            conexion.setAutoCommit(true);
            DatabaseMetaData databaseMetaData = conexion.getMetaData();
            //debug
            System.out.println();
            System.out.println("--- Datos de conexión ------------------------------------------");
            System.out.printf("Base de datos: %s%n", databaseMetaData.getDatabaseProductName());
            System.out.printf("  Versión: %s%n", databaseMetaData.getDatabaseProductVersion());
            System.out.printf("Driver: %s%n", databaseMetaData.getDriverName());
            System.out.printf("  Versión: %s%n", databaseMetaData.getDriverVersion());
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            conexion.setAutoCommit(true);
        }

        /**
         * Esta clase devuelve la conexión creada
         *
         * @return una conexión a la BBDD
         */
        public Connection getConexion() {
            return conexion;
        }

        /**
         * Metodo de cerrar la conexion con la base de datos
         *
         * @return La conexión cerrada.
         * @throws java.sql.SQLException Se lanza en caso de errores de SQL al cerrar la conexión.
         */
        public Connection CloseConexion() throws SQLException{
            conexion.close();
            return conexion;
        }



        public CompletableFuture<Connection> getConexionAsync() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    return DriverManager.getConnection("jdbc:mariadb://localhost/mydb?serverTimezone=Europe/Madrid", connConfig);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    public CompletableFuture<Void> CloseConexionAsync() {
        return CompletableFuture.runAsync(() -> {
            try {
                conexion.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
//
//    public static void main(String[] args) {
//        try {
//            ConexionBBDD conexiontest = new ConexionBBDD();
//        } catch (SQLException e) {
//            System.out.println("error de conexion");
//            throw new RuntimeException(e);
//        }
//
//    }
    }

