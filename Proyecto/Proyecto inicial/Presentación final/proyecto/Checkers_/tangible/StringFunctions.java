package Checkers_.tangible;


/**
 * Write a description of class StringFunctions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringFunctions
{
    
        public static String changeCharacter(String sourceString, int charIndex, char newChar)
        {
            return (charIndex > 0 ? sourceString.substring(0, charIndex) : "")
            + Character.toString(newChar) + (charIndex < sourceString.length() - 1 ? sourceString.substring(charIndex + 1) : "");
        }

        public static boolean isXDigit(char character)
        {
            if (Character.isDigit(character))
                return true;
            else if ("ABCDEFabcdef".indexOf(character) > -1)
                return true;
            else
                return false;
        }

        public static String strChr(String stringToSearch, char charToFind)
        {
            int index = stringToSearch.indexOf(charToFind);
            if (index > -1)
                return stringToSearch.substring(index);
            else
                return null;
        }

        public static String strRChr(String stringToSearch, char charToFind)
        {
            int index = stringToSearch.lastIndexOf(charToFind);
            if (index > -1)
                return stringToSearch.substring(index);
            else
                return null;
        }

        public static String strStr(String stringToSearch, String stringToFind)
        {
            int index = stringToSearch.indexOf(stringToFind);
            if (index > -1)
                return stringToSearch.substring(index);
            else
                return null;
        }
        private static String activeString;
        private static int activePosition;
        public static String strTok(String stringToTokenize, String delimiters)
        {
            if (stringToTokenize != null)
            {
                activeString = stringToTokenize;
                activePosition = -1;
            }

            if (activeString == null)
                return null;

            if (activePosition == activeString.length())
                return null;

            activePosition++;
            while (activePosition < activeString.length() && delimiters.indexOf(activeString.charAt(activePosition)) > -1)
            {
                activePosition++;
            }

            if (activePosition == activeString.length())
                return null;

            int startingPosition = activePosition;

            do
            {
                activePosition++;
            } while (activePosition < activeString.length() && delimiters.indexOf(activeString.charAt(activePosition)) == -1);

            return activeString.substring(startingPosition, activePosition);
        }
    
}
