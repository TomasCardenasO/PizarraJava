package interfazGrafica;

import java.awt.Color;

/**
 * Encargado de "almacenar" el color seleccionado con que el lapiz escribira y
 * de retornarselo cuando sea requerido
 *
 * @author Benja
 */
public class ColorHolder {

    private Color color;

    /**
     * Asigna el color por defecto del lapiz recibiendo como parametro un colo
     * entregadao al momento de crear el colorHolder.
     *
     * @param color color por defecto del lapiz
     */
    public ColorHolder(Color color) {
        this.color = color;
    }

    /**
     * Almacena el color que ha sido seleccionado en el menu de la aplicacion
     * recibiendo como parametro el color seleccionado
     *
     * @param colorSelecionado color que ha sido seleccionado en el menu.
     */
    public void cambiarColor(Color colorSelecionado) {
        this.color = colorSelecionado;
    }

    /**
     * Devuelve el color que tiene almacenado
     *
     * @return color almacenado, entregado por seleccion en el menu
     */
    public Color getColor() {
        return color;
    }
}
