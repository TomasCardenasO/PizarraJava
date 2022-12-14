package umlTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Polygon;
/**
 * Herramienta para crear conexiones de agregacion en uml.
 * @author Tomas Cardenas
 * @see Pizarra
 */
public class Agregacion {
    private int x, y;
    private  Pizarra pizarraActual;
    private Boolean estado;
/**
 * Inicializa las propiedades y llama a eventoOyenteDeRaton.
 * @param p Pizarra a modificar.
 */
    public Agregacion(Pizarra p) {
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
                    if(e.getModifiersEx() == 1024){
                        pizarraActual.g = pizarraActual.getGraphics();
                        pizarraActual.g.setColor(Color.BLACK);  
                        pizarraActual.g.drawLine(x, y, e.getX(), e.getY());
                        int[] romboX = {x, x - 10, x, x + 10};
                        int[] romboY = {y - 10, y, y + 10, y};
                        pizarraActual.g.drawPolygon(romboX, romboY, 4);
                        pizarraActual.repaint();
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if(estado == true) {
                    x = e.getX();
                    y = e.getY();
                }
            }
            @Override
                public void mouseReleased(MouseEvent e) {
                if(estado == true) {
                    if(e.getModifiersEx() == 0){
                        int[] newLine = {x, y, e.getX(), e.getY()};
                        pizarraActual.lineas.add(newLine);
                        int[] romboX = {x, x - 10, x, x + 10};
                        int[] romboY = {y - 10, y, y + 10, y};
                        Polygon rombo = new Polygon(romboX, romboY, 4);
                        pizarraActual.romboAgregacion.add(rombo);
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
