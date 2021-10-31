package Task_3;

public class NoisyPetInterfaceProgram {

	public static void main(String[] args) {
		NoisyPet[] noisyPets = new NoisyPet[3]; 
		
		Cat cat = new Cat(); 
		Dog dog = new Dog(); 
		Parrot parrot = new Parrot(); 
		noisyPets[0] = new Cat(); 
		noisyPets[1] = new Dog(); 
		noisyPets[2] = new Parrot();
		
		for(NoisyPet noisyPet : noisyPets) {
			noisyPet.makeSound();
		}
		
		System.out.println();
		
		for(NoisyPet noisyPet : noisyPets) {
			noisyPet.play();;
		}

	}

}
