package Task_4;

public class Car extends MotorVehicle implements Ownable{
	private int value; 

	public Car(String model, int value) {
		super(model);
		this.value = value; 
	}
	
	public int getValue() {
		return value; 
	}
	
	public void setValue(int value) {
		this.value = value; 
	}
	
	public String toString() {
		return "Car: " + super.getModel() + " ( value " + value + " euros)" ; 
	}

}
