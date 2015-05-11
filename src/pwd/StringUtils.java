package pwd;

/**
 * {@code StringUtils} contains static methods which operate on a string.
 */
public class StringUtils {

	private final static int[] SIZE_TABLE = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999,
			Integer.MAX_VALUE };

	/**
	 * calculate the size of an integer number
	 * 
	 * @param number
	 * @return
	 */
	public static int sizeOfInt(int number) {
		for (int i = 0;; i++)
			if (number <= SIZE_TABLE[i]) {
				return i + 1;
			}
	}

	/**
	 * Judge whether each character of the string equals
	 * 
	 * @param word
	 * @return
	 */
        public static boolean isCharEqual(String word) {
		return word.replace(word.charAt(0), ' ').trim().length() == 0;
	}

	/**
	 * Determines if the string is a digit
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isNumeric(String word) {
		for (int i = word.length(); --i >= 0;) {
			if (!Character.isDigit(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Judge whether the string is whitespace, empty ("") or null.
	 * 
	 * @param word
	 * @return
	 */
	public static boolean equalsNull(String word) {
		int strLen;
		if (word == null || (strLen = word.length()) == 0 ) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(word.charAt(i)) == false)) {
                            return false;
			}
		}
		return true;
	}

}