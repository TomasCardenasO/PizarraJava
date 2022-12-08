package interfazGrafica;


import java.util.LinkedList;

public class puntos{
    LinkedList<Integer> puntosX = new LinkedList();
    LinkedList<Integer> puntosY = new LinkedList();

    public void GuardarPuntos(int x, int y){
       puntosX.add(x);
       puntosY.add(y);
    }
    public LinkedList<Integer> listax(){
        return puntosX;
    }
    public LinkedList<Integer> listay(){
        return puntosY;
    }
    
    
    
    
    
}