package DrawingTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Herramienta para crear rectangulos en pizarra.
 * @author Dreyko Paredes
 * @see Pizarra
 */
public class Rectangulos {
    private int x = 0, y = 0;
    private Pizarra pizarraActual;
/** Es el interruptor que nos permite o no dibujar rectangulos*/
    public Boolean estado;
/**
 * Asigna a la pizarra la propiedad de dibujar rectangulos. En primera instancia no permitimos dibujar rectangulos,
 * un boton activará la opción
 * @param p Pizarra en la que se dibujarán los rectangulos.
 */
    public Rectangulos(Pizarra p) {
        pizarraActual = p;
        estado = false;
        eventoOyenteDeRaton();
    }
    private void eventoOyenteDeRaton() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                if(estado == true){
                    pizarraActual.g = pizarraActual.getGraphics();
                    if(e.getModifiersEx() == 1024){
                        pizarraActual.g = pizarraActual.getGraphics();
                        pizarraActual.g.setColor(Color.BLACK);  
                        pizarraActual.g.fillRect(x, y, e.getX() - x, e.getY() - y);
                    }
                }
            }
            public void mousePressed(MouseEvent e) {
                pizarraActual.g = pizarraActual.getGraphics();
                x = e.getX();
                y = e.getY();
                pizarraActual.g.setColor(Color.BLACK);  
                pizarraActual.g.fillRect(x, y, 5, 5);
            }
            public void mouseReleased(MouseEvent e){
            
            }   
        };
        pizarraActual.addMouseListener(adapter);
        pizarraActual.addMouseMotionListener(adapter);
    }
}