package interfazGrafica;

import DrawingTools.Lapiz;
import DrawingTools.Goma;
import DrawingTools.Lineas;
import DrawingTools.Rectangulos;
import DrawingTools.Circulos;
import umlTools.CuadroUML;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Es la clase donde ocurren todas las acciones.
 * Se puede pensar en ella como una mesa donde se colocan todos los utensilios
 * @author Tomas Cardenas
 * @author Dreyko Paredes
 * @author Benjamin Puerta
 * @see Pizarra
 * @see Lapiz
 * @see Rectangulos
 * @see Lineas
 */
public class PanelPrincipal extends JPanel    {
    private ArrayList<Pizarra> pizarras;
    private Pizarra pizarraActual;
    private int indicePizarraActual;
    private int cantidadPizarras; //Se usara para desplegar la cantidad de pizarras en pantalla
    public Lapiz lapiz;
    public Goma goma;
    private Rectangulos rectangulos;
    private Circulos circulos;
    private Lineas lineas;
    private CuadroUML cuadroUML;
/**
 * En constructor se crea el arreglo de pizarras con una pizarra inicial.
 * Se configura el layout en null y el color gris,
 * ademas, se crea el lapiz y la herramienta de rectangulos
 */
    public PanelPrincipal() {
        //Configuracion inicial (Layout y color)
        this.setLayout(null);
        this.setBackground(Color.gray);
        
        //Se crea el arreglo de pizarras y se agrega una pizarra inicial
        pizarras = new ArrayList<Pizarra>();
        pizarras.add(new Pizarra());
        indicePizarraActual = 0;
        pizarraActual = pizarras.get(indicePizarraActual);
        this.add(pizarraActual);
        
        cantidadPizarras = pizarras.size();
        lapiz = new Lapiz(pizarraActual);
        goma = new Goma(pizarraActual);
        rectangulos = new Rectangulos(pizarraActual);
        circulos = new Circulos(pizarraActual);
        lineas = new Lineas(pizarraActual);
        cuadroUML = new CuadroUML(pizarraActual);
    }
/**
 * Hace que la pizarra que sigue se muestre en pantalla.
 * Solo funciona cuando la pizarra actual no es la ultima (indicePizarraActual < pizarras.size() - 1),
 * saca a la pizarra actual de la pantalla y muestra la siguiente
 */
    public void siguientePizarra() {
        if(indicePizarraActual < pizarras.size() - 1) {
            this.remove(pizarraActual);
            indicePizarraActual += 1;
            pizarraActual = pizarras.get(indicePizarraActual);
            this.add(pizarraActual);
            this.repaint();
            lapiz.cambiarPizarra(pizarraActual);
            goma.cambiarPizarra(pizarraActual);
            rectangulos.cambiarPizarra(pizarraActual);
            circulos.cambiarPizarra(pizarraActual);
            lineas.cambiarPizarra(pizarraActual);
        }
    }
/**
 * Hace que la pizarra anterior se muestre en pantalla.
 * Solo funciona cuando la pizarra actual no es la primera (indicePizarraActual > 0).
 * Remueve la pizarra actual del panel y muestra la anterior
 */
    public void pizarraAnterior() {
        if(indicePizarraActual > 0) {
            this.remove(pizarraActual);
            indicePizarraActual -= 1;
            pizarraActual = pizarras.get(indicePizarraActual);
            this.add(pizarraActual);
            this.repaint();
            lapiz.cambiarPizarra(pizarraActual);
            goma.cambiarPizarra(pizarraActual);
            rectangulos.cambiarPizarra(pizarraActual);
            circulos.cambiarPizarra(pizarraActual);
            lineas.cambiarPizarra(pizarraActual);
        }
    }
/**
 * Añade una pizarra al final del arreglo.
 * Solo se puede usar cuando la pizarra actual es la ultima (indicePizarraActual == pizarras.size() - 1)
 * Despues de agregar la pizarra se llama a "siguiente pizarra" para que esta se muestre
 */
    public void añadirPizarra() {
        if(indicePizarraActual == pizarras.size() - 1) {
            pizarras.add(new Pizarra());
            cantidadPizarras = pizarras.size();
            siguientePizarra();
        }
    }
/**
 * Elimina la pizarra que esta actualmente en pantalla.
 * No es posible eliminar la primera pizarra (indiceABorrar != 0) ya que podría traer diversos problemas
 * Si la pizarra que se quiere eliminar no es la primera, se pasa a la pagina anterior y luego se elimina la pizarra requerida
 */
    public void eliminarPizarra() { //Cuando la pagina sea la primera, hay que bloquear esta opcion en el menu
        int indiceABorrar = indicePizarraActual;
        if(indiceABorrar != 0) {
            pizarraAnterior();
            pizarras.remove(indiceABorrar);
            cantidadPizarras = pizarras.size();
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
    }
    public void lapiz(){          
        lapiz.cambiarestado(true);
        goma.cambiarestado(false);
        rectangulos.cambiarestado(false);
        circulos.cambiarestado(false);
        lineas.cambiarestado(false);
        cuadroUML.cambiarestado(false);

       
    }
    public void goma() {
        lapiz.cambiarestado(false);
        goma.cambiarestado(true);
        rectangulos.cambiarestado(false);
        circulos.cambiarestado(false);
        lineas.cambiarestado(false);
        cuadroUML.cambiarestado(false);

    }
    public void rectangulos(){
        lapiz.cambiarestado(false);
        goma.cambiarestado(false);
        rectangulos.cambiarestado(true);
        circulos.cambiarestado(false);
        lineas.cambiarestado(false);
        cuadroUML.cambiarestado(false);

        
    }
    public void circulos(){
        lapiz.cambiarestado(false);
        goma.cambiarestado(false);
        rectangulos.cambiarestado(false);
        circulos.cambiarestado(true);
        lineas.cambiarestado(false);
        cuadroUML.cambiarestado(false);

        
    }
    public void lineas(){           
        lapiz.cambiarestado(false);
        goma.cambiarestado(false);
        rectangulos.cambiarestado(false);
        circulos.cambiarestado(false);
        lineas.cambiarestado(true);
        cuadroUML.cambiarestado(false);
        
    }
    public void cuadroUML(){           
        lapiz.cambiarestado(false);
        goma.cambiarestado(false);
        rectangulos.cambiarestado(false);
        circulos.cambiarestado(false);
        lineas.cambiarestado(false);
        cuadroUML.cambiarestado(true);
        
    }
}