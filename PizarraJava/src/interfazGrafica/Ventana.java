package interfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal;
    public static int ancho = 1300;
    public static int largo = 700;
    public Menu menu;
    
    public Ventana() {
        this.setLayout(new BorderLayout());
        
        panelPrincipal = new PanelPrincipal();
        menu = new Menu(this);
        
        this.add(panelPrincipal, BorderLayout.CENTER);
        
        setTitle("JBoard");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ancho,largo);
        this.setVisible(true);
    }

   
}