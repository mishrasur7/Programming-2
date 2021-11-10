package Task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ObjectsLanguageTranslationMap {

	public static void main(String[] args) {
		System.out.println("=== Creating an English-Finnish dictionary (ok ends) ===");

		Map<String, String> wordPairs = new HashMap<String, String>();

		Scanner input = new Scanner(System.in);
		System.out.print("Enter an english word: ");
		String englishWord = input.nextLine();

		int count = 1;
		while (!englishWord.equals("ok")) {

			System.out.print("Enter a finnish word: ");
			String finnishWord = input.nextLine();
			wordPairs.put(englishWord, finnishWord);

			System.out.print("Enter an english word: ");
			englishWord = input.nextLine();
			count++;
		}

		System.out.println();
		System.out.println("=== English-Finnish translation service (quit ends) ===");
		System.out.print("Enter an english word: ");
		String engWord = input.nextLine();

		while (!engWord.equals("quit")) {
			boolean found = false;
			int index = 0;
			for (int i = 0; i < wordPairs.size(); i++) {
				if (wordPairs.containsKey(engWord)) {
					found = true;
					index = i;
				}
			}
			if (found == true) {
				System.out.println(wordPairs.get(engWord));
				System.out.print("Enter an english word: ");
				engWord = input.nextLine();
			} else if (found == false) {
				System.out.println("Unknown word");
				System.out.print("Enter an english word: ");
				engWord = input.nextLine();
			}

		}
		System.out.println("Bye!");
		input.close();

	}

}
