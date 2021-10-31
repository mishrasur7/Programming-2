package Task_2;

import java.text.DecimalFormat;

public class Frame extends Component{
	private String material; 

	public Frame(String id, String name, String material, int price) {
		super(id, name, price);
		this.material = material; 
	}
	
	public String getMaterial() {
		return material; 
	}
	
	public void setMaterial(String material) {
		this.material = material; 
	}
	
	public String toString() {
		DecimalFormat oneDecimal = new DecimalFormat("0.0"); 
		return super.getId() + ": " + super.getName() + material + " frame, " + 
				oneDecimal.format(super.getPrice()).replace(',', '.') + " euros"; 
	}

}
