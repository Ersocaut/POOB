package tangible;
import java.util.*;

/**
 * Write a description of class VectorHelper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VectorHelper
{
    public static <T> void resize(ArrayList<T> list, int newSize)
        {
            resize(list, newSize, null);
        }

        public static <T> void resize(ArrayList<T> list, int newSize, T value)
        {
            if (list.size() > newSize)
            {
                for (int i = list.size() - 1; i >= newSize; i--)
                {
                    list.remove(i);
                }
            }
            else if (list.size() < newSize)
            {
                for (int i = list.size(); i < newSize; i++)
                {
                    list.add(value);
                }
            }
        }

        public static <T> void swap(ArrayList<T> list1, ArrayList<T> list2)
        {
            ArrayList<T> temp = new ArrayList<T>(list1);
            list1.clear();
            list1.addAll(list2);
            list2.clear();
            list2.addAll(temp);
        }

        public static <T> ArrayList<T> initializedArrayList(int size, T value)
        {
            ArrayList<T> temp = new ArrayList<T>();
            for (int count = 1; count <= size; count++)
            {
                temp.add(value);
            }

            return temp;
        }

        public static <T> ArrayList<ArrayList<T>> nestedArrayList(int outerSize, int innerSize)
        {
            ArrayList<ArrayList<T>> temp = new ArrayList<ArrayList<T>>();
            for (int count = 1; count <= outerSize; count++)
            {
                temp.add(new ArrayList<T>(innerSize));
            }

            return temp;
        }

        public static <T> ArrayList<ArrayList<T>> nestedArrayList(int outerSize, int innerSize, T value)
        {
            ArrayList<ArrayList<T>> temp = new ArrayList<ArrayList<T>>();
            for (int count = 1; count <= outerSize; count++)
            {
                temp.add(initializedArrayList(innerSize, value));
            }

            return temp;
        }
}
