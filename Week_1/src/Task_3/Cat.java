package Task_3;

public class Cat implements NoisyPet {

	@Override
	public void makeSound() {
		System.out.println("Cat says meow!");

	}

	@Override
	public void play() {
		System.out.println("Cat is playing with the ball of yarn.");

	}

}
