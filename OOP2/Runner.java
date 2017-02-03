public class Runner {
	public static void main(String[] args) {
		
		Classroom c = new Classroom(0, "Math 3", 250);
		Student s1 = new Student("John", 10, 5);
		Student s2 = new Student("Carl", 11, 6);
		Student s3 = new Student("Jim", 9, 5);
		Student s4 = new Student("Mary", 12, 6);
		
		c.addStudent(s1);
		c.addStudent(s2);
		c.addStudent(s3);
		c.addStudent(s4);
		
		System.out.println(c);
		System.out.println(Classroom.averageAge(c.getStudents()));
		
		System.out.println("Total Students: " + Student.getNumStudents());
		
	}
}