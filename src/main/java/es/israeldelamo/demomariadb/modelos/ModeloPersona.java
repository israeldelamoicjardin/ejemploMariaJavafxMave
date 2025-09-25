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
     * Constructor con todos los parámetros del modelo
     * @param dni
     * @param nombre
     * @param apellidos
     */
    public ModeloPersona(String dni, String nombre, String apellidos) {
        setDni(dni);
        setNombre(nombre);
       setApellidos(apellidos);
    }

    /**
     * El valor de DNI de la persona
     */
    private String dni;

    /**
     * Devuelve el nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Asigna un apellido
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * El valor de nombre
     */
    private String nombre;
    /**
     * El valor de apellidos
     */
    private String apellidos;

}
