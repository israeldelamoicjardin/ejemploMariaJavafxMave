package es.israeldelamo.demomariadb;

/**
 * Punto de entrada en la aplicación
 * @author Israel
 * @version 1.0
 */
public class Lanzador {
    public static void main(String[] args) {
        // una medida de seguridad es usar esta clase lanzadora
        // como no extiende a application es menos probable que falle
        // solo sirve para lanzar la otra clase
        AdministradorPersonas.launch(AdministradorPersonas.class);
    }
}
