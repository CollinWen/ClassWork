
/**
 * Square subclass of superclass Shape. Overrides toString, getPerimeter, and area methods.
 * 
 * @CollinWen 
 */
public class Square extends Shape
{
    public Square() {
        this(4, "A");
    }
    public Square(int length, String name) {
        super(4, length, name);
    }
    
    @Override 
    public String toString() {
        return "Square " + this.getName() + " (Side Length: " + this.getSides().get(0) + ")";
    }
    
    @Override 
    public int getPerimeter() {
        return 4*this.getSides().get(0);
    }
    @Override 
    public double area() {
        return Math.pow(this.getSides().get(0), 2);
    }
}
