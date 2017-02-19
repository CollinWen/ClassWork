
/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Square {
    private int sideWidth;
    
    public Rectangle() {
        this(1,2);
    }
    public Rectangle(int l, int w) {
        super(l);
        sideWidth = 2;
    }
    public int getSideWidth() {
        return sideWidth;
    }
    public void setSideWidth(int w) {
        sideWidth = w;
    }
    public double area() {
        return this.getSideLength() * sideWidth;
    }
}
