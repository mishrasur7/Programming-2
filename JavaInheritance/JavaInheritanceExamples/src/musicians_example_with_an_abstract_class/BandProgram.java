package musicians_example_with_an_abstract_class;

import java.util.List;
import java.util.ArrayList;

public class BandProgram {

	public static void main(String[] args) {

		List<Musician> bandMembers = new ArrayList<Musician>();

		System.out.println("=== The band plays as below ===");
		bandMembers.add(new Guitarist("Megan Lowell"));
		bandMembers.add(new Guitarist("Rebecca Lowell"));
		bandMembers.add(new Drummer("Sheila E"));

		for (Musician musician : bandMembers) {
			musician.play();
		}
	}
}
