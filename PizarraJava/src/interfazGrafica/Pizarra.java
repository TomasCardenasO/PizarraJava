package interfazGrafica;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Pizarra es una pagina en blanco sobre la que se puede dibujar.
 * @author Tomas Cardenas
 */
public class Pizarra extends JPanel {
    private final static int ANCHO_PIZARRA = 1265; //Se declara así porque es una constante
    private final static int LARGO_PIZARRA = 600;
    public ArrayList<int[]> rectangulos; //arreglo para rectangulos
    public ArrayList<int[]> lineas;       //para lineas
    public ArrayList<int[]> dibujos;        //para lapiz          próximamente podríamos unirlos en un solo arreglo
    public ArrayList<Color> colorDibujos;
/** Descripcion por agregar.*/
    public Graphics g;
    Graphics f;  //será el graphics de nuestro bufferedImage
    BufferedImage imagen; //la imágen que se almacena en el búfer
    Graphics2D graphics2d;   //es un formato de graphics que nos permitirá cambiar su fondo
   
/** Constructor de pizarra en donde definimos el color, tamaño y posicion.*/
    public Pizarra() {
        rectangulos = new ArrayList<>();
        lineas = new ArrayList<>();
        dibujos = new ArrayList<>();
        colorDibujos = new ArrayList<>();
        this.setBackground(Color.white);
        this.setSize(ANCHO_PIZARRA, LARGO_PIZARRA);
        this.setLocation(10, 20);
        imagen = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_RGB); //generamos las dimensiones de imagen
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*Se pintan los rectangulos guardados en el arreglo, cabe destacar que este codigo es inestable ya que solo funcionará
        si se agregan rectangulos (arreglos int[]) de tamaño 4, por lo que se debe tener cuidado al editar*/
        f = imagen.getGraphics(); // le asignamos el graphics de bufferimage
        graphics2d = imagen.createGraphics();
        graphics2d.setBackground(Color.WHITE); 
        graphics2d.clearRect(0,0, this.getWidth(), this.getHeight()); //las coordenadsa de nuestra pizarra
        g.setColor(Color.black);
        f.setColor(Color.black);

        for(int i = 0; i < rectangulos.size(); i++) {
            g.drawRect(rectangulos.get(i)[0], rectangulos.get(i)[1], rectangulos.get(i)[2], rectangulos.get(i)[3]);
            f.drawRect(rectangulos.get(i)[0], rectangulos.get(i)[1], rectangulos.get(i)[2], rectangulos.get(i)[3]);
             
        }
       
        for(int i = 0; i < lineas.size(); i++) {
            g.drawLine(lineas.get(i)[0], lineas.get(i)[1], lineas.get(i)[2], lineas.get(i)[3]);
            f.drawLine(lineas.get(i)[0], lineas.get(i)[1], lineas.get(i)[2], lineas.get(i)[3]);
        }
         for(int i = 0; i < dibujos.size(); i++) {
            g.fillOval(dibujos.get(i)[0], dibujos.get(i)[1], dibujos.get(i)[2], dibujos.get(i)[3]);
            f.fillOval(dibujos.get(i)[0], dibujos.get(i)[1], dibujos.get(i)[2], dibujos.get(i)[3]);

        }  
    }
}

