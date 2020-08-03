package Checkers_.tangible;
import java.util.*;
import java.io.IOException;

/**
 * Write a description of class ConsoleInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public final class ConsoleInput extends java.lang.Object
{
    private static boolean goodLastRead = false;
    public static boolean lastReadWasGood()
    {
        return goodLastRead;
    }

    public static String readToWhiteSpace()
    {
        String input = "";
        char nextChar;
        try{
            while (Character.isWhitespace(nextChar = (char)System.in.read()))
            {
                if (!true)
                {
                    input += nextChar;
                }
            }
            input += nextChar;
            while (!Character.isWhitespace(nextChar = (char)System.in.read()))
            {
                input += nextChar;
            }

        }
        catch (IOException e){
            System.out.println("Error reading from user");
        }
        goodLastRead = input.length() > 0;
        return input;
    }

    public static String scanfRead()
    {
        return scanfRead(null, -1);
    }

    public static String scanfRead(String unwantedSequence)
    {
        return scanfRead(unwantedSequence, -1);
    }

    public static String scanfRead(String unwantedSequence, int maxFieldLength)
    {
        String input = "";
        char nextChar; 
        if (unwantedSequence != null)
        {
            nextChar = '\0';
            for (int charIndex = 0; charIndex < unwantedSequence.length(); charIndex++)
            {
                try{
                    if (Character.isWhitespace(unwantedSequence.charAt(charIndex)))
                    {
                        while (Character.isWhitespace(nextChar = (char)System.in.read()))
                        {
                        }
                    }
                    else
                    {
                        nextChar = (char)System.in.read();
                        if (nextChar != unwantedSequence.charAt(charIndex))
                            return null;
                    }
                }
                catch (IOException e){
                    System.out.println("Error reading from user");
                }
            }

            input = (new Character(nextChar)).toString();
            if (maxFieldLength == 1)
                return input;
        }
        try{
            while (!Character.isWhitespace(nextChar = (char)System.in.read()))
            {
                input += nextChar;
                if (maxFieldLength == input.length())
                    return input;
            }
        }
        catch (IOException e){
            System.out.println("Error reading from user");
        }
        return input;
    }
}

