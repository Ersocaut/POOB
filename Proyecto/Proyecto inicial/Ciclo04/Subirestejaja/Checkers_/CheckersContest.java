package Checkers_;
import Shapes.*;import java.io.*;
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
    private Piece[][] initial;
    
    private HashMap<String,int[]> pos;
    
    private boolean turn = false;
    public CheckersContest(int width){
        super(width);
        initial = new Piece[width][width];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++){
                initial[i][j] = null;
            }
        }
        pos = getIndex();
    }
    
    public void simulate(char player,String[] moves,boolean slow){
        char first = player;
        int n = moves.length;
        turn = (first == 'W') ? true: false;
        for (int i = 0; i < n; i++){
            String s = moves[i];
            String[] m;
            int[][] real;
            if (s.contains("-")){
                m = s.split("-");
                real = new int[m.length][2];
                int a = Integer.parseInt(m[0]); int b = Integer.parseInt(m[1]);
                real[0] = pos.get(m[0]); real[1] = pos.get(m[1]);
                if (table.pieces[real[0][0]][real[0][1]] == null){
                    int team = (turn) ? 1 : 2;
                    boolean up = a > b; boolean isKing = (up & !turn) ? true: (!up & turn) ? true: false;
                    if (isKing){
                        table.pieces[real[0][0]][real[0][1]] = new King(isKing,team);
                        initial[real[0][0]][real[0][1]] = new King(isKing,team);
                    }
                    else{
                        table.pieces[real[0][0]][real[0][1]] = new Pawn(isKing,team);
                        initial[real[0][0]][real[0][1]] = new Pawn(isKing,team);
                    }
                }
            }
            else{
                m = s.split("x");
            }
        }
    
    }
    
    public void ayudaSolve(){
        int[][] lista = new int[moves.size()][moves.size()];
        for (int i=0; i<moves.size(); i++) {
            for (int j = 0; j < moves.size(); j++){
                lista[i][j] = -9999;
            }}
        LinkedList<Integer> q = new LinkedList<Integer>();
        while (q.size() > 0) {
            int cur = q.poll();

            for (int i=0; i<moves.size(); i++) {
                for (int j=0; j<moves.size(); j++) {

                    if (lista[i][j] != -9999) continue;

                }
            }
        }
    }
    public String solve(char player, String[] moves ){
        ayudaSolve();
        return moves[1];
    }
    
    private HashMap<String,int[]> getIndex(){
        return table.getIndexes();
    }
}