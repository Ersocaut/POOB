import java.util.*;
/**
 * Fraccionario
 * Esta clase implementa el tipo de dato Fraccionario; es decir, un n�mero racional que se pueden escribir de la forma p/q, donde p y q son enteros, con q <> 0
 * La implemantacion se hace mediante objetos inmutables
 * INV: El fraccionario se encuentra representado en forma irreductible.
 * @author E.C.I.
 *
 */
public class Fraccionario {
    public int numerador;
    public int denominador;

    /**Calcula el maximo comun divisor de dos enteros
     * Lo implementaremos mediante el algoritmo recursivo
     * @param a primer entero
     * @param b segundo entero
     * @return el Maximo Comun Divisor de a y b
     */
  
    public static int mcd(int a,int b){
        if (b < 0){
            b *= -1;
        }
        if (a < 0){
            a *= -1;
        }
        if (b == 0){
            return a;
        }
        else{
            return mcd(b,a%b);
        }
    }    
    /**reduce un fraccionario, dado el numerador y el denominador
     * @param p es el numerador
     * @param q es el denominador
     * @return un ArrayList 
     */
    public ArrayList<Integer> reduce(int p, int q){
         int n = mcd(p,q);
         ArrayList<Integer> f = new ArrayList<Integer>();
         f.add(p/n);
         f.add(q/n);
         return f;
    }
    /**Crea un nuevo fraccionario, dado el numerador y el denominador
     * @param numerador
     * @param denominador. denominador <> 0
     */
    public Fraccionario (int numerador, int denominador){
        if (numerador == 0){
            this.numerador = 0;
            this.denominador = 1;
        }
        else if (denominador != 0){
            ArrayList<Integer> f = reduce(numerador, denominador);
            this.numerador = f.get(0);
            this.denominador = f.get(1);
        }
        if (denominador < 0 & numerador < 0){
            this.denominador *= -1;
            this.numerador *= -1;
        }
        else if(denominador < 0){
            this.denominador *= -1;
            this.numerador *= -1;
        }
    }
    
    /**Crea un fraccionario correspondiente a un entero
     * @param entero el entero a crear
     */
    public Fraccionario (int entero) {
        this.numerador = entero;
        this.denominador = 1;
    }

     /**Crea un fraccionario, a partir de su representacion mixta. 
     * El numero creado es enteroMixto + numeradorMixto/denominadorMixto
     * @param enteroMixto la parte entera del numero
     * @param numeradorMixto el numerador de la parte fraccionaria
     * @param denominadorMixto el denominador de la parte fraccionaria. denominadorMixto<>0
     */
    public Fraccionario (int enteroMixto, int numeradorMixto, int denominadorMixto) {
        if (denominadorMixto != 0){
            ArrayList<Integer> f = reduce((enteroMixto * denominadorMixto) + numeradorMixto,denominadorMixto);
            numerador = f.get(0);
            denominador = f.get(1);
        }
        if (denominador < 0 & numerador < 0){
            denominador *= -1;
            numerador *= -1;
        }
        else if(denominador < 0){
            denominador *= -1;
            numerador *= -1;
        }
    }
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return El numerador simplificado del fraccionario
     */
    public int numerador() {
        return this.numerador;
    }
    
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero Positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return el denominador simplificado del fraccionario
     */
    public int denominador() {
        return this.denominador;
    }
    
    /**Suma este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario sume (Fraccionario otro) {
        return new Fraccionario((otro.numerador()*denominador())+(numerador()*otro.denominador()),otro.denominador()*denominador());
    }
    /**Resta este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return Fraccionario este-otro
     */
    public Fraccionario reste (Fraccionario otro) {
        return new Fraccionario((otro.numerador()*denominador())-(numerador()*otro.denominador()),otro.denominador()*denominador());
    }
    
    /**Multiplica este fraccionario con otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario multiplique (Fraccionario otro) {
        return new Fraccionario(otro.numerador()*numerador(),otro.denominador()*denominador());
    }
    
    /**Divide este fraccionario sobre otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario divida (Fraccionario otro) {
        Fraccionario resul = new Fraccionario(otro.numerador()*denominador(),otro.numerador()*denominador());
        return resul;
    }
    
    /**
     * Compara esta fraccionarico con obj
     * @param obj objeto a comparar
     * 
     * @return Booleano debera retornar un valor booleano si  el objeto ingresado es igual al fraccionario almacenado
     */
    @Override
    public boolean equals(Object obj) {
        return equals((Fraccionario)obj);
    }    
    
    /**Compara este fraccionario con otro fraccionario
     * @param otro eL otro fraccionario
     * @return true si este fraccionario es igual matem�ticamente al otro fraccionario, False d.l.c.
     */
    public boolean equals (Fraccionario otro) {
        if (otro.denominador == denominador & otro.numerador == numerador){
            return true;
        }
        else if(otro.denominador == denominador & otro.numerador == numerador*-1){
            return true;
        }
        else if(otro.denominador == denominador*-1 & otro.numerador == numerador){
            return true;
        }
        else{
            return false;
        }
    }


    /** Calcula la representacion en cadena de un fraccionario en formato mixto simplificado
     * @see java.lang.Object#toString(java.lang.Object)
     */
    @Override
    public String toString() {
        String n = this.numerador + "/" + this.denominador;
        return n;
    }
    
}
