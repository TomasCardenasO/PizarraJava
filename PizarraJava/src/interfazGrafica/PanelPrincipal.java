package interfazGrafica;

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
    public ArrayList<Pizarra> pizarras;
    public int indicePizarra;
    private Pizarra pizarraActual;
    private int cantidadPizarras;
    
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
        Boton botonLimpiar = new Boton("Limpiar", pizarraActual);
        botonLimpiar.setBounds(1195,5,80,40);
        this.add(botonLimpiar);
    }
    private class Boton extends JButton implements MouseListener{  //Botones que hay que implementar bien
        private int x;
        private int y = 1;
        private Pizarra panel;
        public Boton(String s, Pizarra p) {
            super(s);
            panel = p;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
             
            panel.repaint(); //intenté un "horrar pizarra", que en realidad era blanquear toda la pizarra de nuevo.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
      
    }
    
}
