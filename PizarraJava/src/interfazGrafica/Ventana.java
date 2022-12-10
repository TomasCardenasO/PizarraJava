package interfazGrafica;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * Es la ventana principal del proyecto.
 * @author Tomas Cardenas
 * @see PanelPrincipal
 * @see Menu
 */
public class Ventana extends JFrame {
    private PanelPrincipal PANEL_PRINCIPAL; //Se declara así porque es una constante
    private final static int ANCHO_VENTANA = 1300;
    private final static int LARGO_VENTANA = 700;
    private final Menu MENU;
/**
 * En constructor se crea un panel principal y menu, ademas, se hace configuracion estandar de JFrame
 */
    public Ventana() {
        //Se agregan los componentes PANEL_PRINCIPAL y MENU
        this.setLayout(new BorderLayout());
        PANEL_PRINCIPAL = new PanelPrincipal();
        this.add(PANEL_PRINCIPAL, BorderLayout.CENTER);
        MENU = new Menu(this);
        
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