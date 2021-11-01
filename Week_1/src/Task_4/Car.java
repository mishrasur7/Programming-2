package Task_4;

import java.text.DecimalFormat;

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
		DecimalFormat oneDecimal = new DecimalFormat("0.0"); 
		return "Car: " + super.getModel() + " ( value " + oneDecimal.format(value).replace(',', '.') + " euros)" ; 
	}

}
