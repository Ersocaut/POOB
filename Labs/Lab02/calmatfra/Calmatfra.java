
/** Calculadora.java
 * Representa una calculadora de matrices de fraccionarios
 * @author ESCUELA 2018-01
 */

import java.util.HashMap;
public class Calmatfra{

    private HashMap<String, Matriz> variables;
    //Consultar en el API Java la clase HashMap
    private static int cont = 0;
    private boolean Accion;
    /** Constructor de un nuevo Calmatfra
     */
    public Calmatfra(){
        variables = new HashMap<String, Matriz>();
        Accion=true;
        
    }
    /**
     * Asigna a la llave dada, la matriz indicada al hashmap
     * @param variable, la llave con la que se guardará la matriz en el hashmap
     * @param matriz, la matriz que se va a guardar
     */
    public void asigne(String variable, int [][][] matriz){
        variables.put(variable, new Matriz(matriz));
        Accion=true;
    }
    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    /**Realiza la operación deseada por el usuario con las dos matrices que indique
     * @param respuesta, será la llave con la que colocaremos la matriz resultante en variables
     * @param operando1, la llave de la primera matriz que se desea operar
     * @param operación, el signo de la operación que se desea realizar
     * @param operando2, la llave de la segunda matriz que se desea operar
     * 
     */
    public void opere(String respuesta, String operando1, char operacion, String operando2){
        switch (operacion){
            case '+':
                Matriz resulSum = variables.get(operando1).sume(variables.get(operando2));
                variables.put(respuesta, resulSum);
                Accion=true;
                break;
            case '-':
                Matriz resulRes = variables.get(operando1).reste(variables.get(operando2));
                variables.put(respuesta, resulRes);
                Accion=true;
                break;
            case '*':
                Matriz resulMulCruz = variables.get(operando1).multipliqueCruz(variables.get(operando2));
                variables.put(respuesta, resulMulCruz);
                Accion=true;
                break;
            case '.':
                Matriz resulMulPun = variables.get(operando1).multipliquePunto(variables.get(operando2));
                variables.put(respuesta, resulMulPun);
                Accion=true;
                break;
            case '/':
                Matriz resulDiv = variables.get(operando1).division(variables.get(operando2));
                variables.put(respuesta, resulDiv);
                Accion=true;
                break;
            case 'T':
                Matriz resulTras1 = variables.get(operando1).traspuesta();
                variables.put(respuesta + operando1, resulTras1);
                Matriz resulTras2 = variables.get(operando2).traspuesta();
                variables.put(respuesta + operando2, resulTras2);
                Accion=true;
                break;
        }
    }
    /**
     * devuelve en forma de string la matriz correspondiente
     * @param variable, es la llave de la matriz que desea consultar
     * @return la matriz deseada en formato de String
     */
    public String consulta(String variable){   
        Accion=true;
        return variables.get(variable).toString();
        
    }
    /** 
    * Retorna si la ultima operación/acción realizada por en la calculadora fue hecha satisfactoriamente o no.
    * @return Booleano valor de la ultima accion
    */
    public boolean ok(){
        return Accion;
    }
}
    



