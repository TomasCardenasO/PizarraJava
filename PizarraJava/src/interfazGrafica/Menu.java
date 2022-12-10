package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
/**
 * Menu de la aplicacion, donde se accede a todas las funciones.
 * @author Benjamin Puerta
 * @see Ventana
 */
public class Menu extends JMenuBar {
    private JMenu archivo, color, lapiz, goma, figuras, pizarra;
    private JMenuItem guardar, guardarcomo, cargarpizarra, negro, azul, rojo, verde, lapizpequeño, lapizmediano, lapizgrande, gomapequeña, gomamediana, gomagrande, borrartodo, rectangulo, circulo, linea, triangulo, pizarrasiguiente, pizarraanterior, eliminarpizarra;
    private ActionListener elActionListener;
    private PanelPrincipal PanelPP;
/** 
 * En constructor se crean todos los botones de Menu.
 * @param v Ventana a la que se adhiere Menu.
 */
    public Menu(Ventana v) {
        PanelPP = v.getPanelPrincipal();
        v.setJMenuBar(this); //Se le asigna este menu a la ventana
        funciones();
        archivo = new JMenu("Archivo");
        this.add(archivo);
        guardar = new JMenuItem("Guardar");
        archivo.add(guardar);
        guardarcomo = new JMenuItem("Guardar Como");
        archivo.add(guardarcomo);
        cargarpizarra = new JMenuItem("Cagar Pizarra");
        archivo.add(cargarpizarra);
        
        color = new JMenu("Color");
        this.add(color);
        negro = new JMenuItem("Negro");
        color.add(negro);
        azul = new JMenuItem("Azul");
        color.add(azul);
        rojo = new JMenuItem("Rojo");
        color.add(rojo);
        verde = new JMenuItem("Verde");
        color.add(verde); 
        
        lapiz = new JMenu("Lapiz");
        this.add(lapiz);
        lapizpequeño = new JMenuItem("Lapiz Pequeño");
        lapiz.add(lapizpequeño);
        lapizmediano = new JMenuItem("LapizMediano");
        lapiz.add(lapizmediano);
        lapizgrande = new JMenuItem("Lapiz Lapiz");
        lapiz.add(lapizgrande);
        
        goma = new JMenu("Goma");
        this.add(goma);
        gomapequeña = new JMenuItem("Goma Pequeña");
        goma.add(gomapequeña);
        gomamediana = new JMenuItem("Goma Mediana");
        goma.add(gomamediana);
        gomagrande = new JMenuItem("Goma Grande");
        goma.add(gomagrande);
        
        figuras = new JMenu("Figuras");
        this.add(figuras);
        rectangulo = new JMenuItem("Rectangulo");
        figuras.add(rectangulo);
        circulo = new JMenuItem("Circulo");
        figuras.add(circulo);
        linea = new JMenuItem("Linea");
        figuras.add(linea);
        triangulo = new JMenuItem("Triangulo");
        figuras.add(triangulo);
        
        pizarra = new JMenu("Pizarra");
        this.add(pizarra);
        pizarrasiguiente = new JMenuItem("Pizarra Siguiente");
        pizarra.add(pizarrasiguiente);
        pizarraanterior = new JMenuItem("Pizarra Anterior");
        pizarra.add(pizarraanterior);
        eliminarpizarra = new JMenuItem("Eliminar Pizarra");
        pizarra.add(eliminarpizarra);
        
        lapizmediano.addActionListener(elActionListener );
        linea.addActionListener(elActionListener );        
        rectangulo.addActionListener(elActionListener );


    }
    
    private void funciones(){
        elActionListener = new ActionListener(){       //mouselistener/motionlistener y adapter pueden ser integrados, pero es más engorroso que esto
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==lapizmediano) {     //getsourse identifica qué "objeto" estamos apretando
                PanelPP.lapiz();
                System.out.println("lapiz");
            }
      
            if (e.getSource()==rectangulo) {
                PanelPP.rectangulos();
                System.out.println("rectangulo");

            }
            if (e.getSource()==linea) {
               PanelPP.lineas();                
               System.out.println("lineas");

               
            }
        }
        };
       
    }
    
    

 }
