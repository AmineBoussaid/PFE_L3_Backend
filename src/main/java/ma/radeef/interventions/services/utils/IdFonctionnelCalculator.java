package ma.radeef.interventions.services.utils;

public class IdFonctionnelCalculator {

	public static String create() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			result += getRandomNumber('0', '9');
		}
		for (int i = 10; i < 20; i++) {
			result += getRandomNumber('A', 'Z');
		}
		return result;
	}

	private static char getRandomNumber(int min, int max) {
		return (char) ((Math.random() * (max - min)) + min);
	}

}
