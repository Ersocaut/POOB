import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
* La clase tablero nos ayuda a crear el tablero de ajedrez en el cual jugaremos damas chinas; Se deberan crear dos tableros,el de 
* juego y el de configuración. 
*
* @author (Guillermo Castro-Leonardo Galeano)
 * @version (version 10)
 */
public class Tablero
{
    
    // instance variables - replace the example below with your own
    private int width;
    public int desp;
    public int[][] matrizPos;
    
    private Rectangle back;
    private ArrayList<Rectangle> casillas = new ArrayList();

    public Piece[][] pieces;
    public Rectangle block;
    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int width)
    {
        this.width = width;
        pieces = new Piece[width][width];
        matrizPos = new int[width][width];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++){
                if (((j + i) % 2) == 0){
                    matrizPos[i][j] = -1;
                }
                pieces[i][j] = null;
            }
        }
    }
    
    /**
     * este metodo lo usamos para modificar desp que es el desplazamiento entre los tableros
     * 
     * @param  nDesp es un numero int que desplaza el tablero
     */
    public void setDesp(int nDesp){
        desp = nDesp;
        crea();
    }
    /**
     * este metodo lo usamos para llenar la matriz pieces de null.
     */
    public void setNull(){
        for (int i = 0; i < pieces.length; i++){
            for (int j = 0; j < pieces.length; j++){
                pieces[i][j] = null;
            }
        }
    }
    /**
     * este metodo lo usamos para obtener el arraylist pieces
     * 
     * @return     pieces un arraylist de tipo circle
     */
    public Piece[][] getPieces(){
        return pieces;
    }
    /**
     * este metodo se encarga de crear los tablero de damas chinas, en este metodo se crean los dos tableros solicitados.
     * 
     */
    private void crea(){
        for (int i = 0; i < width; i++){
            for ( int j = 0; j < width/2; j++){
                block = new Rectangle();
                if ((i%2) == 0){
                    block.moveHorizontal(25);
                }
                block.changeColor("black");
                block.changeSize(25,25);
                block.moveVertical(25*i);
                block.moveHorizontal((50*j) + desp);
                block.makeVisible();
                casillas.add(block);
            }
        }
    }
    /**
     * agrega la ficha en la posicion deseada en el tablero ya creado 
     * 
     * @param  [][]men  teamColor  men es una matriz de enteros la cual recibe las fichas que desea agregar en el tablero 
     * y recibe el color del equipo con el cual jugara.  
     */
    public void addPiece(int[][] men, int team, boolean k){
        int i = men[0][0];
        int j = men[1][0];
        Piece piece = new Piece(k,team);
        piece.changeSize(24);
        piece.moveHorizontal(25*j);
        piece.moveVertical(25*i);
        pieces[i][j] = piece;
    }
    /**
     * Hace visible todas las fichas en el tablero.  
     * 
     */
    public void makeVisible(){
        for (int i = 0; i < pieces.length; i++){
            for (int j = 0; j < pieces.length; j++){
                if (!(pieces[i][j] == null)){
                    pieces[i][j].makeVisible();
                }
            }
        }
    }
    /**
     * Hace invisible todas las fichas en el tablero.
     */
    public void makeInvisible(){
        for (int i = 0; i < pieces.length; i++){
            for (int j = 0; j < pieces.length; j++){
                if(!(pieces[i][j] == null)){
                    pieces[i][j].makeInvisible();
                }
            }
        }
    }
    /**
     * este metodo lo usamos para obtener el matriz matrizPos
     * 
     * @return  matrizPos   pieces una matriz de tipo entero
     */
    public int[][] getMatrizPos(){
        return matrizPos;
    }
    /**
     * este metodo lo usamos para obtener el arraylist casillas
     * 
     * @return     casillas un arraylist de tipo Rectangle
     */
    public ArrayList<Rectangle> getCasillas(){
        return casillas;
    }
}
