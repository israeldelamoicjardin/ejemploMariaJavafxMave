package es.israeldelamo.demomariadb.modelos;


/**
 * Modelo que refleja la tabla llamada DNI
 *
 * @author israel
 * @version $Id: $Id
 */
public class ModeloPersona {
    /**
     * Devuelve el dni de una persona
     * @return su dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Asigna un dni a una persona
     * @param dni el dni nuevo
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Crea un objeto de tipo persona a partir de un dni
     * @param dni
     */
    public ModeloPersona(String dni) {
        this.dni = dni;
    }

    /**
     * El valor de DNI de la persona
     */
    private String dni;

}
