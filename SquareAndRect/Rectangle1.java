
/**
 * Write a description of class Rectangle1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle1
{
    private int sideLength;
    private int sideWidth;
   
    public Rectangle1() {
        sideLength = 1;
        sideWidth = 1;
    }
    public Rectangle1(int sL, int sW) {
        sideLength = sL;
        sideWidth = sW;
    }
    public int getSL() {
        return sideLength;
    }
    public int getSW() {
        return sideWidth;
    }
    public void setSL(int sL) {
        sideLength = sL;
    }
    public void setSW(int sW) {
        sideWidth = sW;
    }
    
    public String toString() {
        return "Side Length: " + sideLength + " Side Width: " + sideWidth;
    }
    public boolean equals(Rectangle1 r) {
        return this.sideLength == r.sideLength && this.sideWidth == r.sideWidth;
    }
    public int getArea() {
        return sideLength*sideWidth;
    }
    public int getPerimeter() {
        return (2*sideLength) + (2*sideWidth);
    }
}
