package aplicacion;
import java.awt.Color;

public interface Elemento{
  final static int REDONDA = 1;
  final static int CUADRADA = 2;
  default void decida(){};
  default void cambie(){};
  default int getForma(){
      return REDONDA;
  }
  Color getColor();
  char getEstado();
  void setVecinos(int vecinos);
  default boolean isVivo(){
      return false;
  }
}
