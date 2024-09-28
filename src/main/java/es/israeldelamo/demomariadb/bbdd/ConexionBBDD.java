package es.israeldelamo.demomariadb.bbdd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
    /**
     * Clase de conexión a la bbdd
     *
     * @author israel
     * @version $Id: $Id
     */
    public class ConexionBBDD {
        private final Connection conexion;

        /**
         * Es el constructor que se llama al crear un objeto de esta clase, lanzado la conexión
         *
         * @throws java.sql.SQLException Hay que controlar errores de SQL
         */
        public ConexionBBDD() throws SQLException {
            // los parametros de la conexion
            Properties connConfig = new Properties();
            connConfig.setProperty("user", "myuser");
            connConfig.setProperty("password", "mypass");
            //la conexion en sí
            conexion = DriverManager.getConnection("jdbc:mariadb://192.168.0.149/PERSONAS?serverTimezone=Europe/Madrid", connConfig);
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
    }

