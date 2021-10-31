package Task_4;

public class Bicycle extends Object implements Ownable {
	private int value; 
	
	public Bicycle(String name, int value) {
		super(); 
		this.value = value; 
	}
	
	public int getValue() {
		return value; 
	}
	
	public void setValue(int value) {
		this.value = value; 
	}
	
	public String toString() {
		return "Bicycle: " + super.toString() + " ( value " + value + " euros)" ; 
	}
	
	

}
