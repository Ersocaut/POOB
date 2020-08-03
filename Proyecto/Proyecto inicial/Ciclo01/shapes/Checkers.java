import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;
/**
 * la clase Checkers se encarga de realizar el juego de damas chinas, este juego lo divide en dos modos,
 * el modo de juego y el modo de configuracion; en el modo de configuracion debemos crear la parte administrativa y 
 * de manejo del juego y en el modo de juego se debe jugar, se deberan crear dos tableros en los cuales se muestre la configuracion 
 * y por medio de un cambio de tablero lo vere reflejado en el tablero de juego.
 *
 * @author (Guillermo Castro-Leonardo Galeano)
 * @version (version 6)
 */
public class Checkers
{
    // instance variables - replace the example below with your own
    private Tablero table;
    private Tablero game;
    private int pos;
    private int width;
    private Scanner input = new Scanner(System.in);
    private ArrayList<Circle> piecesL;
    private Circle selected;
    private Circle pivot = new Circle();
    private int len = 25;
    private boolean cambio = false;
    private boolean accion = true;
    /**
     * Constructor for objects of class Checkers
     */
    public Checkers(int width)
    {
        this.width = width;
        table = new Tablero(width);
        table.setDesp(0);
        game = new Tablero(width);
        game.setDesp((len * width) + 100);
        selected = new Circle();
        accion=true;
    }
    /**
     * este metodo selecciona la ficha que vas a mover en el tablero, para diferenciarla se vuelve azul y se 
     * deselecciona oprimiendo una casilla vacia o seleccionando otra ficha
     * 
     * @param  row column  recibe como parametros la fila y la columna de la ficha que desea seleccionar
     */
    public void select(int row, int column)
    {
        row--;
        column--;
        String old;
        piecesL = table.getPieces();
        int[][] mat = table.getMatrizPos();
        if (table.matrizPos[row][column]==0){
            if (mat[selected.yPosition/len][selected.xPosition/len] == 1){
                selected.changeColor("white");
            }
            else if(mat[selected.yPosition/len][selected.xPosition/len] == 2){
                selected.changeColor("red");
            }
            accion=true;
            selected = pivot;
            JOptionPane.showMessageDialog(null, "Casilla vacia");
        }
        else if(table.matrizPos[row][column]==1){
            for (int i = 0; i < piecesL.size(); i++){
                if ((table.pieces.get(i).yPosition == (row*len)) && 
                    (table.pieces.get(i).xPosition == (column*len))){        
                    old = (mat[selected.yPosition/len][selected.xPosition/len] == 1)?"white"
                                                                                        :"red";
                     selected.changeColor(old);
                    selected = table.pieces.get(i);
                    selected.changeColor("blue");
                }
            }
            accion=true;
        }
        else if(table.matrizPos[row][column]==2){
            for (int i = 0; i < piecesL.size(); i++){
                if ((piecesL.get(i).yPosition == (row*len)) && 
                    (piecesL.get(i).xPosition == (column*len))){
                     old = (mat[selected.yPosition/len][selected.xPosition/len] == 1)?"white"
                                                                                        :"red";
                     selected.changeColor(old);
                     selected = table.pieces.get(i);
                     selected.changeColor("blue");
                }
            }
            accion=true;
        }
        else{
            if (!selected.equals(pivot)){
                if (mat[selected.yPosition/len][selected.xPosition/len] == 1){
                    selected.changeColor("white");
                }
                else if(mat[selected.yPosition/len][selected.xPosition/len] == 2){
                    selected.changeColor("red");
                }
                selected = pivot;
            }
            JOptionPane.showMessageDialog(null, "Casilla invalida");
            accion=true;
        }
    }
    /**
     * este metodo mueve la ficha seleccionada en el tablero de configuracion 
     * 
     * @param  top right recibe de parametros dos boleanos los cuales se usaran para mover la ficha en el 
     * tablero de configuracion.
     */
    public void shift(boolean top, boolean right)
    {
       int[][] mat = table.getMatrizPos();
       if (!selected.equals(pivot)){
           if (top & selected.yPosition != 0){
               if (right & selected.xPosition != (width*(len-1))){
                   mat[selected.yPosition/len][selected.xPosition/len] = 0;
                   selected.moveVertical(-len);
                   selected.moveHorizontal(len);
                   mat[selected.yPosition/len][selected.xPosition/len] = (selected.color == "red")  ?2
                                                                                                    :1;
                   accion=true;                                                                                 
                }
                else if (!right & selected.xPosition != 0){
                   mat[selected.yPosition/len][selected.xPosition/len] = 0;
                   selected.moveVertical(-len);
                   selected.moveHorizontal(-len);
                   mat[selected.yPosition/len][selected.xPosition/len] = (selected.color == "red")  ?2
                                                                                                    :1;
                   accion=true;                                                                                 
               }
           }
           else if (!top & selected.yPosition != (width * (len-1))){
               if (right & selected.xPosition != (width * (len-1))){
                   mat[selected.yPosition/len][selected.xPosition/len] = 0;
                   selected.moveVertical(len);
                   selected.moveHorizontal(len);
                   mat[selected.yPosition/len][selected.xPosition/len] = (selected.color == "red")  ?2
                                                                                                    :1;
                   accion=true;                                                                                 
                }
                else if (!right & selected.xPosition != 0){
                   mat[selected.yPosition/len][selected.xPosition/len] = 0;
                   selected.moveVertical(len);
                   selected.moveHorizontal(-len);
                   mat[selected.yPosition/len][selected.xPosition/len] = (selected.color == "red")  ?2
                                                                                                    :1;
                   accion=true;                                  
                                                                                                          
               }
           }
       }   
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method 
     */
    public void jump(boolean top, boolean right)
    {
        
    }
    /**
     * los movimientos se definen con la nomenclatura de "left" o "right"
     * (1) corona arriba
     * (2) corona abajo
     * 
     * @param  notation   a sample parameter for a method
     */
    public void move( String notation){
        notation = notation.toLowerCase();
        int[][] mat = table.getMatrizPos();
        int x = selected.xPosition/25;
        int y = selected.yPosition/25;
        if (mat[y][x] == 1){
            if (notation == "left"){
                if (!(y == 0 | x == 0)){
                    mat[y][x] = 0;
                    selected.moveVertical(-len);
                    selected.moveHorizontal(-len);
                    selected.changeColor("white");
                    mat[y-1][x-1] = 1;
                    selected = pivot;
                }
            }
            else if (notation == "right"){
                if (!(y == 0 | x == ( len * (width - 1)))){
                    mat[y][x] = 0;
                    selected.moveVertical(-len);
                    selected.moveHorizontal(len);
                    selected.changeColor("white");
                    mat[y-1][x+1] = 1;                    
                    selected= pivot;
                }
            }
        }
        else if (mat[y][x] == 2){
            if (notation == "left"){
                if (!(y == (len * (width - 1)) | (x == 0)) ){
                    mat[y][x] = 0;
                    selected.moveVertical(len);
                    selected.moveHorizontal(-len);
                    selected.changeColor("red");
                    mat[y+1][x-1] = 2;
                    selected = pivot;
                }
            }
            else if(notation == "right"){
                if (!(y == (len * (width - 1)) | x == (len * (width - 1)))){
                    mat[y][x] = 0;
                    selected.moveVertical(len);
                    selected.moveHorizontal(len);
                    selected.changeColor("red");
                    mat[y+1][x+1] = 2;
                    selected = pivot;
                }
            }
        }
    }
    /**
     * Evalua que la casilla indicada en la matriz sea una posición valida para la ficha que
     * se desea agregar
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla a evaluar, en formato de matriz
     * 
     * @return Booleano indicando el valor de verdad de la posibilidad de agregar una ficha 
     * en la posición deseada
     */
        private boolean eval (int[][] pos){
        int i = pos[0][0];
        int j = pos[1][0];
        int[][] matriz = table.getMatrizPos();
        if (matriz[i][j] == -1){
            JOptionPane.showMessageDialog(null, "Casilla invalida");
            accion=true;
            return false;
        }
        else if (matriz[i][j] == 0){
            accion=true;
            return true;
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Se sobrepone a una ficha ya creada");
            accion=true;
            return false;
            
        }
    }
    /**
     * Se agrega una ficha al tablero, el usuario debe indicar si es o no un rey 
     * con un booleano
     *
     * @param  king,row,column  recibe el booleano que indica si es rey o no y los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha
     */
    public void add(boolean king,int row, int column){
        int[][] men = new int[2][1];
        men[0][0]= row - 1;
        men[1][0] = column - 1;
        add(men);
        if (king){
            ArrayList<Circle> pK = table.getPieces();
            pK.get(pK.size() - 1).king = true;
            
        }
        accion=true;
    }
    /**
     * Se agrega una ficha al tablero, el usurario debe indicar a qué equipo corresponde
     * la ficha correspondiente
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha, en formato de matriz
     */
    public void add(int[][] men){
        if (eval(men)){
            String teamColor;
            int team = input.nextInt();
            if ( team == 1){
                teamColor = "white";
                accion=true;
            }
            else{
                teamColor = "red";
                accion=true;
            }
            table.addPiece(men, teamColor);
        }
    
    }
    /**
     * Se remueve una ficha al tablero, el usurario debe indicarla fila y la columna de la ficha
     * correspondiente
     * 
     * @param  row column recibe como parametros la fila y la columna de la ficha que desea retirar
     */
    public void removeP(int row, int column)
    {
       //piecesL = table.getPieces();
       int K = ((row-1)*len);
       int M = ((column-1)*len);
       for (int i = 0; i < table.pieces.size(); i++){
           //System.out.println(table.pieces.get(i).yPosition + "  " + K);
           //System.out.println(table.pieces.get(i).xPosition + "  " + M);
           if ((table.pieces.get(i).xPosition == M) &
           (table.pieces.get(i).yPosition == K)){
               //System.out.println("D:");
               table.pieces.get(i).makeInvisible();
               table.pieces.remove(i);
               table.matrizPos[row-1][column-1] = 0;
           }
       }
       accion=true;
    }
    /**
     * Se remueve una ficha al tablero
     * 
     * @param int[][] piece recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea  removerla ficha, en formato de matriz
     */
    public void remove(int[][] piece)
    {
        removeP(piece[0][0],piece[1][0]);
        accion=true;
    }
    /**
     * este metodo hace visible en el tablero de juego lo que esta modificandose en el tablero de configuracion, y lo desaparece.
     * 
     */
    public void swap(){
        if (!cambio){
            for (int i = 0; i < table.matrizPos.length; i++){
                for (int j = 0; j < table.matrizPos.length; j++){
                    if (table.matrizPos[i][j] == 1){
                        Circle nPiece = new Circle();
                        nPiece.changeColor("white");
                        nPiece.changeSize(24);
                        nPiece.moveHorizontal(25*j + game.desp);
                        nPiece.moveVertical(25*i);
                        game.pieces.add(nPiece);
                    }
                    else if(table.matrizPos[i][j] == 2){
                        Circle nPiece = new Circle();
                        nPiece.changeColor("red");
                        nPiece.changeSize(24);
                        nPiece.moveHorizontal(25*j + game.desp);
                        nPiece.moveVertical(25*i);
                        game.pieces.add(nPiece);
                    }
                }
            }
            game.makeVisible();
        }
        else{
            game.makeInvisible();
            game.pieces.clear();
        }
        cambio = !cambio;
    }
    
    /**
     * Hace visible todas las fichas en el tablero.
     */
    
    public void makeVisible()
    {
       for (int i = 0; i < table.pieces.size(); i++){
            table.makeVisible(i);
       }
       accion=true;
    }
    
     /**
     * Hace invisible todas las fichas en el tablero.
     */
    
    public void makeInvisible()
    {
       for (int i = 0; i < table.pieces.size(); i++){
            table.makeInvisible(i);
       }
       accion=true;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     */
    public void finish()
    {
        
    }
    /** 
    * Retorna si la ultima operación/acción realizada por en la ciudad fue hecha satisfactoriamente o no.
    */
    public boolean ok(){
            return accion;
    }
    
}