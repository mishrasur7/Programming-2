package Task_1;

public class Student extends Person {
	private int credits; 
	
	public Student(String name) {
		super(name);
		this.credits = 0; 
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Student: " + super.getName() + ", " + credits + " credits";
	}
	
	public int completeCourse() {
		credits = credits + 5; 
		return credits; 
	}
	

}
