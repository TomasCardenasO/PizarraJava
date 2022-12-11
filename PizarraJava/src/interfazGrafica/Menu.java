package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
/**
 * Menu de la aplicacion, donde se accede a todas las funciones.
 * @author Benjamin Puerta
 * @see Ventana
 */
public class Menu extends JMenuBar {
    private JMenu archivo, color, lapiz, goma, figuras, pizarra, tamano;
    private JMenuItem guardar, guardarcomo, cargarpizarra, gomapequeña, gomamediana, gomagrande, borrartodo, rectangulo, circulo, linea, pizarrasiguiente, pizarraanterior, anadirpizarra, eliminarpizarra;
    private JRadioButtonMenuItem lapiznegro, lapizazul, lapizrojo, lapizverde, lapizpequeño, lapizmediano, lapizgrande;
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
        
        lapiz = new JMenu("Lapiz");
        this.add(lapiz);
        
        tamano = new JMenu("Tamaño");
        lapiz.add(tamano);
        ButtonGroup tamanoLapiz = new ButtonGroup();
        lapizpequeño = new JRadioButtonMenuItem("Lapiz Pequeño");
        lapizpequeño.addActionListener(elActionListener);
        tamano.add(lapizpequeño);
        tamanoLapiz.add(lapizpequeño);
        lapizmediano = new JRadioButtonMenuItem("Lapiz Mediano", true);
        lapizmediano.addActionListener(elActionListener);
        tamano.add(lapizmediano);
        tamanoLapiz.add(lapizmediano);
        lapizgrande = new JRadioButtonMenuItem("Lapiz Grande");
        lapizgrande.addActionListener(elActionListener);
        tamano.add(lapizgrande);
        tamanoLapiz.add(lapizgrande);
        
        color = new JMenu("Color");
        lapiz.add(color);
        ButtonGroup coloresLapiz = new ButtonGroup();
        lapiznegro = new JRadioButtonMenuItem("Negro", true);
        lapiznegro.addActionListener(elActionListener);
        color.add(lapiznegro);
        coloresLapiz.add(lapiznegro);
        lapizazul = new JRadioButtonMenuItem("Azul");
        lapizazul.addActionListener(elActionListener);
        color.add(lapizazul);
        coloresLapiz.add(lapizazul);
        lapizrojo = new JRadioButtonMenuItem("Rojo");
        lapizrojo.addActionListener(elActionListener);
        color.add(lapizrojo);
        coloresLapiz.add(lapizrojo);
        lapizverde = new JRadioButtonMenuItem("Verde");
        lapizverde.addActionListener(elActionListener);
        color.add(lapizverde); 
        coloresLapiz.add(lapizverde);
        
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
        anadirpizarra = new JMenuItem("Añadir Pizarra");
        anadirpizarra.addActionListener(elActionListener);
        pizarra.add(anadirpizarra);
        eliminarpizarra = new JMenuItem("Eliminar Pizarra");
        eliminarpizarra.addActionListener(elActionListener);
        pizarra.add(eliminarpizarra);
        
    }
    
    private void funciones(){
        elActionListener = new ActionListener(){       //mouselistener/motionlistener y adapter pueden ser integrados, pero es más engorroso que esto
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == lapizpequeño){
                PanelPP.lapiz.lapizpequeño();
                PanelPP.lapiz();
            }
            if(e.getSource() == lapizmediano){
                PanelPP.lapiz.lapizmediano();
                PanelPP.lapiz();
            }
            if(e.getSource() == lapizgrande){
                PanelPP.lapiz.lapizgrande();
                PanelPP.lapiz();
            }
            
            
            if(e.getSource() == lapiznegro) {
                PanelPP.lapiz.lapizNegro();
            }
            if(e.getSource() == lapizazul) {
                PanelPP.lapiz.lapizAzul();
            }
            if(e.getSource() == lapizrojo) {
                PanelPP.lapiz.lapizRojo();
            }
            if(e.getSource() == lapizverde) {
                PanelPP.lapiz.lapizVerde();
            }
            
             
            if (e.getSource()==rectangulo) {
                PanelPP.rectangulos();
            }
            if (e.getSource()==linea) {
               PanelPP.lineas();                 
            }
            
            if(e.getSource() == pizarrasiguiente) {
                PanelPP.siguientePizarra();
            }
            if(e.getSource() == pizarraanterior) {
                PanelPP.pizarraAnterior();
            }
            if(e.getSource() == anadirpizarra) {
                PanelPP.añadirPizarra();
            }
            if(e.getSource() == eliminarpizarra) {
                PanelPP.eliminarPizarra();
            }
        }
        };
       
    }
 }
