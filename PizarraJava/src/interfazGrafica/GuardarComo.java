package interfazGrafica;


import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GuardarComo {
 /** 
 * Herramienta que nos permitirá guardar lo dibujado en formato de imágen.
 * @author Dreyko Paredes
 * @see Pizarra
 */

    /** 
 * En constructor se exporta la imagen generada.
 * @param p Pizarra, la cual almacena la iamgen dibujada.
 */
    public GuardarComo(Pizarra p) {
        try {
      

            String nombreFichero=System.getProperty("user.home")+File.separatorChar+"caputura.jpg";  //luego podríamos ver el como hacer manualmente el nombre
            System.out.println("Generando el fichero: "+nombreFichero );
            FileOutputStream out = new FileOutputStream(nombreFichero);          
          
            p.f.dispose();
            ImageIO.write(p.imagen, "png", out);

        } catch (FileNotFoundException e) {            //para usar lo que tenemos arriba, nos pide usar thrown. 
        } catch (IOException e) {
        }
    }
}