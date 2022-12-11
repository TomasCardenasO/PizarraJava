package DrawingTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Herramienta para crear lineas rectas en pizarra.
 * @author Dreyko Paredes
 * @see Pizarra
 */
public class Lineas {
    private int x, y;
    private  Pizarra pizarraActual;
/** Es el interruptor que nos permite o no dibujar lineas*/
    private Boolean estado;
/**
 * Asigna a la pizarra la propiedad de dibujar lineas. En primera instancia no permitimos dibujar lineas,
 * un boton activará la opción
 * @param p Pizarra en la que se dibujarán las lineas
 */
    public Lineas(Pizarra p) {
        pizarraActual = p;
        this.x = 0;
        this.y = 0;
        estado = false;
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
                    if(e.getModifiersEx() == 0){
                        //Se crea un arreglo con las dimensiones del punto inicial y final de la linea
                        int[] newLine = {x, y, e.getX(), e.getY()};
                        pizarraActual.lineas.add(newLine);
                        pizarraActual.repaint();
                    }
                }
            }   
        };
        pizarraActual.addMouseListener(adapter);
        pizarraActual.addMouseMotionListener(adapter);
    }
    public void cambiarestado(boolean estado){
        this.estado = estado;
        
    }
    public void cambiarPizarra(Pizarra p) {
        pizarraActual = p;
        eventoOyenteDeRaton();
    }
}