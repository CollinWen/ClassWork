public class Triangle {
	private Segment s1;
	private Segment s2;
	private Segment s3;
	private String name;
	
	//constructors (default, overloaded)
	public Triangle () {
		this(new Segment(new Point(0,0,"A"), new Point(6,0,"B")), 
			new Segment(new Point(6,0,"B"), new Point(0,8,"C")), 
			new Segment(new Point(0,8,"C"), new Point(0,0,"A")), "ABC");
	}
	public Triangle (Segment side1, Segment side2, Segment side3, String s) {
		s1 = side1;
		s2 = side2;
		s3 = side3;
		name = s;
	}
	
	//accessors
	public Segment getS1 () {
		return s1;
	}
	public Segment getS2 () {
		return s2;
	}
	public Segment getS3 () {
		return s3;
	}
	public String name () {
		return name;
	}
	
	//modifiers
	public void setS1 (Segment segment) {
		s1 = segment;
	}
	public void setS2 (Segment segment) {
		s2 = segment;
	}
	public void setS3 (Segment segment) {
		s3 = segment;
	}
	public void setName (String s) {
		name = s;
	}
	
	//toString
	public String toString () {
		return s1.toString() + ", " + s2.toString() + ", " + s3.toString();
	}
	
	public double perimeter() {
		return s1.getLength() + s2.getLength() + s3.getLength();
	}
	
	public double area() {
		double s = this.perimeter()/2;
		return Math.sqrt(s * (s-s1.getLength()) * (s-s2.getLength()) * (s-s3.getLength()));
	}
}