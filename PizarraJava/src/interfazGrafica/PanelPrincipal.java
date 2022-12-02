package interfazGrafica;

import DrawingTools.Lapiz;
import DrawingTools.Rectangulos;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Es la clase donde ocurren todas las acciones.
 * Se puede pensar en ella como una mesa donde se colocan todos los utensilios
 * @author Tomas Cardenas
 * @see Pizarra
 * @see Lapiz
 * @see Rectangulos
 */
public class PanelPrincipal extends JPanel    {
    private ArrayList<Pizarra> pizarras;
    private Pizarra pizarraActual;
    private int indicePizarraActual;
    private int cantidadPizarras; //Se usara para desplegar la cantidad de pizarras en pantalla
    private Lapiz lapiz;
    private Rectangulos rectangulos;
    
    //Botones temporales
    private JButton botonLimpiar, botonAchicar, botonAgrandar, botonRectangulos, botonLapiz;
    
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
        rectangulos = new Rectangulos(pizarraActual);
        Botones(); //Botones temporales
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
        }
    }
/**
 * 
 */
    public void pizarraAnterior() {
        if(indicePizarraActual > 0) {
            this.remove(pizarraActual);
            indicePizarraActual -= 1;
            pizarraActual = pizarras.get(indicePizarraActual);
            this.add(pizarraActual);
            this.repaint();
        }
    }
/**
 * Añade una pizarra al final del arreglo.
 * Solo se puede usar cuando la pizarra actual es la ultima (indicePizarraActual == pizarras.size() - 1)
 * Despues de agregar la pizarra se llama a siguiente pizarra para que esta se muestre
 */
    public void añadirPizarra() {
        if(indicePizarraActual == pizarras.size() - 1) {
            pizarras.add(new Pizarra());
            cantidadPizarras = pizarras.size();
            siguientePizarra();
        }
    }
    public void borrarPizarra() { //Cuando la pagina sea la primera, hay que bloquear esta opcion en el menu
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
    public void Botones(){  
        this.setLayout(null);
        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(1175,5,100,40);
        this.add(botonLimpiar);
        this.setLayout(null);
        botonAgrandar = new JButton("Agrandar");
        botonAgrandar.setBounds(1075,5,100,40);
        this.add(botonAgrandar);
        botonAchicar = new JButton("Achicar");
        botonAchicar.setBounds(975,5,100,40);
        this.add(botonAchicar);
        botonLapiz = new JButton("Lapiz");
        botonLapiz.setBounds(875,5,100,40);
        this.add(botonLapiz);
        botonRectangulos = new JButton("Rectangulos");
        botonRectangulos.setBounds(775,5,100,40);
        this.add(botonRectangulos);
        eventoOyenteDeRaton();
    }
    private void eventoOyenteDeRaton(){
        MouseListener limpiar = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               pizarraActual.g = pizarraActual.getGraphics();  

                System.out.println("boton apretado");
                pizarraActual.g.setColor(Color.WHITE);  
             pizarraActual.g.fillRect(0,0,2000,2000);
            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                }
                
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        };
        
        
        
        MouseListener agrandar = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                                System.out.println("boton apretado");

                lapiz.tamanoL = lapiz.tamanoL + 5; //son dos variables porque planeo que se modifiquen por separado
               lapiz.tamanoG = lapiz.tamanoG + 5;
               System.out.println(lapiz.tamanoL);
            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {   
                }
                
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        };
        MouseListener achicar = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                                System.out.println("boton apretado");

              lapiz.tamanoL = lapiz.tamanoL - 5; //son dos variables porque planeo que se modifiquen por separado
               lapiz.tamanoG = lapiz.tamanoG - 5;
               if(lapiz.tamanoL <= 20  ){
                   lapiz.tamanoL = 20;
               }
               if(lapiz.tamanoG <= 20  ){
                   lapiz.tamanoG= 20;
               }
               System.out.println(lapiz.tamanoL);

            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {    
                }
                
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
           
            
        };
        MouseListener botLapiz = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                                System.out.println("boton apretado");
                                lapiz.estado = true;
                rectangulos.estado = false;

            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {   
                }
                
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        };
        MouseListener botRectangulos = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                  System.out.println("boton apretado");
                lapiz.estado = false;
                rectangulos.estado = true;

            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {    
                }
                
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
           
            
        };
        
     botonLimpiar.addMouseListener(limpiar);
        botonAchicar.addMouseListener(achicar);
        botonAgrandar.addMouseListener(agrandar);
        
        botonLapiz.addMouseListener(botLapiz);
        botonRectangulos.addMouseListener(botRectangulos);
    }
}