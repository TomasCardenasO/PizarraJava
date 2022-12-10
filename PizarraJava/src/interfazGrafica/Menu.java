package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JMenuItem guardar, guardarcomo, cargarpizarra, negro, azul, rojo, verde, lapizpequeño, lapizmediano, lapizgrande, gomapequeña, gomamediana, gomagrande, borrartodo, rectangulo, circulo, linea, pizarrasiguiente, pizarraanterior, eliminarpizarra;
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
        guardar.addActionListener(elActionListener);
        archivo.add(guardar);
        guardarcomo = new JMenuItem("Guardar Como");
        guardarcomo.addActionListener(elActionListener);
        archivo.add(guardarcomo);
        cargarpizarra = new JMenuItem("Cagar Pizarra");
        cargarpizarra.addActionListener(elActionListener);
        archivo.add(cargarpizarra);
        
        color = new JMenu("Color");
        this.add(color);
        negro = new JMenuItem("Negro");
        negro.addActionListener(elActionListener);
        color.add(negro);
        azul = new JMenuItem("Azul");
        azul.addActionListener(elActionListener);
        color.add(azul);
        rojo = new JMenuItem("Rojo");
        rojo.addActionListener(elActionListener);
        color.add(rojo);
        verde = new JMenuItem("Verde");
        verde.addActionListener(elActionListener);
        color.add(verde); 
        
        lapiz = new JMenu("Lapiz");
        this.add(lapiz);
        lapizpequeño = new JMenuItem("Lapiz Pequeño");
        lapizpequeño.addActionListener(elActionListener);
        lapiz.add(lapizpequeño);
        lapizmediano = new JMenuItem("LapizMediano");
        lapizmediano.addActionListener(elActionListener);
        lapiz.add(lapizmediano);
        lapizgrande = new JMenuItem("Lapiz Lapiz");
        lapizgrande.addActionListener(elActionListener);
        lapiz.add(lapizgrande);
        
        goma = new JMenu("Goma");
        this.add(goma);
        gomapequeña = new JMenuItem("Goma Pequeña");
        gomapequeña.addActionListener(elActionListener);
        goma.add(gomapequeña);
        gomamediana = new JMenuItem("Goma Mediana");
        gomamediana.addActionListener(elActionListener);
        goma.add(gomamediana);
        gomagrande = new JMenuItem("Goma Grande");
        gomagrande.addActionListener(elActionListener);
        goma.add(gomagrande);
        
        figuras = new JMenu("Figuras");
        this.add(figuras);
        rectangulo = new JMenuItem("Rectangulo");
        rectangulo.addActionListener(elActionListener);
        figuras.add(rectangulo);
        circulo = new JMenuItem("Circulo");
        circulo.addActionListener(elActionListener);
        figuras.add(circulo);
        linea = new JMenuItem("Linea");
        linea.addActionListener(elActionListener);
        figuras.add(linea);
        
        pizarra = new JMenu("Pizarra");
        this.add(pizarra);
        pizarrasiguiente = new JMenuItem("Pizarra Siguiente");
        pizarrasiguiente.addActionListener(elActionListener);
        pizarra.add(pizarrasiguiente);
        pizarraanterior = new JMenuItem("Pizarra Anterior");
        pizarraanterior.addActionListener(elActionListener);
        pizarra.add(pizarraanterior);
        eliminarpizarra = new JMenuItem("Eliminar Pizarra");
        eliminarpizarra.addActionListener(elActionListener);
        pizarra.add(eliminarpizarra);
        


    }
    
    private void funciones(){
        elActionListener = new ActionListener(){       //mouselistener/motionlistener y adapter pueden ser integrados, pero es más engorroso que esto
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == negro) {
                PanelPP.lapiz.lapizNegro();
            }
            if(e.getSource() == azul) {
                PanelPP.lapiz.lapizAzul();
            }
            if(e.getSource() == rojo) {
                PanelPP.lapiz.lapizRojo();
            }
            if(e.getSource() == verde) {
                PanelPP.lapiz.lapizVerde();
            }
            if (e.getSource()==lapizmediano) {     //getsourse identifica qué "objeto" estamos apretando
                PanelPP.lapiz();
            }
            if (e.getSource()==rectangulo) {
                PanelPP.rectangulos();
            }
            if (e.getSource()==linea) {
               PanelPP.lineas();                 
            }
        }
        };
       
    }
 }
