package ma.radeef.interventions.services.utils;

import java.util.Random;

public class IdFonctionnelCalculator {
	
    private static Random random = new Random();


	public static String create() {
		String result = "REC-";
		int size = 16;
		for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) {
                // Ajouter un chiffre
                result += getRandomNumber('0', '9');
            } else {
                // Ajouter une lettre
                result += getRandomNumber('A', 'Z');
            }
        }
        return result;
    }

	private static char getRandomNumber(int min, int max) {
		return (char) ((Math.random() * (max - min)) + min);
	}

}
