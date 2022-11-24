package interfazGrafica;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal;
    public static int ancho = 1300;
    public static int largo = 700;
    
    public Ventana() {
        this.setLayout(new BorderLayout());
        
        panelPrincipal = new PanelPrincipal();
        
        this.add(panelPrincipal, BorderLayout.CENTER);
        
        setTitle("JBoard");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ancho,largo);
        this.setVisible(true);
    }

   
}