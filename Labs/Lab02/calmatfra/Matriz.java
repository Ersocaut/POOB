import javax.swing.JOptionPane;
/**
 * @author ECI, 2019
 *
 */
public class Matriz{

    private Fraccionario[][]  matriz;
    
    /**
     * Nos dice si la matriz es considerada matriz algebraicamente
     * @param elementos int[][][]
     */
    
    public static boolean esMatriz (int [][][] elementos){
        if(elementos.length == 0){
            return false;
        }
        else if(elementos[0].length == 0){
            return false;
        }
        else if(elementos[0][0].length == 2){
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * Retorna una matriz dados sus elementos. Los fraccionarios se representan como {numerador, denominador}
     * @param elemento [][][]int es una lista de matrices de las cuales se convertiran en matriz de fraccionarios
     */
    public Matriz (int [][][] elementos) {
        matriz= new Fraccionario[elementos.length][elementos[0].length];
        for (int i=0;i<elementos.length;i++){
            for (int j=0;j<elementos[0].length;j++){
                matriz[i][j]=new Fraccionario(elementos[i][j][0],elementos[i][j][1]);
            }    
        }
    }
    /**
     * Retorna una matriz dados sus elementos. 
     * @param elementos Fraccionario[][] se le asignaran los elemenos a la matriz
     */
    public Matriz (Fraccionario[][] elementos) {
        matriz = elementos;
    }
    /**
     * Retorna una matriz dada su diagonal. 
     * @param d Fraccionario[] es una lista de fraccionarios en donde segun su diagonal guardare los datos  
     */    
    public Matriz (Fraccionario [] d){
        matriz = new Fraccionario[d.length][d.length];
        for (int i = 0; i < d.length; i++){
            for (int j = 0; j < d.length; j++){
                if (i == j){
                    matriz[i][j] = d[i];
                }
                else{
                    matriz[i][j] = new Fraccionario(0);
                }
            }
        }
    }   
    /**
     * Retorna una matriz de un numero repetido dada su dimension. 
     * @param e Fraccionario que se va a almacenar en matriz
     * @param f int fila
     * @param c int columna
     */
    public Matriz (Fraccionario e, int f, int c) {
        matriz= new Fraccionario[f][c];
        for (int i=0;i<f;i++){
            for (int j=0;j<c;j++){
               matriz[i][j]=e;
            }
        }
    }
    /**
     * Retorna una matriz identidad dada su dimension. 
     * @param n int dimension de la matriz identidad a crear
     */
    public Matriz (int n) {
        matriz= new Fraccionario[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i == j ){
                    matriz[i][j]=new Fraccionario(1);
                }
                else{
                    matriz[i][j]=new Fraccionario(0);
                }
            }
        }
    }
    /**
     * Retorna una matriz identidad dada su dimension. 
     * @return     Matriz se guarda el valor de la fila y la columna de la matriz
     */
    public Matriz dimension(){
        Fraccionario [][] resultante=new Fraccionario[this.matriz.length][this.matriz[0].length];
        Matriz nuevo= new Matriz(resultante);
        return nuevo;
    }
    /**
     * este metodo lo usamos para obtener el Fraccionario ubicado en la fila y columna que no dan
     * @param f int numero de la fila
     * @param c int numero de la columna
     * 
     * @return     Fraccionario el Fraccionario ubicado en la fila y columna de la matriz que desea averiguar
     */
    
    public Fraccionario get(int f, int c){
        return matriz[f][c];
    }
    
    /**
     * Compara esta matriz con otra
     * @param otra Matriz a comparar
     * 
     * @return Booleano debera retornar un valor booleano si  la Matriz ingresada es igual a la matriz almacenada 
     */
    public boolean equals (Matriz otra) {
        return this.matriz.equals(otra);
    }

    /** 
     * Compara esta matriz con otra
     * @param otra objeto a comparar
     * 
     * @return Booleano debera retornar un valor booleano si el objeto ingresado es igual a la matriz almacenada
     */
    @Override
    public boolean equals(Object otra) {
            return equals(otra);
    }
    
    
    /** 
     * Retorna una cadena con los datos de la matriz alineado a derecha por columna
     * 
     * @return String debera retornar la cadena de la matriz en cada caso
    */
    @Override
    public String toString () {
        String s = "";
        for ( int i = 0; i < matriz.length; i++){ 
          for (int j = 0; j < matriz[0].length; j++){
             String temp = matriz[i][j].toString();
              if (j == matriz[0].length - 1){
                  s += temp;
                }
              else{
              s += temp + ",";
             }
          }
          s +="\n";
        }
        System.out.println(s);
        return s;
        //return "";
        
    }   
    /**
     * este metodo lo usamos para obtener el int LengthRow
     * 
     * @return     int el numero entero de la longitud de la fila
     */
    private int getLengthColumn(){
        return matriz[0].length;
    }
    /**
     * este metodo lo usamos para obtener el int LengthColumn
     * 
     * @return     int el numero entero de la longitud de la columna
     */
    private int getLengthRow(){
        return matriz.length;
    }
    //Retorna la matriz con el numero de filas o columnas
    /** 
     * suma esta matriz con otra
     * @param m matriz 
     * 
     * @return Matriz debera retornar una Matriz nueva la cual contenga los fraccionarios resultantes de la operacion
     */
    public Matriz sume(Matriz m){
        int row = m.getLengthRow();
        int column = m.getLengthColumn();
        Matriz nuevaMatriz = new Matriz(new Fraccionario(0),row,column);
        if (matriz[0].length == column & matriz.length == row){
            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++){
                    nuevaMatriz.matriz[i][j] = m.matriz[i][j].sume(matriz[i][j]);
                }
            }
            return nuevaMatriz;
        }
        else{
            JOptionPane.showMessageDialog(null, "las matrices a operar deben tener la misma dimensión");
            return null;
        }
    }
    /** 
     * resta esta matriz con otra
     * @param m matriz 
     * 
     * @return Matriz debera retornar una Matriz nueva la cual contenga los fraccionarios resultantes de la operacion
     */
    public Matriz reste(Matriz m){
        int row = m.getLengthRow();
        int column = m.getLengthColumn();
        Matriz nuevaMatriz = new Matriz(new Fraccionario(0),row,column);
        if (matriz[0].length == column & matriz.length == row){

            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++){
                    nuevaMatriz.matriz[i][j] = m.matriz[i][j].reste(matriz[i][j]);
                }
            }
            return nuevaMatriz;
        }
        else{
            JOptionPane.showMessageDialog(null, "las matrices a operar deben tener la misma dimensión");
            return null;
        }
    }
    /** 
     * multiplica esta matriz con otra punto a punto
     * @param m matriz 
     * 
     * @return Matriz debera retornar una Matriz nueva la cual contenga los fraccionarios resultantes de la operacion
     */
    public Matriz multipliquePunto(Matriz m){
        int row = m.getLengthRow();
        int column = m.getLengthColumn();
        Matriz nuevaMatriz = new Matriz(new Fraccionario(0),row,column);
        if (matriz[0].length == column & matriz.length == row){
            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++){
                    nuevaMatriz.matriz[i][j] = m.matriz[i][j].multiplique(matriz[i][j]);
                }
            }
            return nuevaMatriz;
        }
        else{
            JOptionPane.showMessageDialog(null, "las matrices a operar deben tener la misma dimensión");
            return null;
        }
    }
    
    /** 
     * multiplica en cruz esta matriz con otra
     * @param m matriz 
     * 
     * @return Matriz debera retornar una Matriz nueva la cual contenga los fraccionarios resultantes de la operacion
     */
    public Matriz multipliqueCruz(Matriz m){
        int row = m.getLengthRow();
        int column = m.getLengthColumn();
        Matriz resultante = new Matriz(new Fraccionario(0), row, matriz[0].length);
        if (matriz.length == column){
            for (int i = 0; i < row; i++){
                Matriz temp = new Matriz(new Fraccionario(0), 0, matriz[0].length);
                for (int c = 0; c < matriz.length; c++){
                    Fraccionario n = new Fraccionario(0);
                    for (int j = 0; j < matriz[0].length; j++){
                        resultante.matriz[0][j].sume(m.matriz[i][j].multiplique(matriz[i][j]));
                    }
                    resultante.matriz[i] = resultante.matriz[0];
                }
            }
            return resultante;
        }
        else{
            JOptionPane.showMessageDialog(null, "las matrices a operar deben tener la misma dimensión");
            return null;
        }        
    }
    /** 
     * divide esta matriz con otra punto a punto
     * @param m matriz 
     * 
     * @return Matriz debera retornar una Matriz nueva la cual contenga los fraccionarios resultantes de la operacion
     */
    public Matriz division(Matriz m){
        int row = m.getLengthRow();
        int column = m.getLengthColumn();
        Matriz nuevaMatriz = new Matriz(new Fraccionario(0),row,column);
        if (matriz[0].length == column & matriz.length == row){
            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++){
                    nuevaMatriz.matriz[i][j] = m.matriz[i][j].divida(matriz[i][j]);
                }
            }
            return nuevaMatriz;
        }
        else{
            JOptionPane.showMessageDialog(null, "las matrices a operar deben tener la misma dimensión");
            return null;
        }
    }
    /** 
     * divide esta matriz con otra punto a punto
     * @param m matriz 
     * 
     * @return Matriz debera retornar una Matriz nueva la cual contenga los fraccionarios resultantes de la operacion
     */
    public Matriz traspuesta(){
        int row = matriz.length;
        int column = matriz[0].length;
        Matriz nuevaMatriz = new Matriz(new Fraccionario(0),column,row);
        for (int i = 0; i < row-1; i++){
            for (int j = 0; j < column-1; j++){
                nuevaMatriz.matriz[i][j] = matriz[j][i];
            }
        }
        return nuevaMatriz;
    }
}
