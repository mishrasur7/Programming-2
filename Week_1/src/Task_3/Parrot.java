package Task_3;

public class Parrot implements NoisyPet {

	@Override
	public void makeSound() {
		System.out.println("Parrot says 'Polly wants a cracker!'");

	}

	@Override
	public void play() {

		System.out.println("Parrot is flying around.");

	}

}
