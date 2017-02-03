import java.util.ArrayList;

public class Student {

	private String name;
	private int age; 
	private int grade;
	private static int numStudents;
	
	//Constructors
	public Student() {
		this("EMPTY", 0, 0);
	}
	public Student(String name, int age, int grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		numStudents++;
	}
	
	//Accessors
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public int getGrade() {
		return this.grade;
	}
	public static int getNumStudents() {
		return numStudents;
	}
	
	//Modifiers
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return "Name: " + this.name + " Age: " + this.age + " Grade: " + this.grade;
	}
	
}