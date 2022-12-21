package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.Color;

/**
 * Menu de la aplicacion, donde se accede a todas las funciones.
 *
 * @author Benjamin Puerta
 * @see Ventana
 */
public class Menu extends JMenuBar {

    private JMenu archivo, lapiz, figuras, figurasUML, pizarra, tamanoPincel;
    private JMenuItem guardar, guardarcomo, cargarpizarra, borrartodo, rectangulo, circulo, linea, pizarrasiguiente, pizarraanterior, anadirpizarra, eliminarpizarra, cuadroUML, agregacion, composicion, herencia;
    private JRadioButtonMenuItem lapiznegro, lapizazul, lapizrojo, lapizverde, pequeno, mediano, grande, goma;
    private ActionListener elActionListener;
    private PanelPrincipal PanelPP;

    /**
     * En constructor se crean todos los botones de Menu.
     *
     * @param v Ventana a la que se adhiere Menu.
     * @param colorHolder colorHolder utilizado, necesario para el
     * funcionamiento del menu al seleccionar colores
     * @param tamanoHolder TamanoHolder utilizado, necesario para el
     * funcionamuiento del menu al seleccionar tamanos
     */
    public Menu(Ventana v, ColorHolder colorHolder, TamanoHolder tamanoHolder) {
        PanelPP = v.getPanelPrincipal();
        v.setJMenuBar(this); //Se le asigna este menu a la ventana
        funciones(colorHolder, tamanoHolder);
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
        ButtonGroup coloresLapiz = new ButtonGroup();
        lapiznegro = new JRadioButtonMenuItem("Negro", true);
        lapiznegro.addActionListener(elActionListener);
        lapiz.add(lapiznegro);
        coloresLapiz.add(lapiznegro);
        lapizazul = new JRadioButtonMenuItem("Azul");
        lapizazul.addActionListener(elActionListener);
        lapiz.add(lapizazul);
        coloresLapiz.add(lapizazul);
        lapizrojo = new JRadioButtonMenuItem("Rojo");
        lapizrojo.addActionListener(elActionListener);
        lapiz.add(lapizrojo);
        coloresLapiz.add(lapizrojo);
        lapizverde = new JRadioButtonMenuItem("Verde");
        lapizverde.addActionListener(elActionListener);
        lapiz.add(lapizverde);
        coloresLapiz.add(lapizverde);
        goma = new JRadioButtonMenuItem("Goma");
        goma.addActionListener(elActionListener);
        lapiz.add(goma);
        coloresLapiz.add(goma);

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

        figurasUML = new JMenu("FigurasUML");
        this.add(figurasUML);
        cuadroUML = new JMenuItem("CuadroUML");
        cuadroUML.addActionListener(elActionListener);
        figurasUML.add(cuadroUML);
        agregacion = new JMenuItem("Agregación");
        agregacion.addActionListener(elActionListener);
        figurasUML.add(agregacion);
        composicion = new JMenuItem("Composición");
        composicion.addActionListener(elActionListener);
        figurasUML.add(composicion);
        herencia = new JMenuItem("Herencia");
        herencia.addActionListener(elActionListener);
        figurasUML.add(herencia);

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

        tamanoPincel = new JMenu("Tamaño Pincel");
        this.add(tamanoPincel);
        ButtonGroup tamano = new ButtonGroup();
        pequeno = new JRadioButtonMenuItem("Pequeño");
        pequeno.addActionListener(elActionListener);
        tamano.add(pequeno);
        tamanoPincel.add(pequeno);
        mediano = new JRadioButtonMenuItem("Mediano", true);
        mediano.addActionListener(elActionListener);
        tamano.add(mediano);
        tamanoPincel.add(mediano);
        grande = new JRadioButtonMenuItem("Grande");
        grande.addActionListener(elActionListener);
        tamano.add(grande);
        tamanoPincel.add(grande);
    }

    /**
     * Encargado de que todos los botnes del menu funcionen correctamente
     *
     * @param colorHolder colorHolder, se necesita para que este pueda almacenar el nuevo color seleccioando
     * @param tamanoHolder tamanoHolder, se necesita para que este pueda al;macenar el nuevo tamano seleccionado
     */
    private void funciones(ColorHolder colorHolder, TamanoHolder tamanoHolder) {
        elActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (e.getSource() == lapiznegro) {
                    colorHolder.cambiarColor(Color.black);
                    PanelPP.lapiz();
                }
                if (e.getSource() == lapizazul) {
                    colorHolder.cambiarColor(Color.blue);
                    PanelPP.lapiz();
                }
                if (e.getSource() == lapizrojo) {
                    colorHolder.cambiarColor(Color.red);
                    PanelPP.lapiz();
                }
                if (e.getSource() == lapizverde) {
                    colorHolder.cambiarColor(Color.green);
                    PanelPP.lapiz();
                }
                if (e.getSource() == goma) {
                    colorHolder.cambiarColor(Color.white);
                    PanelPP.lapiz();
                }
                if (e.getSource() == pequeno) {
                    tamanoHolder.cambiarTamano(10);
                    PanelPP.lapiz();
                }
                if (e.getSource() == mediano) {
                    tamanoHolder.cambiarTamano(20);
                    PanelPP.lapiz();
                }
                if (e.getSource() == grande) {
                    tamanoHolder.cambiarTamano(30);
                    PanelPP.lapiz();
                }
                if (e.getSource() == rectangulo) {
                    PanelPP.rectangulos();
                }
                if (e.getSource() == circulo) {
                    PanelPP.circulos();
                }
                if (e.getSource() == linea) {
                    PanelPP.lineas();
                }
                if (e.getSource() == pizarrasiguiente) {
                    PanelPP.siguientePizarra();
                }
                if (e.getSource() == pizarraanterior) {
                    PanelPP.pizarraAnterior();
                }
                if (e.getSource() == anadirpizarra) {
                    PanelPP.añadirPizarra();
                }
                if (e.getSource() == eliminarpizarra) {
                    PanelPP.eliminarPizarra();
                }
                if (e.getSource() == cuadroUML) {
                    PanelPP.cuadroUML();

                }
                if (e.getSource() == agregacion) {
                    PanelPP.agregacion();
                }
                if (e.getSource() == composicion) {
                    PanelPP.composicion();
                }
                if (e.getSource() == herencia) {
                    PanelPP.herencia();
                }
            }
        };
    }
}
