package DrawingTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Herramienta para borrar las pizarras.
 * @author Benjamin Puerta
 * @see Pizarra
 */
public class Goma {
    private int tamanoG = 20; //Tamaño goma
    private boolean estado;
    private Pizarra pizarraActual; 
/**
 * Define una pizarra y la configura para que se pueda borrar
 * @param p Recibe la pizarra sobre la que se borrará
 */
    public Goma(Pizarra p){ 
        pizarraActual = p;
        eventoOyenteDeRaton();
        estado = false;
    }
    private void eventoOyenteDeRaton(){
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { 
                if(estado == true){
                    if(e.getModifiersEx() == 1024){ //Si el click es del boton izquierdo...
                        int[] newOval = {e.getX()-10, e.getY()-10, tamanoG,tamanoG};
                        pizarraActual.dibujos.add(newOval);
                        pizarraActual.colorDibujos.add(Color.white);
                        pizarraActual.repaint();
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if(estado == true){
                    if(e.getModifiersEx() == 1024){ //Si el click es del boton izquierdo...
                        int[] newOval = {e.getX()-10, e.getY()-10, tamanoG,tamanoG};
                        pizarraActual.dibujos.add(newOval);
                        pizarraActual.colorDibujos.add(Color.white);
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
    public void gomapequeña() {
        tamanoG = 10;
    }
    public void gomamediana() {
        tamanoG = 20;
    }
    public void gomagrande() {
        tamanoG = 30;
    }
    
    public void cambiarPizarra(Pizarra p) {
        pizarraActual = p;
        eventoOyenteDeRaton();
    }
}