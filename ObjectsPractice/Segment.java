public class Segment {
	//class fields (encapsulation)
	private Point p1;
	private Point p2;
	private String name;
	
	public Segment() {
		this(new Point(), new Point(3,4));
	}
	
	public Segment(Point a, Point b) {
		p1 = a;
		p2 = b;
		name = a.getName() + b.getName();
	}
	
	//accessors
	public Point getP1() {
		return p1;
	}
	
	public Point getP2() {
		return p2;
	}
	
	public String getName() {
		return name;
	}
	
	//modifiers
	public void setP1(Point p) {
		p1 = p;
	}
	
	public void setP2(Point p) {
		p2 = p;
	}
	
	public void setName(String n) {
		name = p1.getName() + p2.getName();
	}
	
	//toString implementation - 0(0,0) A(3,4)
	public String toString() {
		return p1.toString() + " " + p2.toString();
	}
	
	public double getLength () {
		return p1.getDistance(p2);
	}
}