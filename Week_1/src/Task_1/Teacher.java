package Task_1;

import java.text.DecimalFormat;

public class Teacher extends Person {
	private int salary;

	public Teacher(String name, int salary) {
		super(name);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		DecimalFormat oneDecimal = new DecimalFormat("0.0");
		return "Teacher: " + super.getName() + "," + " salary is " + oneDecimal.format(salary).replace(',', '.');
	}

}
