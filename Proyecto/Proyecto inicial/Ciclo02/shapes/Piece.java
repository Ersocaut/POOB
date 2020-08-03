/**
* La clase piece nos ayuda a crear las piezas de ajedrez con 
* las cuales jugaremos damas chinas; Se deberan crear n fichas. 
*
* @author (Guillermo Castro-Leonardo Galeano)
 * @version (version 10)
 */
public class Piece
{
    public boolean isKing;
    
    private Circle men;
    
    private Triangle king;
    
    public int team;
    /**
     * Constructor for objects of class Piece
     */
    public Piece (boolean isKing, int team){
        if (team == -1){
            men = new Circle();
        }
        else{
            String color = (team == 1)  ? "white"
                                        :"red";
            if (isKing){
                this.isKing = true;
                king = new Triangle();
                king.changeColor(color);
            }
            else{
                men = new Circle();
                men.changeColor(color);
            }
        }
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
            changeColor("red");
        }
    }
    /**
     * cambia el color de la ficha.
     * @ param newColor es un Strin con el color a cambiar
     */
    public void changeColor(String newColor){
        if (isKing){
            king.changeColor(newColor);
        }
        else{
            men.changeColor(newColor);
        }
    }
    /**
     * Hace visible la ficha.
     */
    public void makeVisible(){
        if (isKing){
            king.makeVisible();
        }
        else{
            men.makeVisible();
        }
    }
    /**
     * Hace invisible la ficha.
     */
    public void makeInvisible(){
        if (isKing){
            king.makeInvisible();
        }
        else{
            men.makeInvisible();
        }
    }
    /**
     * cambia el tamaño de la ficha.
     * @ param size es un int con el tamaño a cambiar
     */
    public void changeSize(int size){
        if (isKing){
            king.changeSize(size,size);
        }
        else{
            men.changeSize(size);
        }
    }
    /**
     * mueve horizontalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveHorizontal(int desp){
        if (isKing){
            king.moveHorizontal(desp);
        }
        else{
            men.moveHorizontal(desp);
        }
    }
    /**
     * mueve verticalmente la ficha.
     * @ param desp es un int con el valor a mover
     */
    public void moveVertical(int desp){
        if (isKing){
            king.moveVertical(desp);
        }
        else{
            men.moveVertical(desp);
        }
    }
    /**
     * cambia el valor de la posicionficha.
     * @ param x es un int con la nueva posicion que toma en el eje x
     * @ param y es un int con la nueva posicion que toma en el eje y
     */
    public void setPos(int x, int y){
        if (isKing){
            king.setPos(x,y);
        }
        else{
            men.setPos(x,y);
        }
    }
    /**
     * obtiene el valor booleano de si es reina en la ficha.
     * 
     * @return  boolean true o false depende de si es reina o no  
     */
    public boolean getIsKing(){
        return isKing;
    }
}