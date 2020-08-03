import java.util.ArrayList;
import java.util.Random;
    /**
     * Write a description of class Xook here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
public class Xook
    {
    public  int count = 0;
    public  int pos;
    private int value;
    private int xPosition;
    private int yPosition;
    private boolean isVisible;
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    private int lenCircles = 0;
    private int lenRectangles = 0;
    private int lenTriangles = 0;
    
    public Xook (int x){
        count++;
        value = x;
        xPosition=25;
        yPosition = 250;
        isVisible = false;
    }
    public int getValue(){
        return value;
    }
    public void moveHorizontal(int distance){
        for (int i = 0; i < lenCircles; i++){
            circles.get(i).moveHorizontal(distance);
        }
        for (int i = 0; i < lenRectangles; i++){
            rectangles.get(i).moveHorizontal(distance);
        }
        for (int i = 0; i < lenTriangles; i++){
            triangles.get(i).moveHorizontal(distance);
        }
    }
    public void changeColor(String nColor){
        for (int i = 0; i < lenCircles; i++){
            circles.get(i).changeColor(nColor);
        }
        for (int i = 0; i < lenRectangles; i++){
            rectangles.get(i).changeColor(nColor);
        }
        for (int i = 0; i < lenTriangles; i++){
            triangles.get(i).changeColor(nColor);
        }
    }
    public void makeVisible(){
        int bars;
        int points;
        int zeros;
        circles.clear();
        rectangles.clear();
        triangles.clear();
        yPosition = 250;
        if (value == 0){
            bars = 0;
            points = 0;
            zeros = 1;
            drawAll(bars, points, zeros);
        }
        else if (value < 20){
            bars = value / 5;
            points = value % 5;
            drawAll(bars,points,0);
        }
        else{
            int num = value;
            while (num > 19){
                bars = (num%20)/5;
                points = (num%20)%5;
                zeros = (num%20 == 0)   ? 1 
                                        : 0;
                drawAll(bars,points,zeros);
                num = num / 20;
                //xPosition += 50;
                yPosition -= 35;
            }
            bars = num/5;
            points = num%5;
            drawAll(bars,points,0);
            xPosition = 25 + count * 50;
        }
    }
    public void makeInvisible(){
        for (int i = 0; i < lenCircles; i++){
            circles.get(i).makeInvisible();
        }
        for (int i = 0; i < lenRectangles; i++){
            rectangles.get(i).makeInvisible();
        }
        for (int i = 0; i < lenTriangles; i++){
            triangles.get(i).makeInvisible();
        }
        }   
    private void drawAll(int bars, int points, int zeros){
        for (int i = 0; i < zeros; i++){
            Triangle bread = new Triangle();
            bread.moveVertical(yPosition);
            bread.moveHorizontal(xPosition-100);
            //bread.changeColor("black");
            bread.changeSize(15,15);
            yPosition -= 20;
            bread.moveHorizontal((count-1) * 50);
            bread.makeVisible();
            triangles.add(bread);
        }
        for (int i = 0; i < bars; i++){
            Rectangle bar = new Rectangle();
            //bar.changeColor("black");
            bar.moveHorizontal(xPosition - 50 );
            bar.moveVertical( yPosition );
            yPosition -= 10;
            bar.changeSize(5,40);
            bar.moveHorizontal((count-1) * 50);
            bar.makeVisible();
            rectangles.add(bar);
        }
        int pivot = xPosition;
        for (int i = 0; i < points; i++){
            Circle point = new Circle();
            point.moveHorizontal(xPosition);
            point.moveVertical(yPosition - 20);
            //point.changeColor("black");
            point.changeSize(10);
            xPosition += 15;
            point.moveHorizontal((count-1) * 50);
            point.makeVisible();
            circles.add(point);
        }
        xPosition = pivot;
        lenCircles = circles.size();
        lenRectangles = rectangles.size();
        lenTriangles = triangles.size();
    }
    public void setValue(int nValue){
        value = nValue;
    }
    public void random(){
        Random rand = new Random();
        int n = rand.nextInt(5000);
        setValue(n);
    }
}


