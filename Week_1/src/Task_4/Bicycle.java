package Task_4;

import java.text.DecimalFormat;

public class Bicycle implements Ownable {
	private String name;
	private int value;

	public Bicycle(String name, int value) {
		this.name = name;
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
		return "Bicycle: " + name + " ( value " + oneDecimal.format(value).replace(',', '.') + " euros)";
	}

}
