package interfazGrafica;

import java.awt.Color;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;

public class PanelPrincipal extends JPanel {
    public ArrayList<Pizarra> pizarras;
    public int indicePizarra;
    private Pizarra pizarraActual;
    private int cantidadPizarras;
    
    public PanelPrincipal() {
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
}
