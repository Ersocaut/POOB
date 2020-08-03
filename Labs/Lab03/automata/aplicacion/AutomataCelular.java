package aplicacion;

import java.util.*;

public class AutomataCelular{
    static private int LONGITUD=20;
    private Elemento[][] automata;
    static private int age = 0;
    public AutomataCelular() {
        automata=new Elemento[LONGITUD + 2][LONGITUD + 2];
        for (int f=0;f<LONGITUD + 2;f++){
            for (int c=0;c<LONGITUD + 2;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }
    public int  getLongitud(){
        return LONGITUD;
    }
    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }
    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }
    public void algunosElementos(){
        Celula indiana = new Celula(this,1,1);
        Celula _007 = new Celula(this,2,2);
        Izquierdosa test = new Izquierdosa(this,2,1);
        Barrera suroeste = new Barrera(this,1,LONGITUD - 1);
        Barrera noreste = new Barrera(this,LONGITUD - 1,1);
        Celula c1 = new Celula(this,3,2);
        Turnadora guille = new Turnadora(this,5,4);
        Turnadora leo = new Turnadora(this,5,5);
        /*Celula c2 = new Celula(this,3,4);
        
        for (int i = 0; i < automata.length; i++){
            Elemento[] temp = automata[i];
            for (int j = 0; j < temp.length; j++){
                if (temp[j] == null){
                    System.out.print("N ");
                }
                else{
                    if (temp[j] instanceof Izquierdosa){
                        System.out.print("I ");
                    }
                    else{
                        System.out.print("C ");
                    }
                }
            }
            System.out.println();
        }*/
    }
    public void ticTac(){
        System.out.println("Generación #" + age);
        for (int i = 0; i < automata.length; i++){
            Elemento[] temp = automata[i];
            for (int j = 0; j < temp.length; j++){
                if (temp[j] != null){
                    temp[j].setVecinos(evaluaVecinos(i,j));
                    temp[j].decida();
                }
            }
        }
        for (int i = 0; i < automata.length; i++){
            Elemento[] temp = automata[i];
            for (int j = 0; j < temp.length; j++){
                if (temp[j] != null){
                    temp[j].cambie();
                }
            }
        }
        age++;
    }
    private int evaluaVecinos(int row, int column){
        int cont = 0;
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (automata[row + i][column + j] instanceof Celula){
                    if (automata[row + i][column + j].getEstado() == 'v'){
                        if (i == 0 & j == 0){
                            continue;
                        }
                        else{
                            if (automata[row + i][column + j] instanceof Barrera){
                                continue;
                            }
                            else{
                                cont ++;
                            }
                        }
                    }
                }
            }
        }
        return cont;
    }
}
