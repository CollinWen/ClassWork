
/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square
{
    private int sideLength;
    
    public Square() {
        sideLength = 1;
    }
    public Square(int s) {
        sideLength = s;
    }
    public boolean equals(Square s) {
        return this.sideLength == s.sideLength;
    }
    public String toString() {
        return "The side length of the square is" + sideLength;
    }
    public int getSideLength() {
        return sideLength;
    }
    public double area() {
        return sideLength * sideLength;
    }
}
