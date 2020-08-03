package Checkers_;

import java.util.*;
import tangible.*;
/**
 * Write a description of class arena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
public class arena 
{
    private ArrayList<Character> moveType = new ArrayList<Character>();
    private ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>();
    /**
     * Constructor for objects of class arena
     */
    public arena()
    {
        Main();
    }
    private static char opp(char player)
    {
        return player == 'W' ? 'B' : 'W';
    }

    private static int sqX(int sq)
    {
        return (sq - 1) % 4 * 2 + 1 - ((sq - 1) / 4) % 2;
    }

    private static int sqY(int sq)
    {
        return (sq - 1) / 4;
    }

    public tangible.Pair<ArrayList<String>, ArrayList<String>> doit(ArrayList<String> start2)
    {
        ArrayList<String> board = new ArrayList(start2);
        ArrayList<String> start = start2;
        char player = startPlayer;
        for (int i = 0; i < moves.size(); i++, player = opp(player))
        {
            for (int j = 0; j + 1 < moves.get(i).size(); j++)
            {
                int sx = sqX(moves.get(i).get(j));
                int sy = sqY(moves.get(i).get(j));
                int ex = sqX(moves.get(i).get(j + 1));
                int ey = sqY(moves.get(i).get(j + 1));
                boolean promoted = ((player == 'W' && ey == 0) || (player == 'B' && ey == 7)) && Character.isLowerCase(board.get(sy).charAt(sx));

                if (moveType.get(i) == '-')
                {
                    for (int y = 0; y < 8; y++)
                    {
                        for (int x = 0; x < 8; x++)
                        {
                            if (Character.toUpperCase(board.get(y).charAt(x)) == player)
                            {
                                for (int dx = -1; dx <= 1; dx += 2)
                                {
                                    for (int dy = -1; dy <= 1; dy += 2)
                                    {
                                        if (board.get(y).charAt(x) == 'w' && dy == 1)
                                        {
                                            continue;
                                        }
                                        if (board.get(y).charAt(x) == 'b' && dy == -1)
                                        {
                                            continue;
                                        }
                                        int x2 = x + dx + dx;
                                        int y2 = y + dy + dy;
                                        if (x2 < 0 || x2 >= 8 || y2 < 0 || y2 >= 8)
                                        {
                                            continue;
                                        }
                                        if (Character.toUpperCase(board.get(y + dy).charAt(x + dx)) != opp(player))
                                        {
                                            continue;
                                        }
                                        if (board.get(y2).charAt(x2) == '.')
                                        {
                                            ArrayList vacio = new ArrayList(); 
                                            return new tangible.Pair<ArrayList<String>, ArrayList<String>>(vacio, vacio);
                                        }
                                        if (board.get(y2).charAt(x2) == '?')
                                        {
                                            start.get(y2).equals(tangible.StringFunctions.changeCharacter(start.get(y2), x2, (y2 == 0) ? 'W' : 'w'));
                                            tangible.Pair<ArrayList<String>, ArrayList<String>> ret = doit(new ArrayList<String>(start));
                                            if (ret.first.size() != 0)
                                            {
                                                return new tangible.Pair<ArrayList<String>, ArrayList<String>>(ret);
                                            }
                                            start.get(y2).equals(tangible.StringFunctions.changeCharacter(start.get(y2), x2, (y2 == 7) ? 'B' : 'b'));
                                            return new tangible.Pair<ArrayList<String>, ArrayList<String>>(doit(new ArrayList<String>(start)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                board.get(ey).equals( tangible.StringFunctions.changeCharacter(board.get(ey), ex, board.get(sy).charAt(sx)));
                if (promoted)
                {
                    board.get(ey).equals(tangible.StringFunctions.changeCharacter(board.get(ey), ex, Character.toUpperCase(board.get(ey).charAt(ex))));
                }
                board.get(sy).equals( tangible.StringFunctions.changeCharacter(board.get(sy), sx, '.'));
                if (moveType.get(i) == 'x')
                {
                    int mx = (sx + ex) / 2;
                    int my = (sy + ey) / 2;
                    board.get(my).equals(tangible.StringFunctions.changeCharacter(board.get(my), mx, '.'));

                    if (j + 2 == moves.get(i).size() && !promoted)
                    {
                        int x = ex;
                        int y = ey;
                        for (int dx = -1; dx <= 1; dx += 2)
                        {
                            for (int dy = -1; dy <= 1; dy += 2)
                            {
                                if (board.get(y).charAt(x) == 'w' && dy == 1)
                                {
                                    continue;
                                }
                                if (board.get(y).charAt(x) == 'b' && dy == -1)
                                {
                                    continue;
                                }
                                int x2 = x + dx + dx;
                                int y2 = y + dy + dy;
                                if (x2 < 0 || x2 >= 8 || y2 < 0 || y2 >= 8)
                                {
                                    continue;
                                }
                                if (Character.toUpperCase(board.get(y + dy).charAt(x + dx)) != opp(player))
                                {
                                    continue;
                                }
                                if (board.get(y2).charAt(x2) == '.')
                                {
                                    ArrayList vacio = new ArrayList(); 
                                    return new tangible.Pair<ArrayList<String>, ArrayList<String>>(vacio, vacio);
                                }
                                if (board.get(y2).charAt(x2) == '?')
                                {
                                    start.get(y2).equals(tangible.StringFunctions.changeCharacter(start.get(y2), x2, (y2 == 0) ? 'W' : 'w'));
                                    tangible.Pair<ArrayList<String>, ArrayList<String>> ret = doit(new ArrayList<String>(start));
                                    if (ret.first.size() != 0)
                                    {
                                        return new tangible.Pair<ArrayList<String>, ArrayList<String>>(ret);
                                    }
                                    start.get(y2).equals( tangible.StringFunctions.changeCharacter(start.get(y2), x2, (y2 == 7) ? 'B' : 'b'));
                                    return new tangible.Pair<ArrayList<String>, ArrayList<String>>(doit(new ArrayList<String>(start)));
                                }
                            }
                        }
                    }
                }
            }
        }

        return new tangible.Pair<ArrayList<String>, ArrayList<String>>(start, board);
    }
    private static char startPlayer;
    public static void Main()
    {
        int N;
        int first;
        startPlayer = 'B';
        char player =startPlayer;
        while ( (N = Integer.parseInt(ConsoleInput.readToWhiteSpace())) > 0)
        {
            ArrayList<Character> moveType = new ArrayList<Character>(N);
            ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>(N);
            for (int i = 0; i < N; i++)
            {
                String s;
                s = ConsoleInput.readToWhiteSpace();
                int j = 0;
                for (;;)
                {
                    int sq = s.charAt(j) - '0';
                    if (j + 1 < s.length() && Character.isDigit(s.charAt(j + 1)))
                    {
                        sq = 10 * sq + s.charAt(++j) - '0';
                    }
                    moves.get(i).add(sq);
                    if (++j == s.length())
                    {
                        break;
                    }
                    moveType.get(i).equals( s.charAt(j++));
                }
            }
            ArrayList<String> start = tangible.VectorHelper.initializedArrayList(8, "????????");
            ArrayList<String> board = new ArrayList(start);
            ArrayList<ArrayList<Integer>> startX = new ArrayList<ArrayList<Integer>>(8);
            ArrayList<ArrayList<Integer>> startY = new ArrayList<ArrayList<Integer>>(8);
            for (int y = 0; y < 8; y++)
            {
                for (int x = 0; x < 8; x++)
                {
                    startX.get(y).add(x);
                    startY.get(y).add(y);
                }
            }
            for (int i = 0; i < moves.size(); i++, player = opp(player))
            {
                for (int j = 0; j + 1 < moves.get(i).size(); j++)
                {
                    int sx = sqX(moves.get(i).get(j ));
                    int sy = sqY(moves.get(i).get(j ));
                    int ex = sqX(moves.get(i).get(j + 1));
                    int ey = sqY(moves.get(i).get(j + 1));
                    boolean promoted = ((player == 'W' && ey == 0) || (player == 'B' && ey == 7));
                    if (board.get(sy).charAt(sx) == '?')
                    {
                        board.get(sy).equals(tangible.StringFunctions.changeCharacter(board.get(sy), sx,Character.toLowerCase(player)));
                    }
                    if (board.get(ey).charAt(ex) == '?')
                    {
                        board.get(ey).equals(tangible.StringFunctions.changeCharacter(board.get(ey), ex, '.'));
                    }
                    assert Character.toUpperCase(board.get(sy).charAt(sx)) == player;
                    assert board.get(ey).charAt(ex) == '.';
                    if (((player == 'W') ^ (ey < sy)) && Character.isLowerCase(board.get(sy).charAt(sx)))
                    {
                        board.get(sy).equals( tangible.StringFunctions.changeCharacter(board.get(sy), sx, Character.toUpperCase(board.get(sy).charAt(sx))));
                    }
                    board.get(ey).equals(tangible.StringFunctions.changeCharacter(board.get(ey), ex, board.get(sy).charAt(sx)));
                    if (promoted && j + 2 == moves.get(i).size())
                    {
                        board.get(ey).equals(tangible.StringFunctions.changeCharacter(board.get(ey), ex, Character.toUpperCase(board.get(ey).charAt(ex))));
                    }
                    board.get(sy).equals(tangible.StringFunctions.changeCharacter(board.get(sy), sx, '.'));
                    startX.get(ey).set(ex, startX.get(sy).get(sx));
                    startY.get(ey).set(ex, startY.get(sy).get(sx));
                    if (moveType.get(i) == 'x')
                    {
                        int mx = (sx + ex) / 2;
                        int my = (sy + ey) / 2;
                        if (board.get(my).charAt(mx) == '?')
                        {
                            board.get(my).equals(tangible.StringFunctions.changeCharacter(board.get(my), mx,Character.toLowerCase(opp(player))));
                        }
                        assert Character.toUpperCase(board.get(my).charAt(mx)) == opp(player);
                        board.get(my).equals(tangible.StringFunctions.changeCharacter(board.get(my), mx, '.'));
                    }
                }
            }
        }
    }
}
