/*
Parts of the Class:
-fields (private/encapsulation - design decision)
-constructors (overloaded)
-member methods:
	-non-static or instance
		-accessors
		-modifiers
		-toString
		-other
	-static 
*/

public class Point {
	private int x;
	private int y;
	private String name;
	
	//constructors
	public Point() {
		/*
		x = 0;
		y = 0;
		name = "O"
		*/
		this(0,0,"O");
	}
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
		name = "A";
	}
	
	public Point (int a, int b, String s) {
		this.x = a;
		this.y = b;
		name = s;
	}
	
	//accessors - only if variables are private
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public String getName() {
		return name;
	}
	
	//modifiers - only if variables are private
	public void setX(int num) {
		x = num;
	}
	
	public void setY(int num) {
		y = num;
	}
	
	public String toString() {
		return name + "(" + x + ", " + y + ")";
	}
	
	//static method - calls on a class with parameters
	//Point.findSlope(p1, p2)
	public static double slope (Point a, Point b) {
		return ((double)(a.y - b.y))/(a.x - b.x);
	}
	
	//non-static method - calls a specific instance of class
	//p.findSlope(p1)
	public double slope (Point p) {
		return ((double)(this.y - p.y))/(this.x - p.x);
	}
	
	//static 
	public static double getDistance (Point a, Point b) {
		return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
	}
	
	//non-static
	public double getDistance (Point p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
}