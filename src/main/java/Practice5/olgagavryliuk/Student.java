package Practice5.olgagavryliuk;

public class Student {
	private int studentId;
	private String pib;
	private int course;
	
	public Student(){
		
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public Student(int studentId, String pib, int course) {
		super();
		this.studentId = studentId;
		this.pib = pib;
		this.course = course;
	}
}
