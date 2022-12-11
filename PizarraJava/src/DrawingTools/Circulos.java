package DrawingTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Herramienta para crear circulos en pizarra.
 * @author Tomas Cardenas
 * @see Pizarra
 */
public class Circulos {
    private int x, y;
    private Pizarra pizarraActual;
/** Es el interruptor que nos permite o no dibujar circulos*/
    private Boolean estado;
/**
 * Asigna a la pizarra la propiedad de dibujar circulos. En primera instancia no permitimos dibujar circulos,
 * un boton activará la opción
 * @param p Pizarra en la que se dibujarán los circulos.
 */
    public Circulos(Pizarra p) {
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
                        pizarraActual.g.drawOval(x, y, e.getX() - x, e.getY() - y);
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
                        //Se crea un arreglo con las dimensiones del circulo pedidas y se agrega a la pizarra para que este lo pinte
                        int[] newOval = {x, y, e.getX() - x, e.getY() - y};
                        pizarraActual.circulos.add(newOval);
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