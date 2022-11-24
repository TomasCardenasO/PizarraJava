package interfazGrafica;


//como su nombre lo dice, solo lo tomé como ejemplo

import java.awt.*;  
import java.awt.event.*;  
public class MouseMotionListenerExample extends Frame implements MouseMotionListener{  
    MouseMotionListenerExample(){  
        addMouseMotionListener(this);  
          
        setSize(1280,720);  
        setLayout(null);  
        setVisible(true);  
    }  
    @Override  
    public void mouseDragged(MouseEvent e) {  
    Graphics g=getGraphics();  
    g.setColor(Color.BLUE);  
    g.fillOval(e.getX(),e.getY(),20,20);  
}  
    @Override
    public void mouseMoved(MouseEvent e) {}  
  

}  


