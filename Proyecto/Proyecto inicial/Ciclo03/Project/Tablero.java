import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;
/**
* La clase tablero nos ayuda a crear el tablero de ajedrez en el cual jugaremos damas chinas; Se deberan crear dos tableros,el de 
* juego y el de configuración. 
*
* @author (Guillermo Castro-Leonardo Galeano)
* @version (version 10)
*/
public class Tablero
{
    private int width;
    public int desp;
    public int[][] matrizPos;
    private int rowSelected = -1;
    private int columnSelected = -1;
    private int len = 25;

    public Piece[][] pieces;
    private Piece selected;
    private Piece pivot = new Pawn(false, -1);
    
    private Scanner input = new Scanner(System.in);
    
    private Rectangle back;
    public Rectangle block;
    private Rectangle[][] casillas;
    
    private HashMap<String,int[]> indexes = new HashMap<String, int[]>();
    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int width)
    {
        this.width = width;
        selected = pivot;
        pieces = new Piece[width][width];
        matrizPos = new int[width][width];
        int cont = 1;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++){
                if (((j + i) % 2) == 0){
                    matrizPos[i][j] = -1;
                }
                else{
                    pieces[i][j] = null;
                    indexes.put(new String().valueOf(cont),new int[] {i,j});
                    cont++;
                }
            }
        }
    }
    public void selectDefault(){
        selected.recoverColor();
        selected = pivot;
        rowSelected = -1;
        columnSelected = -1;
    }
    public void select(int row, int column){
        if (row < 0 || column < 0 || row >= width || column >= width){
            rowSelected = -1;
            columnSelected = -1;
            selected.recoverColor();
            selectDefault();
            JOptionPane.showMessageDialog(null, "Posicion invalida");
        }else if (pieces[row][column] == null){
            rowSelected = -1;
            columnSelected = -1;
            selected.recoverColor();
            selectDefault();
            JOptionPane.showMessageDialog(null, "Casilla vacia");
        }else{
            rowSelected = row;
            columnSelected = column;
            selected.recoverColor();
            selected = pieces[row][column];
            selected.changeColor("blue");
        }
    }
    public void shift(boolean top, boolean right){
                if (!selected.equals(pivot)){
            if (rowSelected != 0 & top){
                if (columnSelected != 0 & !right){
                    moveAll(-1,-1,pieces);
                }
                else if (columnSelected != width & right){
                    moveAll(-1,1,pieces);
                }
            }
            else if(rowSelected != width & !top){
                if (columnSelected != 0 & !right){
                    moveAll(1,-1,pieces);
                }
                else if (columnSelected != width & right){
                    moveAll(1,1,pieces);
                }
            }
            selectDefault();
        }

    }
        /**
     * se mueve todas las fichas que se encuentran seleccionadas
     *@param  mRow   numero de fila la cual va a mover
     *@param  mColumn numero de columna la cal va a mover
     *@param  mat la matriz de piezas la cual movera
     */
    private void moveAll(int mRow, int mColumn, Piece[][] mat){
        if (!(selected.equals(pivot))){
            selected.move(len * mRow, len * mColumn);
            Piece change = mat[rowSelected][columnSelected];
            mat[rowSelected][columnSelected] = null;
            mat[rowSelected + mRow][columnSelected + mColumn] = change;
            selectDefault();
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
            for ( int j = 0; j < width; j++){
                block = new Rectangle();
                if((i+j) % 2 == 0){
                    block.changeColor("black");
                }
                else{
                    block.changeColor("red");
                }
                block.changeSize(25,25);
                block.moveVertical(25*i);
                block.moveHorizontal((25*j) + desp);
                block.makeVisible();
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
        Piece piece;
        if (k){
            piece = new King(k,team);
        }
        else{
            piece = new Pawn(k,team);
        }
        piece.changeSize(24);
        piece.moveHorizontal(25*j);
        piece.moveVertical(25*i);
        piece.makeVisible();
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
    public void move (String notation){
        boolean isStandard = notation.contains("-");
        String[] indexMove = (isStandard)? notation.split("-") : notation.split("x");
        int[][] realCoord = new int[indexMove.length][2];
        for (int i  = 0; i < indexMove.length; i++){
            realCoord[i] = indexes.get(String.valueOf(indexMove[i]));
        }
        for (int i = 1; i < realCoord.length; i++){
            int[] ward = realCoord[i-1];
            int[] want = realCoord[i];
            select(ward[0], ward[1]);
            if (evalPos(want[0], want[1])){
                moveAll(want[0]-ward[0], want[1]-ward[1], pieces);
            }
            else{
                JOptionPane.showMessageDialog(null, "Move no valido");
                selectDefault();
                break;
            }
        }
    }
    private boolean evalPos(int row, int column){
        return pieces[row][column] == null;
    }
    public void jump(boolean top, boolean right){
        int row = (top) ? -2 : 2;
        int column = (right) ? 2 : -2;
        int rowE = (top) ? rowSelected -1 :rowSelected + 1;
        int columnE = (right) ?columnSelected + 1 : columnSelected - 1;
        if(!(rowSelected < 2 & top || columnSelected > width - 2 & right || (rowSelected > width - 2) & !top || columnSelected < 2 & !right)){
            if (!(evalPos(rowE,columnE) | evalPos((rowSelected + row),(columnSelected + column)) | 
            pieces[rowE][columnE].team == selected.team| pieces[rowSelected + row][columnSelected + column].team == selected.team))
            {
                pieces[rowE][columnE].makeInvisible();
                pieces[rowE][columnE] = null;
                moveAll(row,column,pieces);
            }
        }
    }
    private boolean eval(int i, int j){
        if (i < 0 | j < 0 | i >= pieces.length | j >= pieces.length ){
            JOptionPane.showMessageDialog(null, "Casilla invalida");
            return false;
        }
        else if (pieces[i][j] == null){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Casilla invalida");
            return false;
        }
    }
    public void add(int[][] men, boolean king){
        if (eval(men[0][0],men[1][0])){
            String teamColor;
            int team = input.nextInt();
            addPiece(men, team, king);
        }
    }
    public void remove (int row, int column){
        if (!(pieces[row][column] == null)){
            pieces[row][column].makeInvisible();
            pieces[row][column] = null;
        }
    }
}
