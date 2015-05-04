
package pwd;

import java.util.logging.Logger;

/**
 * Check strength of a password string
 * 
 */
public class CheckStrength {

	public enum LEVEL {
		EASY, MIDIUM, STRONG, VERY_STRONG, EXTREMELY_STRONG
	}

	private static final int NUM = 1;
	private static final int SMALL_LETTER = 2;
	private static final int CAPITAL_LETTER = 3;
	private static final int OTHER_CHAR = 4;

	/**
	 * Simple password dictionary
	 */
	private final static String[] DICTIONARY = { "password", "abc123", "iloveyou", "adobe123", "123123", "sunshine",
			"1314520", "a1b2c3", "123qwe", "aaa111", "qweasd", "admin", "passwd" };

	/**
	 * Check character's type, includes num, capital letter, small letter and other character.
	 * 
	 * @param letter
	 * @return
	 */
	private static int checkCharacterType(char letter) {
		if (letter >= 48 && letter <= 57) {
			return NUM;
		}
		if (letter >= 65 && letter <= 90) {
			return CAPITAL_LETTER;
		}
		if (letter >= 97 && letter <= 122) {
			return SMALL_LETTER;
		}
		return OTHER_CHAR;
	}

	/**
	 * Count password's number by different type
	 * 
	 * @param passwd
	 * @param type
	 * @return quantity of occurrence of a kind of letter
	 */
	private static int countLetter(String passwd, int type) {
		int count = 0;
		if (null != passwd && passwd.length() > 0) {
			for (char letter : passwd.toCharArray()) {
				if (checkCharacterType(letter) == type) {
					count++;
				}
			}
		}
		return count;
	}
        
         /**
	 * Verifying if the string is empty
	 * 
	 * @param password
	 * @return
	 */
        private static void checkPasswordEmpty(String password) throws Exception{
            if (StringUtils.equalsNull(password)) {
			throw new Exception();
		}
        }
        
        
        private static void logError(Exception e) {
            Logger.getLogger(e.getMessage());
        }
        
        /**
	 *  Verifying if the type exists on the string
	 * 
	 * @param password
	 * @return
	 */
        private static int verifyPoints( String password, int type){   
            if(countLetter(password, type)>0){
                   return 1;
               }
            return 0;
        }
           /**
	 *  Calculate points of security of password based on some patterns
	 * 
	 * @param password
	 * @return
         * 
         */ 
        private static int calculatePoints (String password){
         int level=0;
         int len = password.length();
            level+=verifyPoints(password,NUM);
	    level+=verifyPoints(password,SMALL_LETTER);
            level+=verifyPoints(password,CAPITAL_LETTER);
            level+=verifyPoints(password,OTHER_CHAR);
            if (len > 4 && level>2) {
			level++;
                }
		if (len > 6 && level>3) {
			level++;
		}

		if (len > 8 && level > 4 ) {
			level++;
		}
            return level;
	       }

        
        /**
	 *  Increase points of security of password based on some patterns
	 * 
	 * @param password
	 * @return
	 */
	private static int increasePoints(String password){
            
	    int level =0;
            level=calculatePoints(password);
		
            int len = password.length();
        if (len > 6 && countLetter(password, NUM) >= 3 && countLetter(password, SMALL_LETTER) >= 3 
                    || countLetter(password, NUM) >= 3 && countLetter(password, CAPITAL_LETTER) >= 3 
                    || countLetter(password, NUM) >= 3 && countLetter(password, OTHER_CHAR) >= 2
                    || countLetter(password, SMALL_LETTER) >= 3 && countLetter(password, CAPITAL_LETTER) >= 3 
                    || countLetter(password, SMALL_LETTER) >= 3 && countLetter(password, OTHER_CHAR) >= 2
                    || countLetter(password, CAPITAL_LETTER) >= 3 && countLetter(password, OTHER_CHAR) >= 2) {
			level++;
		}

		if (len > 8 && countLetter(password, NUM) >= 2 && countLetter(password, SMALL_LETTER) >= 2
				&& countLetter(password, CAPITAL_LETTER) >= 2 || countLetter(password, NUM) >= 2
				&& countLetter(password, SMALL_LETTER) >= 2 && countLetter(password, OTHER_CHAR) >= 2
				|| countLetter(password, NUM) >= 2 && countLetter(password, CAPITAL_LETTER) >= 2
				&& countLetter(password, OTHER_CHAR) >= 2 || countLetter(password, SMALL_LETTER) >= 2
				&& countLetter(password, CAPITAL_LETTER) >= 2 && countLetter(password, OTHER_CHAR) >= 2) {
			level++;
		}

		if (len > 10 && countLetter(password, NUM) >= 2 && countLetter(password, SMALL_LETTER) >= 2
				&& countLetter(password, CAPITAL_LETTER) >= 2 && countLetter(password, OTHER_CHAR) >= 2) {
			level++;
		}

		if (countLetter(password, OTHER_CHAR) >= 3) {
			level++;
		}
		if (countLetter(password, OTHER_CHAR) >= 6) {
			level++;
		}

		if (len > 12) {
			level++;
			if (len >= 16) {
				level++;
			}
		}
            return level;
        }
        /**
	 *  Decrease points of security of password based on some patterns
	 * 
	 * @param password
	 * @return
	 */
        private static int decreasePoints(String password){
            int len = password.length();
		int level = 0;
        if ("abcdefghijklmnopqrstuvwxyz".indexOf(password) > 0 || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(password) > 0) {
			level--;
		}
		if ("qwertyuiop".indexOf(password) > 0 || "asdfghjkl".indexOf(password) > 0 || "zxcvbnm".indexOf(password) > 0) {
			level--;
		}
		if (StringUtils.isNumeric(password) && ("01234567890".indexOf(password) > 0 || "09876543210".indexOf(password) > 0)) {
			level--;
		}

		if (countLetter(password, NUM) == len || countLetter(password, SMALL_LETTER) == len
				|| countLetter(password, CAPITAL_LETTER) == len) {
			level--;
		}

		if (len % 2 == 0) { // aaabbb
			String part1 = password.substring(0, len / 2);
			String part2 = password.substring(len / 2);
			if (part1.equals(part2)) {
				level--;
			}
			if (StringUtils.isCharEqual(part1) && StringUtils.isCharEqual(part2)) {
				level--;
			}
		}
		if (len % 3 == 0) { // ababab
			String part1 = password.substring(0, len / 3);
			String part2 = password.substring(len / 3, len / 3 * 2);
			String part3 = password.substring(len / 3 * 2);
			if (part1.equals(part2) && part2.equals(part3)) {
				level--;
			}
		}

		if (StringUtils.isNumeric(password) && len >= 6) { // 19881010 or 881010
			int year = 0;
			if (len == 8 || len == 6) {
				year = Integer.parseInt(password.substring(0, len - 4));
			}
			int size = StringUtils.sizeOfInt(year);
			int month = Integer.parseInt(password.substring(size, size + 2));
			int day = Integer.parseInt(password.substring(size + 2, len));
			if (year >= 1950 && year < 2050 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
				level--;
			}
		}

		if (null != DICTIONARY && DICTIONARY.length > 0) {// dictionary
			for (int i = 0; i < DICTIONARY.length; i++) {
				if (password.equals(DICTIONARY[i]) || DICTIONARY[i].indexOf(password) >= 0) {
					level--;
					break;
				}
			}
		}

		if (len <= 6) {
			level--;
			if (len <= 4) {
				level--;
				if (len <= 3) {
					level = 0;
				}
			}
		}

		if (StringUtils.isCharEqual(password)) {
			level = 0;
		}

		if (level < 0) {
			level = 0;
		}

		return level;
        }
	/**
	 * verifying the password strength, increasing or decreasing security level password
	 * 
	 * @param password
	 * @return strength level
	 */
	public static int checkPasswordStrength(String password) {     
		try{ 
                    checkPasswordEmpty(password);
                }
                catch(Exception e){
                    logError(e);
                }
                int increasePoints = increasePoints(password);
		int decreasePoints = decreasePoints(password);
                
            return increasePoints-decreasePoints;
	}

	/**
	 * Get password strength level, includes easy, midium, strong, very strong, extremely strong
	 * 
	 * @param passwd
	 * @return
	 */
	public static LEVEL getPasswordLevel(String passwd) {
		int level = checkPasswordStrength(passwd);
		switch (level) {
			case 0:
			case 1:
			case 2:
			case 3:
				return LEVEL.EASY;
			case 4:
			case 5:
			case 6:
				return LEVEL.MIDIUM;
			case 7:
			case 8:
			case 9:
				return LEVEL.STRONG;
			case 10:
			case 11:
			case 12:
				return LEVEL.VERY_STRONG;
			default:
				return LEVEL.EXTREMELY_STRONG;
		}
	}

}
