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
    private final int tamanoL = 20, tamanoG = 20; //Tamaño de Lapiz y tamaño de Goma
    private final boolean estado = true;
    private Pizarra pizarraActual; 
/**
 * Define una pizarra y la configura para que se pueda rayar.
 * @param p Recibe la pizarra sobre la que se dibujará.
 */
    public Lapiz(Pizarra p){ 
        pizarraActual = p;
        eventoOyenteDeRaton();
    }
    /*Creamos un mouse adapter el cual escucha los eventos del mouse y los traduce a trazos de lapiz (con el click izquierdo)
    y el borrado de la goma (click derecho), luego, asignamos este adapter a nuestra pizarra*/
    private void eventoOyenteDeRaton(){
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                if(estado == true){
                    if(e.getModifiersEx() == 1024) {
                        pizarraActual.P.GuardarPuntos(e.getX(), e.getY());
                        pizarraActual.repaint();
                     
                        

                    }
                } else if(e.getModifiersEx() == 4096) {  
                    pizarraActual.g.setColor(Color.WHITE);  
                    pizarraActual.g.fillOval(e.getX(),e.getY(),tamanoG,tamanoG);
                }
            }
            public void mouseClicked(MouseEvent e) {
                pizarraActual.g = pizarraActual.getGraphics();
                pizarraActual.g.setColor(Color.BLACK);  
                pizarraActual.g.fillOval(e.getX() - tamanoL/2,e.getY() - tamanoL/2, tamanoL, tamanoL);

                    
            }
        };    
        pizarraActual.addMouseListener(adapter);
        pizarraActual.addMouseMotionListener(adapter);
    }
}


