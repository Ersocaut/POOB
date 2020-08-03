import java.util.Stack;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * Write a description of class CalcXook here.
 * 
 * @author (Leonardo Galeano Y Guillermo Castro) 
 * @version (a version number or a date)
 */
public class CalcXook
{
    // instance variables - replace the example below with your own
    private int x;
    private int resul;
    private Stack<Integer> pilaEnteros;
    private Stack<Xook> pilaMayas;
    private String color;
    private Scanner entrada = new Scanner(System.in);
    /**
     * Constructor for objects of class CalcXook
     * * @param  color, String color que desea la calculadora
     */
    public CalcXook(String color)
    {
            // initialise instance variables
            x = 0;
            this.color = color;
            pilaEnteros = new Stack();
            pilaMayas = new Stack();
    }
    /**
     * se crea la pila la cual desea operar
     * 
     * @param  num   int, la longitud de la pila que deseacrear
     */
    public void crearStack(int num)
    {
        if (num==1){
            JOptionPane.showMessageDialog(null,"Las opciones solo pueden ser 'Techo' o 'Arbol'");
        }else{
            for (int i = 0; i < num; i++){
                System.out.print("Ingrese numero a guardar: ");
                int numero1 = entrada.nextInt();
                pilaEnteros.add(numero1);
                pilaMayas.add(new Xook(numero1));
                System.out.print(pilaEnteros);
            }
            for (int i = 0; i < pilaMayas.size(); i++){
                pilaMayas.get(i).makeVisible();
                pilaMayas.get(i).changeColor(color);
            }
        }
    
    }
    /**
     * suma en forma de calculadora de pila, toma los 2 ultimos valores y los opera, guardando
     * el resultado al final 
     */
    public void suma()
    {
        for (int i = 0; i < pilaMayas.size(); i++){
            pilaMayas.get(i).makeInvisible();
        }
        pilaMayas.pop();
        pilaMayas.pop();
        int n1= pilaEnteros.pop();
        int n2= pilaEnteros.pop();
        int  resul = n2 + n1;
        pilaMayas.add(new Xook(resul));
        pilaEnteros.add(resul);
        System.out.println(pilaEnteros);
        for (int i = 0; i < pilaMayas.size(); i++){            
            pilaMayas.get(i).makeVisible();
        }
       }
    /**
     * multiplica en forma de calculadora de pila, toma los 2 ultimos valores y los opera, guardando
     * el resultado al final
     */
    public void multiplicacion()
    {
        for (int i = 0; i < pilaMayas.size(); i++){
            pilaMayas.get(i).makeInvisible();
        }
        pilaMayas.pop();
        pilaMayas.pop();
        int n1= pilaEnteros.pop();
        int n2= pilaEnteros.pop();
        int  resul = n1*n2;
        pilaMayas.push(new Xook(resul));
        pilaEnteros.push(resul);
        for (int i = 0; i < pilaMayas.size(); i++){
            pilaMayas.get(i).changeColor(color);
            pilaMayas.get(i).makeVisible();
        }
      }
    /**
     * resta en forma de calculadora de pila, toma los 2 ultimos valores y los opera, guardando
     * el resultado al final
     */
     public void resta()
    {
        for (int i = 0; i < pilaMayas.size(); i++){
            pilaMayas.get(i).makeInvisible();
        }
        pilaMayas.pop();
        pilaMayas.pop();
        int n1= pilaEnteros.pop();
        int n2= pilaEnteros.pop();
        System.out.print(pilaEnteros);
        int  resul = n2 < n1   ? n1 - n2
                               : n2 - n1;                      
        pilaEnteros.push(resul);
        for (int i = 0; i < pilaMayas.size(); i++){
            pilaMayas.get(i).makeVisible();
        }     
        }
    /**
     * divide en forma de calculadora de pila, toma los 2 ultimos valores y los opera, guardando
     * el resultado al final
     */
    public void division()
    {
        for (int i = 0; i < pilaMayas.size(); i++){
                pilaMayas.get(i).makeInvisible();
        }
        pilaMayas.pop();
        pilaMayas.pop();
        int n1= pilaEnteros.pop();
        int n2= pilaEnteros.pop();
        int  resul = n1/n2;
        pilaMayas.push(new Xook(resul));
        pilaEnteros.push(resul);
        for (int i = 0; i < pilaMayas.size(); i++){
            pilaMayas.get(i).makeVisible();
        }
       }
    /**
     * se agrega un nuevo valor a la pila  
     * 
     * @param  numero entero
     */
    public void addValue(int numero)
    {
         pilaEnteros.push(numero);
         pilaMayas.push(new Xook(numero));
        }
    /**
     * Este metodo se encarga de graficar los numeros segun los mayas
     * 
     */
    public void numerosMayas()
    {
        for (int i = 0; i < pilaEnteros.size(); i++){
            Xook numero = new Xook(pilaEnteros.peek());
            numero.changeColor(color);
            numero.makeVisible();
        }
    }
}
