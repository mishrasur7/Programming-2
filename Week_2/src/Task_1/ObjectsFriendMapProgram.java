package Task_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ObjectsFriendMapProgram {
	private static Map<String, Friend> friendMap = new HashMap<String, Friend>();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		displayMenu();
		int choice = getChoice();

		while (choice != 0) {
			if (choice == 1) {
				addFriend();
			} else if (choice == 2) {
				findFriend();
			} else if (choice == 3) {
				deleteFriend();
			} else if (choice == 4) {
				printFriends();
			} else {
				System.out.println("Please enter a number between 0 and 4");
				displayMenu();
			}

			choice = getChoice();

		}

		System.out.println("Bye!");
	}

	// displayMenu method will be used to display the heading while having user
	// transactions
	public static void displayMenu() {
		System.out.print("1 = Add friend | 2 = Find friend | 3 = Delete friend | 4 = Print friends | 0 = Quit\n"
				+ "Enter choice: ");
	}

	// getChoice method will read the choice from the users
	private static int getChoice() {
		Scanner input = new Scanner(System.in);
		int choice;
		try {
			return choice = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a number between 0 and 4");
			displayMenu();
		}
		return getChoice();

	}

	// addFriend method will read nickname, name and birthdate from user and add it
	// into the hashmap
	public static void addFriend() {

		System.out.print("Enter nickname: ");
		String nickName = input.nextLine();

		if (friendMap.containsKey(nickName)) {
			System.out.println(nickName + " is already in use!");

		} else {
			System.out.print("Enter name: ");
			String name = input.nextLine();
			System.out.print("Enter birthdate (dd.mm.yyyy): ");
			String birthDate = input.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); 
			
			try {
				LocalDate localDate = LocalDate.parse(birthDate, formatter); 
				Friend friend1 = new Friend(nickName, name, birthDate);
				friendMap.put(nickName, friend1);
			} catch (Exception e) {
				System.out.println("Invalid date: " + birthDate);
			}
			
			
		}

		displayMenu();

	}

	public static void findFriend() {
		System.out.print("Enter nickname: ");
		String nickName = input.nextLine();
		if (friendMap.containsKey(nickName)) {
			System.out.print(friendMap.get(nickName));
		} else {
			System.out.print(nickName + " not found!");
		}
	}

	public static void deleteFriend() {
		System.out.print("Enter nickname: ");
		String nickName = input.nextLine();
		if (friendMap.containsKey(nickName)) {
			System.out.print(friendMap.remove(nickName));
		} else {
			System.out.print(nickName + " not found!");
		}
	}

	public static void printFriends() {
		for (Friend friends : friendMap.values()) {
			System.out.print(friends + "\n");
		}
	}

}
