/**
* La clase piece nos ayuda a crear las piezas de ajedrez con 
* las cuales jugaremos damas chinas; Se deberan crear n fichas. 
*
* @author (Guillermo Castro-Leonardo Galeano)
 * @version (version 10)
 */
public abstract class Piece
{
    public boolean isKing;
    
    protected String color;
    
    public int team;
    /**
     * Constructor for objects of class Piece
     */
    public Piece (boolean isKing, int team){
        String color = (team == 1)  ? "white":"black";
        this.team = team;
    }
    /**
     * recobra el color del equipo que tuvo.
     */
    public void recoverColor(){
        if (team == 1){
            changeColor("white");
        }
        else{
            changeColor("black");
        }
    }
    /**
     * cambia el color de la ficha.
     * @ param newColor es un Strin con el color a cambiar
     */
    public abstract void changeColor(String newColor);
    /**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        makeVisible();
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        makeInvisible();
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public abstract void changeSize(int size);
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        moveHorizontal(desp);
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        moveVertical(desp);
    }
    /**
     * cambia el valor de la posicionficha.
     * @ param x es un int con la nueva posicion que toma en el eje x
     * @ param y es un int con la nueva posicion que toma en el eje y
     */
    public void setPos(int x, int y){
        setPos(x,y);
    }
    /**
     * obtiene el valor booleano de si es reina en la ficha.
     * 
     * @return  boolean true o false depende de si es reina o no  
     */
    public boolean getIsKing(){
        return isKing;
    }
    /**
     * mueve conforme una fila y columna.
     * @ param row es la fila de la ficha que se va a mover
     * @ param column es la columna de la ficha que se va a mover
     */
    public void move(int row, int column){
        moveVertical(row);
        moveHorizontal(column);
    }
}