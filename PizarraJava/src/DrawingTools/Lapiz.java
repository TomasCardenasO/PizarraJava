package DrawingTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
/**
 * Herramienta para dibujar trazos.
 * @author Dreyko Paredes
 * @see Pizarra
 */
public class Lapiz { 
    private final int tamanoL = 20, tamanoG = 20; //Tamaño de Lapiz y tamaño de Goma, tal vez después se tengan que dividir en 2 clases
    private boolean estado;
    private Pizarra pizarraActual; 
/**
 * Define una pizarra y la configura para que se pueda rayar.
 * @param p Recibe la pizarra sobre la que se dibujará.
 */
    public Lapiz(Pizarra p){ 
        pizarraActual = p;
        eventoOyenteDeRaton();
        estado = true;
    }
    /*Creamos un mouse adapter el cual escucha los eventos del mouse y los traduce a trazos de lapiz (con el click izquierdo)
    y el borrado de la goma (click derecho), luego, asignamos este adapter a nuestra pizarra*/
    private void eventoOyenteDeRaton(){
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                pizarraActual.g = pizarraActual.getGraphics();
                if(estado == true){
                    if(e.getModifiersEx() == 1024){ //Si el click es del boton izquierdo...
                        int[] newOval = {e.getX()-10, e.getY()-10, 20,20};
                        pizarraActual.dibujos.add(newOval);
                    }
                }
            }
            public void mousePressed(MouseEvent e) {
                pizarraActual.g = pizarraActual.getGraphics();
                if(estado == true){
                    if(e.getModifiersEx() == 1024){ //Si el click es del boton izquierdo...
                        int[] newOval = {e.getX()-10, e.getY()-10, 20,20};
                        pizarraActual.dibujos.add(newOval);
                    }
                }
            }   
        };    
        pizarraActual.addMouseListener(adapter);
        pizarraActual.addMouseMotionListener(adapter);
    }
}


