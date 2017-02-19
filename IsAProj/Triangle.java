
/**
 * Triangle subclass of superclass Shape. Overrides toString, getPerimeter, and area methods.
 * Adds extra field: double height is used to calculate area.
 * 
 * @CollinWen
 */
public class Triangle extends Shape
{
    private double height;
    public Triangle() {
        this(3, "A");
    }
    public Triangle(int length, String name) {
        super(3, length, name);
        height = 1.5*Math.sqrt(3);
    }
    
    @Override
    public String toString() {
        return "Triangle " + this.getName() + " (Side Length: " + this.getSides().get(0) + ")";
    }
    
    @Override
    public int getPerimeter() {
        return 3*this.getSides().get(0);
    }
    @Override
    public double area() {
        return 0.5*(this.getSides().get(0)/2)*(height);
    }
}
