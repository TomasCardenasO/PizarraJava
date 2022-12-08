package interfazGrafica;


import java.util.ArrayList;
import java.util.LinkedList;

public class puntosconArray{
    ArrayList<Integer> puntosX;
     ArrayList<Integer> puntosY;
    public puntosconArray(){
        puntosX = new ArrayList<Integer>();
        puntosY = new ArrayList<Integer>();


    }
    


    public void GuardarPuntos(int x, int y){
       puntosX.add(x);
       puntosY.add(y);
    }
    public ArrayList<Integer> listax(){
        return puntosX;
    }
    public ArrayList<Integer> listay(){
        return puntosY;
    }
    
    
    
    
    
}