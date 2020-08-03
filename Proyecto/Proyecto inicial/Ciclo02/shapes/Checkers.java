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
 * @version (version 15)
 */
public class Checkers
{
    // instance variables - replace the example below with your own
    private boolean cambio = false;
    private boolean accion = true;

    private int len = 25;
    private int pos;
    private int width;
    private int rowSelected = -1;
    private int columnSelected = -1;
    private int con1;
    private int con2;

    private Scanner input = new Scanner(System.in);

    private Piece[][] piecesL;
    private Piece selected;
    private Piece pivot = new Piece(false, -1);

    private Tablero table;
    private Tablero game;
    private boolean king;

    private HashMap<String, String> saved = new HashMap<String,String>();

    /**
     * Constructor for objects of class Checkers
     */
    public Checkers(int width)
    {
        if ((width%2)==0){ 
            this.width = width;
            table = new Tablero(width);
            table.setDesp(0);
            game = new Tablero(width);
            game.setDesp((len * width) + 100);
            selected = pivot;
            accion=true;
        }
        else{
            JOptionPane.showMessageDialog(null, "no se pueden crear tableros impares");
        }
    }
    /**
     * este metodo lo usamos para deseleccionar la ficha .
     */
    private void selectDefault(){
        selected.recoverColor();
        selected = pivot;
        rowSelected = -1;
        columnSelected = -1;
    }

    /**
     * este metodo selecciona la ficha que vas a mover en el tablero, para diferenciarla se vuelve azul y se 
     * deselecciona oprimiendo una casilla vacia o seleccionando otra ficha
     * @param  row  recibe como parametro la fila  de la ficha que desea seleccionar
     * @param  column  recibe como parametro la columna de la ficha que desea seleccionar
     */
    public void select(int row, int column)
    {
        row--; column--;
        if (cambio){
            piecesL = game.getPieces();
            int[][] mat = game.getMatrizPos();
        }else{
            piecesL = table.getPieces();
            int[][] mat = table.getMatrizPos();
        }if (row < 0 || column < 0 || row >= width || column >= width){
            rowSelected = -1;
            columnSelected = -1;
            selected.recoverColor();
            selectDefault();
            JOptionPane.showMessageDialog(null, "Posicion invalida");
        }else if (piecesL[row][column] == null){
            rowSelected = -1;
            columnSelected = -1;
            selected.recoverColor();
            accion=true;
            selectDefault();
            JOptionPane.showMessageDialog(null, "Casilla vacia");
        }else{
            rowSelected = row;
            columnSelected = column;
            selected.recoverColor();
            selected = piecesL[row][column];
            selected.changeColor("blue");
            accion=true;}
    }
    /**
     * este metodo mueve la ficha seleccionada en el tablero de configuracion 
     * 
     * @param  up  lo que debe moverse verticalmente.
     * @param side lo que debe moverse horizontalmente.
     */
    private void mueveConfig(int up, int side){
        selected.moveHorizontal(side);
        selected.moveVertical(up);
    }

    /**
     * este metodo mueve la ficha seleccionada en el tablero de configuracion 
     * 
     * @param  top  recibe de parametros un boleanos los cuales se usaran para mover la ficha en el tablero de configuracion.
     * @param right recibe de parametros un boleanos los cuales se usaran para mover la ficha en el tablero de configuracion.
     */
    public void shift(boolean top, boolean right)
    {
        Piece[][] mat = table.getPieces();
        if (!selected.equals(pivot)){
            if (rowSelected != 0 & top){
                if (columnSelected != 0 & !right){
                    moveAll(-1,-1,mat);
                }
                else if (columnSelected != width & right){
                    moveAll(-1,1,mat);
                }
            }
            else if(rowSelected != width & !top){
                if (columnSelected != 0 & !right){
                    moveAll(1,-1,mat);
                }
                else if (columnSelected != width & right){
                    moveAll(1,1,mat);
                }
            }
            selectDefault();
        }
    }
    /**
     * Evalua el jump y retorna un booleano
     *
     * @return Booleano indicando el valor de verdad de el jump
     */
    private boolean evalJump(){
        return false;
    }

    /**
     * salta con la ficha seleccionada si puede y come a las fichas enemigas
     * @param  top es un valor de verdad el cual indica para arriba si es true o para abajo si es false
     * @param  right es un valor de verdad el cual indica para la derecha si es true o para la izquierda si es false
     */
    public void jump(boolean top, boolean right)
    {
        piecesL = (cambio) ?game.getPieces() : table.getPieces();
        int row = (top) ? -2 : 2;
        int column = (right) ? 2 : -2;
        int rowE = (top) ? -1 : 1;
        int columnE = (right) ? 1 : -1;
        if(rowSelected < 3 & top || columnSelected > width - 2 & right || (rowSelected > width - 2) & !top || columnSelected < 3 & !right){
            JOptionPane.showMessageDialog(null, "Jump no valido");
        }
        else if (piecesL[rowE][columnE].team == selected.team){
            JOptionPane.showMessageDialog(null, "Jump no valido");
        }
        else{
            moveAll(row,column,piecesL);
        }
    }
    /**
     * este metodo mueve la ficha seleccionada en el tablero de juego 
     * 
     * @param  up  lo que debe moverse verticalmente.
     * @param side lo que debe moverse horizontalmente.
     */
    private void mueveGame(int up, int side){
        selected.moveHorizontal(side);
        selected.moveVertical(up);
    }

    /**
     * los movimientos se definen con la nomenclatura de "left" o "right"(1) corona arriba(2) corona abajo
     * @param  notation   a sample parameter for a method
     */
    public void move( String notation){
        notation = notation.toLowerCase();
        Piece[][] mat = game.getPieces();
        if (mat[rowSelected][columnSelected].team == 1){
            if (notation == "left"){
                if (!(rowSelected == 0 | columnSelected == 0)){
                    moveAll(-1,-1,mat);
                }
            }
            else if (notation == "right"){
                if (!(rowSelected == 0 | rowSelected == width - 1)){
                    moveAll(-1,1,mat);
                }
            }
        }else if (mat[rowSelected][columnSelected].team == 2){
            if (notation == "left"){
                if (!(rowSelected == width - 1) | (columnSelected == 0)){
                    moveAll(1,-1,mat);
                }
            }else if(notation == "right"){
                if (!(rowSelected == width - 1 | columnSelected == width - 1)){
                    moveAll(1,1,mat);
                }
            }
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
            if (cambio){
                mueveGame(len * mRow, len * mColumn);
            }
            else{
                mueveConfig(len * mRow, len * mColumn);
            }
            Piece change = mat[rowSelected][columnSelected];
            mat[rowSelected][columnSelected] = null;
            mat[rowSelected + mRow][columnSelected + mColumn] = change;
            selectDefault();
        }
    }

    /**
     * Evalua que la casilla indicada en la matriz sea una posición valida para la ficha que se desea agregar
     * @param int[][] pos recibe los indices de fila y columna respectivamente de la casilla a evaluar, en formato de matriz
     * @return Booleano indicando el valor de verdad de la posibilidad de agregar una ficha en la posición deseada
     */
    private boolean eval (int[][] pos){
        int i = pos[0][0];
        int j = pos[1][0];
        if (cambio){
            piecesL = game.getPieces();
            int[][] matriz = game.getMatrizPos();
        }else{
            piecesL = table.getPieces();
            int[][] matriz = table.getMatrizPos();
        }
        int[][] matriz = table.getMatrizPos();
        if (matriz[i][j] == -1){
            JOptionPane.showMessageDialog(null, "Casilla invalida");
            accion=true;
            return false;
        }else if (matriz[i][j] == 0){
            accion=true;
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Se sobrepone a una ficha ya creada");
            accion=true;
            return false;
        }
    }

    /**
     * Se agrega una ficha al tablero, el usuario debe indicar si es o no un rey 
     * con un booleano
     *
     * @param  king,row,column  recibe el booleano que indica si es rey o no 
     * @param row  recibe el indice de fila respectivamente de la casilla en donde se desea colocar la ficha
     * @param column  recibe el indice de columna respectivamente de la casilla en donde se desea colocar la ficha
     */
    public void add(boolean king,int row, int column){
        int[][] men = new int[2][1];
        men[0][0]= row - 1;
        men[1][0] = column - 1;
        this.king=king;
        add(men);
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
            table.addPiece(men, team, king);
        }
    }

    /**
     * Se remueve una ficha al tablero, el usurario debe indicarla fila y la columna de la ficha
     * correspondiente
     * @param row recibe como parametro la fila de la ficha que desea retirar.
     * @param column recibe como parametro la columna de la ficha que desea retirar.
     */
    public void removeP(int row, int column)
    {
        piecesL = table.getPieces();
        row--; column--;
        if (!(piecesL[row][column] == null)){
            piecesL[row][column].makeInvisible();
            piecesL[row][column] = null;
        }
        accion=true;
    }

    /**
     * Se remueve una ficha al tablero
     * 
     * @param int[][] piece recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea  removerla ficha, en formato de matriz.
     */
    public void remove(int[][] piece)
    {
        for (int i = 0; i < piece.length; i++){
            for (int j = 0; j < piece[0].length; j++){
                removeP(piece[0][0],piece[1][0]);
            }
        }
        accion=true;
    }

    /**
     * este metodo hace visible en el tablero de juego lo que esta modificandose en el tablero de configuracion, y lo desaparece.
     * 
     */
    public void swap(){
        if (!cambio){
            for (int i = 0; i < table.pieces.length; i++){
                for (int j = 0; j < table.pieces.length; j++){
                    if (!(table.pieces[i][j] == null)){
                        boolean k = table.pieces[i][j].getIsKing();
                        game.pieces[i][j] = new Piece(k,table.pieces[i][j].team);
                        game.pieces[i][j].setPos(game.desp + (len * j),len * i);
                        game.pieces[i][j].changeSize(24);
                        game.pieces[i][j].makeVisible();
                    }
                }
            }
            game.makeVisible();
        }
        else{
            game.makeInvisible();
            game.setNull();
        }
        cambio = !cambio;
    }

    /**
     * se lee el string que da la arena para graficarla en el tablero de configuracion
     * @param checkerboard String en el que se recibe con salto de linea las lineas de n*n a ingresar
     */
    public void read(String checkerboard){
        String[] checkerboardTable=checkerboard.split("\n");
        int [][]pieza;
        for (int i = 0; i < checkerboardTable.length; i++){
            for (int j = 0; j < checkerboardTable.length; j++){
                if(checkerboardTable[i].charAt(j)=='B'){
                    table.addPiece(pieza=new int[][]{{i},{j}},2,true);
                }
                else if(checkerboardTable[i].charAt(j)=='W'){
                    table.addPiece(pieza=new int[][]{{i},{j}},1,true);
                }
                else if(checkerboardTable[i].charAt(j)=='b'){
                    table.addPiece(pieza=new int[][]{{i},{j}},2,false);
                }
                else if(checkerboardTable[i].charAt(j)=='w'){
                    table.addPiece(pieza=new int[][]{{i},{j}},1,false);
                }
                else{
                    continue;
                }
            }
        }  
    }

    /**
     * Se convierte el tablero de configuracion en el string que recibe la arena. 
     * @return  String   la cadena de caracteres que describe el tablero como en la arena
     */
    public String write(){
        String checkerboard="";
        for (int i = 0; i < table.pieces.length; i++){
            for (int j = 0; j < table.pieces[0].length; j++){
                Piece piezaEvaluada = table.pieces[i][j];
                if (table.pieces[i][j]== null & (i+j)%2 == 1){
                    checkerboard=checkerboard+".";
                }else if (table.pieces[i][j]!= null&&king==true&&piezaEvaluada.team==2){
                    checkerboard=checkerboard+"B";
                }else if (table.pieces[i][j]!= null&&king==false&&piezaEvaluada.team==2){
                    checkerboard=checkerboard+"b";
                }else if (table.pieces[i][j]!= null&&king==true&&piezaEvaluada.team==1){
                    checkerboard=checkerboard+"W";
                }else if (table.pieces[i][j]!= null&&king==false&&piezaEvaluada.team==1){
                    checkerboard=checkerboard+"w";
                }else{
                    checkerboard=checkerboard+"-"; 
                }
            }
            checkerboard=checkerboard+"\n";
        }
        System.out.println(checkerboard);
        return checkerboard;
    }
    /**
     * Se convierte el tablero de configuracion en el string que recibe la arena. 
     * @param isKingTable es un booleano el cual indica el rey o la reina que manda e usuario
     * @return  int   el numero al cual se le asiganara el valor de False o True
     */
    private int isKingNumero(boolean isKingTable){
        if (isKingTable == true){
            return 1;
        }
        else{
            return 0;
        }
    }
    /**
     * encuentra la longitud del arreglo fichas en el tablero. 
     * @param table Tablero en el que se quiere ver las fichas guardadas
     * @return  int[] retorna el valor de las longitudes de los arreglos de fichas de diferente equipo 
     */
    private int[] sizeFichas(Tablero table){
        con1=0;
        con2=0;
        int i=0;
        int j=0;
        int[] contadores = new int[2];
        while(i <table.pieces.length){
            while(j <table.pieces[0].length){
                if (table.pieces[i][j]!= null&&table.pieces[i][j].team== 1){
                    con1++;
                }else if(table.pieces[i][j]!= null &&table.pieces[i][j].team== 2){
                    con2++;
                }else{
                    continue;
                }
                j++;
            }
            i++;
        }
        contadores[0]=con1;
        contadores[1]=con2;
        return contadores;
    }

    /**Guarda en el HashMap el tablero en el que se esté, guarda el de juego si está en game
     * @param name, llave con la que se guardará el tablero en el hashmap
     */
    public void save(String name){
        String tableWrite = write();
        saved.put(name,tableWrite);
    }

    /**busca el tablero guardado en el HashMap en el que se esté, lo deja ver el tablero de juego si está en game
     * @param name llave con la que se busca el tablero guardado en el hashmap
     */
    public String recover(String name){
        if (cambio){
            JOptionPane.showMessageDialog(null, "No se puede recuperar un tablero en mitad de un juego");
        }
        else{
            table.makeInvisible();
            String readTable = saved.get(name);
            read(readTable);
        }
        return write();
    }

    /**
     * consulta los valores de dos vectores: el primero con la información del tablero 
     * de juego y el segundo con el de configuración
     * @return  int[][][] retorna una lista de matrices la cual contiene la informacion de la ficha
     */

    public int [][][] consult()
    {
        int [][][] consulta= new int[2][sizeFichas(table)[0]+sizeFichas(table)[1]][3];
        for (int i=0;i<table.pieces.length;i++){
            for (int j=0;j<table.pieces.length;j++){
                Piece piezaEvaluada = table.pieces[i][j];
                if (table.pieces[i][j]!= null){
                    if (piezaEvaluada.team==1){
                        for(int z=0;z<sizeFichas(table)[0];z++){
                            int rowTable= i;
                            int columnTable= j;
                            boolean isKingTable=piezaEvaluada.isKing; 
                            consulta[0][z][0]=isKingNumero(isKingTable);
                            consulta[0][z][1]=rowTable;
                            consulta[0][z][2]=columnTable;
                        }
                    }
                    else if (piezaEvaluada.team==2){
                        for(int p=0;p<sizeFichas(table)[1];p++){
                            int rowTable= i;
                            int columnTable= j;
                            boolean isKingTable=piezaEvaluada.isKing; 
                            consulta[0][p][0]=isKingNumero(isKingTable);
                            consulta[0][p][1]=rowTable;
                            consulta[0][p][2]=columnTable;
                        }
                    }
                    else{
                        accion=true;
                    }
                }
                else if (game.pieces[i][j]!= null){
                    Piece piezaEvaluada2 = game.pieces[i][j];
                    if (piezaEvaluada2.team==1){
                        for(int z=0;z<sizeFichas(table)[0];z++){
                            int rowGame= i;
                            int columnGame= j;
                            boolean isKingTable=piezaEvaluada2.isKing;
                            consulta[1][z][0]=isKingNumero(isKingTable);
                            consulta[1][z][2]=columnGame;
                        }
                    }
                    else if (piezaEvaluada2.team==2){
                        for(int p=0;p<sizeFichas(table)[1];p++){
                            int rowGame= i;
                            int columnGame= j;
                            boolean isKingGame=piezaEvaluada2.isKing; 
                            int teamGame=piezaEvaluada2.team;
                            consulta[1][p][0]=isKingNumero(isKingGame);
                            consulta[1][p][1]=rowGame;
                            consulta[1][p][2]=columnGame;
                        }
                    }
                    else{
                        accion=true;
                    }
                }
                else{
                    accion=true;
                }
            }
        }
        return consulta;
    }

    /**
     * Hace visible todas las fichas en el tablero.
     */

    public void makeVisible()
    {
        if (cambio){
            game.makeVisible();
            accion=true;
        }
        else {
            table.makeVisible();
            accion = true;
        }
    }

    /**
     * Hace invisible todas las fichas en el tablero.
     */

    public void makeInvisible()
    {
        if (cambio){
            game.makeInvisible();
            accion=true;
        }
        else {
            table.makeInvisible();
            accion = true;
        }
    }

    /**
     * Este metodo finaliza el programa y todo lo creado en el 
     * 
     */
    public void finish()
    {
        System.exit(0);
    }

    /** 
     * Retorna si la ultima operación/acción realizada por en la ciudad fue hecha satisfactoriamente o no.
     * @return  boolena   ultima accion guardada
     */
    public boolean ok(){
        return accion;
    }

}