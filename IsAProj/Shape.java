import java.util.ArrayList;
/**
 * Shape superclass. Has two subclasses: Square and Triangle. For each shape there are two fields,
 * String name and ArrayList<Integer> sides. There are contructors (including default), modifiers
 * accessors, and other methods. There are overridden toString and equals methods, and also basic
 * and area methods (the area method is overridden in subclasses to properly calculate the area).
 * 
 * @CollinWen
 */
public class Shape
{
    private ArrayList<Integer> sides;
    private String name;
    
    public Shape() {
        this(0,0,"Shape");
    }
    public Shape(int num, int sideLength, String name) {
        sides = new ArrayList<Integer>();
        for(int i = 0; i < num; i++) {
            sides.add(sideLength);
        }
        this.name = name;
    }
    public ArrayList<Integer> getSides() {
        return sides;
    }
    public String getName() {
        return name;
    }
    public int numSides() {
        return sides.size();
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    public String toString(String shapeType) {
        return shapeType + " " + this.name;
    }
    public boolean equals(Shape s) {
       return this.getSides().get(0) == s.getSides().get(0) && this.numSides() == s.numSides(); 
    }
    
    public int getPerimeter() {
        return this.numSides() * this.getSides().get(0);
    }
    public static int getPerimeter(Shape s) {
        return s.numSides() * s.getSides().get(0);
    }
    public double area() {
        System.out.println("Area could not be calculated because your shape must be specified.");
        return -1;
    }
}
