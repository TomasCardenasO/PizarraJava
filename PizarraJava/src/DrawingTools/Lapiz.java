
package DrawingTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Dreyko
 */
public class Lapiz{ 
    public int tamanoL = 20, tamanoG = 20;
    Pizarra pizarraActual;
    public Lapiz(Pizarra p){
    pizarraActual = p;
    eventoOyenteDeRaton();
    }
    
    
    private void eventoOyenteDeRaton(){
         MouseAdapter adapter = new MouseAdapter(){   //se pueden añadir más funciones, por eso las de abajo quedaron en modo borrador
        @Override
        public void mouseDragged(MouseEvent e) { 
            pizarraActual.g = pizarraActual.getGraphics();
            if(e.getModifiersEx() == 1024){
                
                  pizarraActual.g.setColor(Color.BLACK);  
           pizarraActual.g.fillOval(e.getX(),e.getY(),tamanoL,tamanoL);
                
            }
            else if(e.getModifiersEx() == 4096){  
               pizarraActual.g.setColor(Color.WHITE);  
           pizarraActual.g.fillOval(e.getX(),e.getY(),tamanoG,tamanoG);
                
                
            }
     
            
            }  
        public void mouseClicked(MouseEvent e) {
      
        
        }
        public void mouseReleased(MouseEvent e){
            
        }   
   
    };
            

        
        
        
        
        
        
        pizarraActual.addMouseListener(adapter);
        pizarraActual.addMouseMotionListener(adapter);
    
}}

