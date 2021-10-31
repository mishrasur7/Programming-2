package Task_3;

public class Dog implements NoisyPet {

	@Override
	public void makeSound() {
		System.out.println("Dog says woof, woof!");

	}

	@Override
	public void play() {

		System.out.println("Dog is fetching the ball.");
	}

}
