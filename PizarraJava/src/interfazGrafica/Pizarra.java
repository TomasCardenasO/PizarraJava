package interfazGrafica;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
/**
 * Pizarra es una pagina en blanco sobre la que se puede dibujar.
 * @author Tomas Cardenas
 */
public class Pizarra extends JPanel {
    private final static int ANCHO_PIZARRA = 1265; //Se declara así porque es una constante
    private final static int LARGO_PIZARRA = 600;
    public ArrayList<int[]> rectangulos;
/** Descripcion por agregar.*/
    public Graphics g;
   
/** Constructor de pizarra en donde definimos el color, tamaño y posicion.*/
    public Pizarra() {
        rectangulos = new ArrayList<int[]>();
        this.setBackground(Color.white);
        this.setSize(ANCHO_PIZARRA, LARGO_PIZARRA);
        this.setLocation(10, 20);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*Se pintan los rectangulos guardados en el arreglo, cabe destacar que este codigo es inestable ya que solo funcionará
        si se agregan rectangulos (arreglos int[]) de tamaño 4, por lo que se debe tener cuidado al editar*/
        g.setColor(Color.black);
        for(int i = 0; i < rectangulos.size(); i++) {
            g.drawRect(rectangulos.get(i)[0], rectangulos.get(i)[1], rectangulos.get(i)[2], rectangulos.get(i)[3]);
        }
    }
}
