package umlTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.Font;
import static java.awt.SystemColor.text;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.w3c.dom.Text;
/**
 * Herramienta para crear cuadros de texto editable en pizarra.
 * @author Dreyko Paredes
 * @see Pizarra
 */
public class CuadroUML {
    private int x, y;
    private Pizarra pizarraActual;
/** Es el interruptor que nos permite o no crear los cuadros*/
    private Boolean estado;
    private JPanel panel;
/**
 * Asigna a la pizarra la propiedad de dibujar cuadros de texto editable. En primera instancia no permitimos dibujar cuadros de texto editable,
 * un boton activará la opción
 * @param p Pizarra en la que se dibujarán los cuadors de texto editable.
 */
    public CuadroUML(Pizarra p) {
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
                        pizarraActual.g.drawRect(x, y, e.getX() - x, e.getY() - y);
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
                    pizarraActual.g = pizarraActual.getGraphics();
                    pizarraActual.g.setColor(Color.BLACK);  
                    pizarraActual.g.drawRect(x, y, e.getX() - x, e.getY() - y);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(estado == true) {
                    if(e.getModifiersEx() == 0){
                      
                      pizarraActual.setLayout(null);
                      JTextArea area = new JTextArea();
                      area.setBounds(x, y, e.getX() - x, e.getY() - y);
                      area.setEditable(true);
                      pizarraActual.add(area);
                       //Se crea un arreglo con las dimensiones del rectangulo pedidas y se agrega a la pizarra para que este lo pinte
                        int[] newRect = {x, y, e.getX() - x, e.getY() - y};
                       
                        pizarraActual.rectangulos.add(newRect);
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
}