package interfazGrafica;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class Pizarra extends JPanel {
    public static int anchoPizarra = 1265;
    public static int largoPizarra = 600;
    Graphics g;
    

    public Pizarra() {
        MListener();
   
        
        this.setBackground(Color.white);
        this.setSize(anchoPizarra, largoPizarra);
        this.setLocation(10, 50);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);    //no tomar en cuenta, no funcionó "borrar la pizarra"
        if(this != null){
            g.setColor(Color.white);  
            g.fillOval(0,0,2000,2000); 
        }
    }
    private void MListener(){  //iniciador de los mouselisteners que se le asigna un adaptador, la función se pone en el constructor(ya hecho)
        addMouseMotionListener(ma);
        addMouseListener(ma);
    
    }
    
    
    MouseAdapter ma = new MouseAdapter(){   //se pueden añadir más funciones, por eso las de abajo quedaron en modo borrador
        @Override
        public void mouseDragged(MouseEvent e) {
                 Graphics g = getGraphics();  
            if(e.getModifiersEx() == 1024){
                  g.setColor(Color.BLACK);  
            g.fillOval(e.getX(),e.getY(),20,20);
                
            }
            else if(e.getModifiersEx() == 4096){  
                g.setColor(Color.WHITE);  
            g.fillOval(e.getX(),e.getY(),20,20);
                
                
            }
     
            
            }  
        public void mouseClicked(MouseEvent e) {
            System.out.println("jajjssaasa");
        }
        public void mouseReleased(MouseEvent e){
            
        }   
   
    };
            

  /*  public void mousePressed(MouseEvent e){
            
        }   
    public void mouseReleased(MouseEvent e) {
            
        }
    public void mouseEntered(MouseEvent e) {
            
        }
    public void mouseExited(MouseEvent e) {
        }*/
}
