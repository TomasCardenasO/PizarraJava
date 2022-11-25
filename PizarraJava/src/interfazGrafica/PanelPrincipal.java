package interfazGrafica;

import DrawingTools.Lapiz;
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
    JButton botonLimpiar;
    public ArrayList<Pizarra> pizarras;
    public int indicePizarra;
    private Pizarra pizarraActual;
    private int cantidadPizarras;
    private Lapiz lapiz;
    
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
        botonLimpiar.setBounds(1195,5,80,40);
        this.add(botonLimpiar);
        eventoOyenteDeRaton();
    }
    private void eventoOyenteDeRaton(){
        MouseListener oyentedeRaton = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               pizarraActual.g = pizarraActual.getGraphics();  

                System.out.println("jaja");
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
                System.out.println("jaja");            
                }
                
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        };
        
        
        
        
        
        
        botonLimpiar.addMouseListener(oyentedeRaton);
    }
}