import java.io.*;
import java.util.*;
/**
 * Write a description of class CheckersContest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CheckersContest extends Checkers
{
    private Scanner stdin = new Scanner(System.in);
    private ArrayList<String[]> moves = new ArrayList<String[]>();
    private ArrayList<int[]> cords;
    private Piece[][] initial;
    
    private boolean turn = false;
    public CheckersContest(int width){
        super(width);
        initial = new Piece[width][width];
        main();
    }
    private void main(){
        String first = stdin.next();
        int n = stdin.nextInt();
        turn = (first == "W") ? true: false;
        for (int i = 0; i < n; i++){
            String s = stdin.next();
            String[] m;
            if (s.contains("-")){
                m = s.split("-");
            }
            else{
                m = s.split("x");
            }
            moves.add(m);
        }
        cords = convert(moves);

    }    
    private ArrayList<int[]> convert(ArrayList<String[]> m){
        ArrayList<int[]> nList = new ArrayList<int[]>();
        for (int i = 0; i < moves.size(); i++){
            String[] temp = moves.get(i);
            int[] toAdd = new int[temp.length];
            for (int j = 0; j < temp.length; j++){
                Integer pivot = Integer.parseInt(temp[j]); 
                toAdd[j] = pivot.intValue();
            }
            nList.add(toAdd);
        }
        return nList;
    }
}
