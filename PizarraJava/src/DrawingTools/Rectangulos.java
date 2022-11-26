/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DrawingTools;

import interfazGrafica.Pizarra;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Dreyko
 */
public class Rectangulos {
    public int tamanoL = 20, tamanoG = 20;
    public int x = 0, y = 0;
    Pizarra pizarraActual;
    public Boolean estado = false;
    public Rectangulos(Pizarra p){
    pizarraActual = p;
    eventoOyenteDeRaton();
    
    
    
}
    private void eventoOyenteDeRaton(){
         MouseAdapter adapter = new MouseAdapter(){   //se pueden añadir más funciones, por eso las de abajo quedaron en modo borrador
        @Override
        public void mouseDragged(MouseEvent e) { 
            if(estado == true){
              pizarraActual.g = pizarraActual.getGraphics();
            if(e.getModifiersEx() == 1024){
                     pizarraActual.g = pizarraActual.getGraphics();
                
                  pizarraActual.g.setColor(Color.BLACK);  
           pizarraActual.g.fillRect(x,y,e.getX()-x,e.getY()-y);
           
            }
            else if(e.getModifiersEx() == 4096){  
               tamanoG = tamanoG + 1;
               
                
            }
     
            
            }  }
        public void mousePressed(MouseEvent e) {
            pizarraActual.g = pizarraActual.getGraphics();
               x = e.getX();
               y = e.getY();
                   pizarraActual.g.setColor(Color.BLACK);  
                  pizarraActual.g.fillRect(x,y,5,5);
      
        
        }
        public void mouseReleased(MouseEvent e){
            
        }   
   
    };
            

        
        
        
        
        
        
        pizarraActual.addMouseListener(adapter);
        pizarraActual.addMouseMotionListener(adapter);
    
}}
