package DrawingTools;

import interfazGrafica.ColorHolder;
import interfazGrafica.Pizarra;
import interfazGrafica.TamanoHolder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

/**
 * Herramienta para dibujar trazos que cambiara su color y tamano dependiendo de lo seleccionado en el menu
 *
 * @author Dreyko Paredes
 * @see Pizarra
 * @see ColorHolder
 * @see TamanoHolder
 */
public class Lapiz {

    private final int tamano;
    private Color color;
    private boolean estado;
    private Pizarra pizarraActual;
    private final ColorHolder colorHolder;
    private final TamanoHolder tamanoHolder;

    /**
     * Define una pizarra y la configura para que se pueda rayar.
     *
     * @param p Recibe la pizarra sobre la que se dibujará.
     * @param colorHolder recibe el colorHolder ya que se hara llamado a su funcion get para sabe de que color rayar
     * @param tamanHolder recibe el tamanoHolder ya que se hace llamado a su funcion get apra saber de que tamano seran las rays
     */
    public Lapiz(Pizarra p, ColorHolder colorHolder, TamanoHolder tamanoHolder) {
        tamano = tamanoHolder.getTamano();
        color = colorHolder.getColor();
        pizarraActual = p;
        eventoOyenteDeRaton();
        estado = true;
        this.colorHolder = colorHolder;
        this.tamanoHolder = tamanoHolder;
    }
    
   
    /*Creamos un mouse adapter el cual escucha los eventos del mouse y los traduce a trazos de lapiz (con el click izquierdo)
    y el borrado de la goma (click derecho), luego, asignamos este adapter a nuestra pizarra*/
    private void eventoOyenteDeRaton() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (estado == true) {
                    if (e.getModifiersEx() == 1024) { //Si el click es del boton izquierdo...
                        int[] newOval = {e.getX() - 10, e.getY() - 10, tamanoHolder.getTamano(), tamanoHolder.getTamano()};
                        pizarraActual.dibujos.add(newOval);
                        pizarraActual.colorDibujos.add(colorHolder.getColor());
                        pizarraActual.repaint();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (estado == true) {
                    if (e.getModifiersEx() == 1024) { //Si el click es del boton izquierdo...
                        int[] newOval = {e.getX() - 10, e.getY() - 10, tamanoHolder.getTamano(), tamanoHolder.getTamano()};
                        pizarraActual.dibujos.add(newOval);
                        pizarraActual.colorDibujos.add(colorHolder.getColor());
                        pizarraActual.repaint();
                    }
                }
            }
        };
        pizarraActual.addMouseListener(adapter);
        pizarraActual.addMouseMotionListener(adapter);
    }

    public void cambiarestado(boolean estado) {
        this.estado = estado;
    }

    public boolean returnestado() {
        return estado;
    }

    public void cambiarPizarra(Pizarra p) {
        pizarraActual = p;
        eventoOyenteDeRaton();
    }
}