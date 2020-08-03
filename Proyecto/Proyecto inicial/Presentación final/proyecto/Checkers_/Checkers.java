package Checkers_;
import Shapes.*;
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
    private boolean cambio = false;
    private boolean accion = true;

    private int len = 25;
    private int pos;
    private int width;

    private int con1;
    private int con2;

    protected Tablero table;
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
        if (cambio){
            game.selectDefault();
        }
        else{
            table.selectDefault();
        }
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
            game.select(row,column);
        }else{
            table.select(row,column);
        }
    }
    /**
     * este metodo mueve la ficha seleccionada en el tablero de configuracion 
     * 
     * @param  top  recibe de parametros un boleanos los cuales se usaran para mover la ficha en el tablero de configuracion.
     * @param right recibe de parametCheckerros un boleanos los cuales se usaran para mover la ficha en el tablero de configuracion.
     */
    public void shift(boolean top, boolean right)
    {
        table.shift(top,right);
    }    
    /**
     * salta con la ficha seleccionada si puede y come a las fichas enemigas
     * @param  top es un valor de verdad el cual indica para arriba si es true o para abajo si es false
     * @param  right es un valor de verdad el cual indica para la derecha si es true o para la izquierda si es false
     */
    public void jump(boolean top, boolean right)
    {
        game.jump(top,right);
    }
    /**
     * los movimientos se definen con la nomenclatura de "left" o "right"(1) corona arriba(2) corona abajo
     * @param  notation   a sample parameter for a method
     */
    public void move( String notation){
        game.move(notation);
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
     * Se agrega una ficha al tablero, el usuario debe indicar si es o no un rey 
     * con un booleano
     *
     * @param  king,row,column  recibe el booleano que indica si es rey o no 
     * @param row  recibe el indice de fila respectivamente de la casilla en donde se desea colocar la ficha
     * @param column  recibe el indice de columna respectivamente de la casilla en donde se desea colocar la ficha
     */
    public void addProle(boolean king, int row, int column){
        int[][] prol = new int[2][1];
        prol[0][0] = row - 1;
        prol[1][0] = column - 1;
        this.king = false;
        addPProle(prol);
    }
    /**
     * Se agrega una ficha al tablero, el usurario debe indicar a qué equipo corresponde
     * la ficha correspondiente
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha, en formato de matriz
     */
    private void addPProle(int[][] prol){
        table.addPProle(prol,king);
    }
    /**
     * Se agrega una ficha al tablero, el usuario debe indicar si es o no un rey 
     * con un booleano
     *
     * @param  king,row,column  recibe el booleano que indica si es rey o no 
     * @param row  recibe el indice de fila respectivamente de la casilla en donde se desea colocar la ficha
     * @param column  recibe el indice de columna respectivamente de la casilla en donde se desea colocar la ficha
     */
    public void addLazy(boolean king, int row, int column){
        int[][] laz = new int[2][1];
        laz[0][0] = row - 1;
        laz[1][0] = column - 1;
        this.king = king;
        addPLazy(laz);
    }
    /**
     * Se agrega una ficha al tablero, el usurario debe indicar a qué equipo corresponde
     * la ficha correspondiente
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha, en formato de matriz
     */
    private void addPLazy(int[][] laz){
        table.addPLazy(laz,king);
    }
    /**
     * Se agrega una ficha al tablero, el usuario debe indicar si es o no un rey 
     * con un booleano
     *
     * @param  king,row,column  recibe el booleano que indica si es rey o no 
     * @param row  recibe el indice de fila respectivamente de la casilla en donde se desea colocar la ficha
     * @param column  recibe el indice de columna respectivamente de la casilla en donde se desea colocar la ficha
     */
    public void addLibertarian(boolean king, int row, int column){
        int[][] lib = new int[2][1];
        lib[0][0] = row - 1;
        lib[1][0] = column - 1;
        this.king = king;
        addPLibertarian(lib);
    }
    /**
     * Se agrega una ficha al tablero, el usurario debe indicar a qué equipo corresponde
     * la ficha correspondiente
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha, en formato de matriz
     */
    private void addPLibertarian(int[][] lib){
        table.addPLibertarian(lib,king);
    }
   
    /**
     * Se agrega una ficha al tablero, el usuario debe indicar si es o no un rey 
     * con un booleano
     *
     * @param  king,row,column  recibe el booleano que indica si es rey o no 
     * @param row  recibe el indice de fila respectivamente de la casilla en donde se desea colocar la ficha
     * @param column  recibe el indice de columna respectivamente de la casilla en donde se desea colocar la ficha
     */
    public void addPower(boolean king, int row, int column){
        int[][] pow = new int[2][1];
        pow[0][0] = row - 1;
        pow[1][0] = column - 1;
        this.king = king;
        addPPower(pow);
    }
    /**
     * Se agrega una ficha al tablero, el usurario debe indicar a qué equipo corresponde
     * la ficha correspondiente
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha, en formato de matriz
     */
    private void addPPower(int[][] pow){
        table.addPPower(pow,king);
    }
    /**
     * Se agrega una ficha al tablero, el usuario debe indicar si es o no un rey 
     * con un booleano
     *
     * @param  king,row,column  recibe el booleano que indica si es rey o no 
     * @param row  recibe el indice de fila respectivamente de la casilla en donde se desea colocar la ficha
     * @param column  recibe el indice de columna respectivamente de la casilla en donde se desea colocar la ficha
     */
    public void addHurried(boolean king, int row, int column){
        int[][] hur = new int[2][1];
        hur[0][0] = row - 1;
        hur[1][0] = column - 1;
        this.king = king;
        addPHurried(hur);
    }
    /**
     * Se agrega una ficha al tablero, el usurario debe indicar a qué equipo corresponde
     * la ficha correspondiente
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha, en formato de matriz
     */
    private void addPHurried(int[][] hur){
        table.addPHurried(hur, king);
    }
    /**
     * Se agrega una ficha al tablero, el usuario debe indicar si es o no un rey 
     * con un booleano
     *
     * @param  king,row,column  recibe el booleano que indica si es rey o no 
     * @param row  recibe el indice de fila respectivamente de la casilla en donde se desea colocar la ficha
     * @param column  recibe el indice de columna respectivamente de la casilla en donde se desea colocar la ficha
     */
    public void addStay(boolean king, int row, int column){
        if ((row != 1) & (row != width) & (column != 1) & (column != width)){
            int[][] sta = new int[2][1];
            sta[0][0] = row - 1;
            sta[1][0] = column - 1;
            this.king = false;
            addPStay(sta);
        }
    }
    /**
     * Se agrega una ficha al tablero, el usurario debe indicar a qué equipo corresponde
     * la ficha correspondiente
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha, en formato de matriz
     */
    private void addPStay(int[][] sta){
        table.addPStay(sta,king);
    }
    /**
     * Se agrega una ficha al tablero, el usurario debe indicar a qué equipo corresponde
     * la ficha correspondiente
     * 
     * @param int[][] pos recibe los indices de fila y columna respectivamente de 
     * la casilla en donde se desea colocar la ficha, en formato de matriz
     */
    public void add(int[][] men){
        table.add(men,king);
    }
    /**
     * Se remueve una ficha al tablero, el usurario debe indicarla fila y la columna de la ficha
     * correspondiente
     * @param row recibe como parametro la fila de la ficha que desea retirar.
     * @param column recibe como parametro la columna de la ficha que desea retirar.
     */
    public void removeP(int row, int column)
    {           
        row--; column--;
        table.remove(row,column);
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
                        int team = table.pieces[i][j].team;
                        if (table.pieces[i][j] instanceof King){
                            game.pieces[i][j] = new King(k,team);
                            game.pieces[i][j].setPos(game.desp + (len * j) + len/2,len * i);
                        }
                        else if(table.pieces[i][j] instanceof Proletarian){
                            game.pieces[i][j] = new Proletarian(false, team);
                            game.pieces[i][j].setPos(game.desp + (len * j),len * i);
                        }
                        else if(table.pieces[i][j] instanceof Lazy){
                            if (k){
                                game.pieces[i][j] = new LazyKing(true, team);
                            }
                            else{
                                game.pieces[i][j] = new LazyPawn(false, team);
                            }
                            game.pieces[i][j].setPos(game.desp + (len * j),len * i);
                        }
                        else if(table.pieces[i][j] instanceof Libertarian){
                            if (k){
                                game.pieces[i][j] = new LibertarianKing(true, team);
                            }
                            else{
                                game.pieces[i][j] = new LibertarianPawn(false, team);
                            }
                            game.pieces[i][j].setPos(game.desp + (len * j),len * i);
                        }
                        else if(table.pieces[i][j] instanceof Powerfull){
                            if (k){
                                game.pieces[i][j] = new PowerKing(true, team);
                            }
                            else{
                                game.pieces[i][j] = new PowerPawn(false, team);
                            }
                            game.pieces[i][j].setPos(game.desp + (len * j),len * i);
                        }
                        else if(table.pieces[i][j] instanceof Hurried){
                            if (k){
                                game.pieces[i][j] = new HurryKing(true, team);
                            }
                            else{
                                game.pieces[i][j] = new HurryPawn(false, team);
                            }
                            game.pieces[i][j].setPos(game.desp + (len * j),len * i);
                        }
                        else if(table.pieces[i][j] instanceof Stay){
                            game.pieces[i][j] = new Stay(false, team);
                            game.pieces[i][j].setPos(game.desp + (len * j),len * i);
                        }
                        else{
                            game.pieces[i][j] = new Pawn(k,team);
                            game.pieces[i][j].setPos(game.desp + (len * j),len * i);
                        }
                        game.pieces[i][j].changeSize(24);
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
        return consulta;}
    /**
     * Hace visible todas las fichas en el tablero.
     */
    public void makeVisible(){
        if (cambio){
            game.makeVisible();
            accion=true;
        }
        else {
            table.makeVisible();
            accion = true;
        }}
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
    /**
     * @return Indices de posiciones del tablero actual
     */
    public HashMap<String,int[]> getIndexes(){
        return table.getIndexes();
    }
    /** Historia de uso para la presentación final del proyecto
     * 
     */
    public void _historiaDeUso(){
        /*Juan y Pedro deciden jugar, Juan(1) juega blancas y Pedro(2) negras
        * Deciden en un primer momento que c/u debe tener al menos un peon y un rey
        */
       //Pedro(2)
       add(false,1,2);
       add(true,1,4);
       //Juan(1)
       add(false,8,1);
       add(true,8,7);
       /*Ven que hay otros tipos de fichas y deciden completar su equipo con diferentes tipos de estas
        */
       //Pedro(2)
       addStay(false,2,5);
       addStay(false,2,7);
       addProle(false,1,6);
       addProle(true,1,8);
       addLibertarian(false,2,3);
       addLibertarian(false,2,1);
       //Juan(1)
       addStay(false,7,4);
       addStay(false,7,6);
       addProle(false,8,3);
       addProle(true,8,5);
       addLibertarian(false,7,8);
       addLibertarian(false,7,2);
       //Inician a jugar
       swap();
       //Juan inicia
       move("25-22");
       //Pedro
       move("8-12");
       //Pedro se da cuenta que no puede mover las fichas de tipo Stay
       //Juan también analiza y deciden cambiar una de las fichas stay de c/u
       swap();
       removeP(2,7);
       addPower(false,2,7);
       removeP(7,6);
       addPower(false,7,6);
       //Deciden ahora si, con el cambio, empezar a jugar
       swap();
       move("27-24");//B
       move("5-9");//N
       move("24-19");//B
       move("8-12");//N
       move("25-22");//B
       move("6-10");//N
       move("19-16");//B
       //Pedro intenta conquistar la ficha de Juan, pero al ser powerfull, no lo permite
       select(3,8);
       jump(false, false);
       //Pedro puede volver a mover debido a esa condicion
       move("2-6");//N
       move("16-11");//B
       move("10-15");//N
       select(3,6);
       jump(false,false);//B
       move("9-14");//N
       select(5,4);
       jump(true,false);//B
    }
}