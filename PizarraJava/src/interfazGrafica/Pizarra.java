package interfazGrafica;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Pizarra extends JPanel {
    public static int anchoPizarra = 1265;
    public static int largoPizarra = 600;
    public Pizarra() {
        this.setBackground(Color.white);
        this.setSize(anchoPizarra, largoPizarra);
        this.setLocation(10, 50);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
