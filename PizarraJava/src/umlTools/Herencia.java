package umlTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Polygon;
/**
 * Herramienta para crear conexiones de herencia en uml.
 * @author Tomas Cardenas
 * @see Pizarra
 */
public class Herencia {
    private int x, y;
    private  Pizarra pizarraActual;
    private Boolean estado;
/**
 * Inicializa las propiedades y llama a eventoOyenteDeRaton.
 * @param p Pizarra a modificar.
 */
    public Herencia(Pizarra p) {
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
                        if(e.getX() < x) {
                            int[] trianguloX = {x, x, x + 10};
                            int[] trianguloY = {y - 10, y + 10, y};
                            pizarraActual.g.drawPolygon(trianguloX, trianguloY, 3);
                            pizarraActual.repaint();
                        } else if(e.getX() >= x) {
                            int[] trianguloX = {x, x - 10, x};
                            int[] trianguloY = {y - 10, y, y + 10};
                            pizarraActual.g.drawPolygon(trianguloX, trianguloY, 3);
                            pizarraActual.repaint();
                        }
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
                        if(e.getX() < x) {
                            int[] trianguloX = {x, x, x + 10};
                            int[] trianguloY = {y - 10, y + 10, y};
                            Polygon triangulo = new Polygon(trianguloX, trianguloY, 3);
                            pizarraActual.trianguloHerencia.add(triangulo);
                            pizarraActual.repaint();
                        } else if(e.getX() >= x) {
                            int[] trianguloX = {x, x - 10, x};
                            int[] trianguloY = {y - 10, y, y + 10};
                            Polygon triangulo = new Polygon(trianguloX, trianguloY, 3);
                            pizarraActual.trianguloHerencia.add(triangulo);
                            pizarraActual.repaint();
                        }
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
