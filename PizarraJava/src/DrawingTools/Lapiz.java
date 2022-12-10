package DrawingTools;

import interfazGrafica.Pizarra;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Herramienta para dibujar trazos.
 * @author Dreyko Paredes
 * @see Pizarra
 */
public class Lapiz { 
    private int tamanoL = 20; //Tamaño de Lapiz y tamaño de Goma, tal vez después se tengan que dividir en 2 clases
    private Color color;
    private boolean estado;
    private Pizarra pizarraActual; 
/**
 * Define una pizarra y la configura para que se pueda rayar.
 * @param p Recibe la pizarra sobre la que se dibujará.
 */
    public Lapiz(Pizarra p){ 
        pizarraActual = p;
        color = Color.black;
        eventoOyenteDeRaton();
        estado = true;
    }
    /*Creamos un mouse adapter el cual escucha los eventos del mouse y los traduce a trazos de lapiz (con el click izquierdo)
    y el borrado de la goma (click derecho), luego, asignamos este adapter a nuestra pizarra*/
    private void eventoOyenteDeRaton(){
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                if(estado == true){
                    if(e.getModifiersEx() == 1024){ //Si el click es del boton izquierdo...
                        int[] newOval = {e.getX()-10, e.getY()-10, tamanoL,tamanoL};
                        pizarraActual.dibujos.add(newOval);
                        pizarraActual.colorDibujos.add(color);
                        pizarraActual.repaint();
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if(estado == true){
                    if(e.getModifiersEx() == 1024){ //Si el click es del boton izquierdo...
                        int[] newOval = {e.getX()-10, e.getY()-10, tamanoL,tamanoL};
                        pizarraActual.dibujos.add(newOval);
                        pizarraActual.colorDibujos.add(color);
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
    public void lapizNegro() {
        color = Color.black;
    }
    public void lapizAzul() {
        color = Color.blue;
    }
    public void lapizRojo() {
        color = Color.red;
    }
    public void lapizVerde() {
        color = Color.green;
    }
    
    public void lapizpequeño() {
        tamanoL = 10;
    }
    public void lapizmediano() {
        tamanoL = 20;
    }
    public void lapizgrande() {
        tamanoL = 30;
    }
}


