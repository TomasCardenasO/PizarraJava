package interfazGrafica;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import static java.awt.Color.black;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * Es la ventana principal del proyecto.
 * @author Tomas Cardenas
 * @see PanelPrincipal
 * @see Menu
 */
public class Ventana extends JFrame {
    private final PanelPrincipal PANEL_PRINCIPAL; //Se declara así porque es una constante
    private final static int ANCHO_VENTANA = 1300;
    private final static int LARGO_VENTANA = 700;
    private final Menu MENU;
    private final ColorHolder colorHolder;
    private final TamanoHolder tamanoHolder;
/**
 * En constructor se crea un panel principal, menu y los 2 holder utilizados, ademas, se hace configuracion estandar de JFrame
 */
    public Ventana() {
        //Se agregan los componentes PANEL_PRINCIPAL y MENU, se crean los holder aca 
        //ya que seran requerido tanto por panel pricnipal como por menu.
        colorHolder = new ColorHolder(black);
        tamanoHolder = new TamanoHolder(20);
        this.setLayout(new BorderLayout());
        PANEL_PRINCIPAL = new PanelPrincipal(colorHolder, tamanoHolder);
        this.add(PANEL_PRINCIPAL, BorderLayout.CENTER);
        MENU = new Menu(this, colorHolder, tamanoHolder);
        
        //Se configura la ventana
        setTitle("JBoard");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ANCHO_VENTANA, LARGO_VENTANA);
        this.setVisible(true);
    }
   
    PanelPrincipal getPanelPrincipal() {     //para que panel principal no sea public
         return PANEL_PRINCIPAL;
    }
}