package interfazGrafica;

/**
 * Encargado de "almacenar" el tamano de lapiz seleccionado en el menu y
 * retornarlo cuando es solicitado
 *
 * @author Benja
 */
public class TamanoHolder {

    private int tamano;

    /**
     * Asigna el tamano por defecto que tendra el lapiz entregado como parametro
     * al ser creado
     *
     * @param tamano tamano por defecto de el lapiz
     */
    public TamanoHolder(int tamano) {
        this.tamano = tamano;
    }

    /**
     * Encargado de almacenar el nuevo tamano seleccionado en el menu para poder
     * ser solicitado
     *
     * @param tamanoSeleccionado entero que representa el tamano de dibujo de el
     * lapiz
     */
    public void cambiarTamano(int tamanoSeleccionado) {
        this.tamano = tamanoSeleccionado;
    }

    /**
     * Devuevle el tamano que tiene almacenado el holder
     *
     * @return tamano almacenado por el holder, seleccioando en el menu.
     */
    public int getTamano() {
        return tamano;
    }
}
