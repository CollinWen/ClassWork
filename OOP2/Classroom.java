import java.util.ArrayList;

public class Classroom {
	private ArrayList<Student> students;
	private String course;
	private int roomNumber;
	
	//Constructors
	public Classroom() {
		this(1, "English 1", 100);
	}
	public Classroom(int size, String s, int r) {
		students = new ArrayList<Student>();
		for(int i = 0; i < size; i++) {
			students.add(new Student());
		}
		
		course = s;
		roomNumber = r;
	}
	
	//Accessors
	public ArrayList<Student> getStudents() {
		return students;
	}
	public String getCourse() {
		return course;
	}
	public int getRoomNum() {
		return roomNumber;
	}
	
	//Modifiers
	public void setStudent(int index, Student s) {
		students.set(index, s);
	}
	public void addStudent(Student s) {
		students.add(s);
	}
	public void setCourse(String s) {
		course = s;
	}
	public void setRoomNum(int i) {
		roomNumber = i;
	}
	
	public static double averageAge(ArrayList<Student> a) {
		int x = 0;
		for(int i = 0; i < a.size(); i++) {
			x += a.get(i).getAge();
		}
		if(a.size() == 0) {
			return 0;
		} else {
			return (double)x/a.size();
		}
	}
	
	public String toString() {
		String s = course + " (Room: " + roomNumber + ") " + "[";
		for(int i = 0; i < students.size(); i++) {
			s += students.get(i).toString();
			if(i != students.size() - 1) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
}