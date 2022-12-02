package interfazGrafica;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Pizarra es una pagina en blanco sobre la que se puede dibujar.
 * @author Tomas Cardenas
 */
public class Pizarra extends JPanel {
    private final static int ANCHO_PIZARRA = 1265; //Se declara así porque es una constante
    private final static int LARGO_PIZARRA = 600;
/** Descripcion por agregar.*/
    public Graphics g;
   
/** Constructor de pizarra en donde definimos el color, tamaño y posicion.*/
    public Pizarra() {
        this.setBackground(Color.white);
        this.setSize(ANCHO_PIZARRA, LARGO_PIZARRA);
        this.setLocation(10, 50);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
