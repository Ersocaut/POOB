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
    private arena arena;
    private boolean turn = false;
    private char startPlayer;
    private ArrayList<Character> moveType;
    private ArrayList<ArrayList<Integer>> moves1;
    public CheckersContest(int width){
        super(width);
        initial = new Piece[width][width];
        arena = new arena() ;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++){
                initial[i][j] = null;
            }
        }
        pos = getIndex();
    }
    

    public void solve(char player,String[] moves){
        arena.Main();
    }

    private HashMap<String,int[]> getIndex(){
        return table.getIndexes();
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
}