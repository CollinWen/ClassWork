
/**
 * This project was made to demonstrate an is-a relationship with classes. In this scenario, there is a 
 * superclass shape, which has two subclasses, Square and Triangle. All instances of Square and Triangle
 * are shapes, but not all shapes will be triangles or squares. All shapes, can be printed out with 
 * the toString method, and the perimeter and area can be correctly calculated (only for Triangles and 
 * Squares). However, all shapes are regular, meaning all their sides are the same length. Shapes can
 * be compared by the equals method, which checks if shapes have the same number of sides and the same 
 * sidelength.
 * 
 * @CollinWen
 */
public class Runner
{
    public static void main(String[] args) {
        Triangle t = new Triangle(4, "A");
        Square s = new Square(3, "B");
        Shape s2 = new Shape(5, 5, "Pentagon");
        
        System.out.println(t instanceof Triangle);
        //System.out.println(t instanceof Square);
        System.out.println(t instanceof Shape);
        
        //System.out.println(s instanceof Triangle);
        System.out.println(s instanceof Square);
        System.out.println(s instanceof Shape);
        
        System.out.println(s2 instanceof Triangle);
        System.out.println(s2 instanceof Square);
        System.out.println(s2 instanceof Shape);
        
        System.out.println("----------------------");
        
        System.out.println(t);
        System.out.println("Perimeter: " + t.getPerimeter());
        System.out.println("Area: " + t.area() + "\n");
        
        System.out.println(s);
        System.out.println("Perimter: " + s.getPerimeter());
        System.out.println("Area: " + s.area() + "\n");
        
        System.out.println(s2);
        System.out.println("Perimter: " + s2.getPerimeter());
        System.out.println("Area: " + s2.area() + "\n");
        
        System.out.println("----------------------");
        
        Shape s3 = new Shape(5,5,"C");
        System.out.println(s2.equals(s3));
        Shape s4 = new Shape(4,3,"D");
        System.out.println(s.equals(s4));
        Shape s5 = new Shape(3,4,"E");
        System.out.println(t.equals(s5));
    }
}
