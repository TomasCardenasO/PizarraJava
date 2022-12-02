package interfazGrafica;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
/**
 * Menu de la aplicacion, donde se accede a todas las funciones.
 * @author Benjamin Puerta
 * @version version 1, 02 de Diciembre de 2022
 * @see Ventana
 */
public class Menu extends JMenuBar  {
    private JMenu archivo, color, lapiz, goma, figuras, pizarra;
    private JMenuItem guardar, guardarcomo, cargarpizarra, negro, azul, rojo, verde, lapizpequeño, lapizmediano, lapizgrande, gomapequeña, gomamediana, gomagrande, borrartodo, rectangulo, circulo, linea, triangulo, pizarrasiguiente, pizarraanterior, eliminarpizarra;
/**
 * En constructor se crean todos los botones de Menu.
 * @param v Ventana a la que se adhiere Menu.
 */
    public Menu(Ventana v) {
        v.setJMenuBar(this); //Se le asigna este menu a la ventana
        
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
        
    }
}