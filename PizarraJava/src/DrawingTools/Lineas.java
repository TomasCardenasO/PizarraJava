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
public class Lineas {
    private int x, y;
    private Pizarra pizarraActual;
/** Es el interruptor que nos permite o no dibujar rectangulos*/
    public Boolean estado;
/**
 * Asigna a la pizarra la propiedad de dibujar rectangulos. En primera instancia no permitimos dibujar rectangulos,
 * un boton activará la opción
 * @param p Pizarra en la que se dibujarán los rectangulos.
 */
    public Lineas(Pizarra p) {
        pizarraActual = p;
        this.x = 0;
        this.y = 0;
        estado = true;
        eventoOyenteDeRaton();
    }
    private void eventoOyenteDeRaton() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                if(estado == true){
                    if(e.getModifiersEx() == 1024){ //Si el click es del boton izquierdo...
                        pizarraActual.g = pizarraActual.getGraphics();
                        pizarraActual.g.setColor(Color.BLACK);  
                            pizarraActual.g.drawLine(x, y, e.getX(), e.getY());
                        pizarraActual.repaint();
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if(estado == true) {
                //Cada vez que se presione un click se guardaran esas coordenadas iniciales
                    x = e.getX();
                    y = e.getY();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(estado == true) {
                    //Se crea un arreglo con las dimensiones del rectangulo pedidas y se agrega a la pizarra para que este lo pinte
                    int[] newLine = {x, y, e.getX(), e.getY()};
                    pizarraActual.lineas.add(newLine);
                    pizarraActual.repaint();
                }
            }   
        };
        pizarraActual.addMouseListener(adapter);
        pizarraActual.addMouseMotionListener(adapter);
    }
}