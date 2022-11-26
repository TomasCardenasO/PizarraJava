package interfazGrafica;

import DrawingTools.Lapiz;
import DrawingTools.Rectangulos;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;

public class PanelPrincipal extends JPanel    {
    private JButton botonLimpiar, botonAchicar, botonAgrandar, botonRectangulos, botonLapiz;
    
    
    public ArrayList<Pizarra> pizarras;
    public int indicePizarra;
    private Pizarra pizarraActual;
    private int cantidadPizarras;
    private Lapiz lapiz;
    private Rectangulos rectangulos;
    public PanelPrincipal() {
        Botones();
        
        this.setLayout(null);
        this.setBackground(Color.gray); //rojo es color de prueba
        pizarras = new ArrayList<Pizarra>();
        pizarras.add(new Pizarra());
        indicePizarra = 0;
        pizarraActual = pizarras.get(indicePizarra);
        this.add(pizarraActual);
        cantidadPizarras = pizarras.size();
        lapiz = new Lapiz(pizarraActual);
        rectangulos = new Rectangulos(pizarraActual);
        
    }
    public void añadirPizarra() { //Opcion se desbloquea cuando estas en la ultima pizarra
        if(indicePizarra == pizarras.size() - 1) {
            pizarras.add(new Pizarra());
            cantidadPizarras = pizarras.size();
            siguientePizarra();
        }
    }
    public void borrarPizarra() { //Cuando la pagina sea la primera, hay que bloquear esta opcion en el menu
        int indiceABorrar = indicePizarra;
        if(indiceABorrar != 0) {
            pizarraAnterior();
            pizarras.remove(indiceABorrar);
            cantidadPizarras = pizarras.size();
        }
    }
    public void siguientePizarra() {
        if(indicePizarra < pizarras.size() - 1) {
            this.remove(pizarraActual);
            indicePizarra += 1;
            pizarraActual = pizarras.get(indicePizarra);
            this.add(pizarraActual);
            this.repaint();
        }
    }
    public void pizarraAnterior() {
        if(indicePizarra > 0) {
            this.remove(pizarraActual);
            indicePizarra -= 1;
            pizarraActual = pizarras.get(indicePizarra);
            this.add(pizarraActual);
            this.repaint();
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