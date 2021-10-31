package Task_2;

import java.text.DecimalFormat;

public class GroupSet extends Component {
	private int gears;

	public GroupSet(String id, String name, int gears, int price) {
		super(id, name, price);
		this.gears = gears;
	}

	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

	public String toString() {
		DecimalFormat oneDecimal = new DecimalFormat("0.0");
		return super.getId() + ": " + super.getName() + " group set, " + gears + " gears, "
		+ oneDecimal.format(super.getPrice()).replace(',', '.') + " euros";
	}

}
