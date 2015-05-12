package pwd;

import java.util.logging.Logger;

/**
 * Check strength of a password string
 * 
 */
public class CheckStrength {

	public enum LEVEL {
		EASY, MEDIUM, STRONG, VERY_STRONG, EXTREMELY_STRONG
	}

	/*
         LETTERS TYPE NUM = 1;
	 LETTERS TYPE SMALL_LETTER = 2;
	 LETTERS TYPE CAPITAL_LETTER = 3;
	 LETTERS TYPE OTHER_CHAR = 4;*/
        static final int [] LETTERS = {1,2,3,4};
       // static final int NUM=1;
       // private static final int SMALL_LETTER=2;
        //private static final int CAPITAL_LETTER=3;
        //private static final int OTHER_CHAR=4;

	/**
	 * Simple password dictionary
	 */
	private final static String[] DICTIONARY = { "password", "abc123", "iloveyou", "adobe123", "123123", "sunshine",
			"1314520", "a1b2c3", "123qwe", "aaa111", "qweasd", "admin", "passwd","abcdefghijklmnopqrstuvwxyz","ABCDEFGHIJKLMNOPQRSTUVWXYZ" ,"qwertyuiop","asdfghjkl","zxcvbnm"};

	/**
	 * Check character's type, includes num, capital letter, small letter and other character.
	 * 
	 * @param letter
	 * @return
	 */
	private static int checkCharacterType(char letter) {
		if (Character.isDigit(letter)) {
        		 return LETTERS[0];
        	}
        	if (Character.isUpperCase(letter)) {
            		return LETTERS[2];
        	}
        	if (Character.isLowerCase(letter)) {
            		return LETTERS[1];
        	}
           	return LETTERS[3];
	}

	/**
	 * Count password's number by different type
	 * 
	 * @param passwd
	 * @param type
	 * @return quantity of occurrence of a kind of letter
	 */
	static int [] countLetter(String passwd, int [] type) {
		int [] count = {0,0,0,0};
		if (null != passwd && passwd.length() > 0) {
			for(int i=0; i< LETTERS.length;i++){
                            for (char letter : passwd.toCharArray()) {
                                    if (checkCharacterType(letter) == type[i]) {
                                            count[i]++;
                                    }
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
	 *  Calculate  points of security of password based on password's length
	 * 
	 * @param password
	 * @return level
	 */
        private static int calculateLenghtPoints(String password){
            int len = password.length();
            int level=0;
            if (len > 12) {
			level++;
			if (len >= 16) {
				level++;
			}
		}
            return level;
        }
        /**
	 *  Verifying if the type exists on the string
	 * 
	 * @param password
	 * @return level
	 */
        private static int  verifyPoints( String password, int [] type_vector ){  
            int level=0;
            int [] qtd_tipo;
            qtd_tipo=countLetter(password, type_vector);
            for( int type : qtd_tipo){
                if(type>0){
                    level++;
                }
            }
           
             
            
            return level;
        }
           /**
	 *  Calculate points of security of password based on some patterns
	 * 
	 * @param password
	 * @return level
         * 
         */ 
        private static int calculatePoints (String password, int [] type){
         int level=0,level_real=0;
            int len = password.length();
            level+=verifyPoints(password,type);
            level_real=level;
            if (len > 4 && level>=2) {
			level_real++;
		}
		if (len > 6 && level>=3) {
			level_real++;
		}
		if (len > 8 && level>=4) {
			level_real++;
		}
                level_real+=calculateLenghtPoints(password);
            return level_real;
	       }

        
        /**
	 *  Increase points of security of password based on some patterns
	 * 
	 * @param password
	 * @return level
	 */
	private static int increasePoints(String password,int []  qtd_tipo){
	    int level =0;
            level=calculatePoints(password,LETTERS);
	    int len = password.length();
            
		if (len > 6 && (qtd_tipo[0] >= 3 || qtd_tipo[1] >= 3 || qtd_tipo[2] >= 3) && qtd_tipo[3] >= 2
                || len > 6 && qtd_tipo[3] <= 2 && ((qtd_tipo[0] >= 3 && qtd_tipo[1] >= 3) || (qtd_tipo[0] >= 3 && qtd_tipo[2] >= 3) || (qtd_tipo[2] >= 3 && qtd_tipo[1] >= 3))) {
			level++;
		}
		if (len > 8) {
                    int count=0;
                        for( int x : qtd_tipo){
                            if(x>=2){
                                count++;      
                            }
                        }
                        if(count>=3){
                            level++;
                        }
			
		}
		if (len > 10 && qtd_tipo[0] >= 2 && qtd_tipo[1] >= 2 && qtd_tipo[2] >= 2 && qtd_tipo[3] >= 2) {
			level++;
		}
                if (qtd_tipo[3] >= 3) {
                                level++;
                           }
                           if (qtd_tipo[3] >= 6) {
                               level++;
                           }   


		
            return level;
        }
        /**
	 *  Decrease points of security of password based on some patterns
	 * 
	 * @param password
	 * @return level
	 */
        private static int decreasePoints(String password, int [] qtd_tipo ){
            int len = password.length();
		int level = 0;
      
		if (StringUtils.isNumeric(password) && ("01234567890".indexOf(password) > 0 || "09876543210".indexOf(password) > 0)) {
			level++;
		}

		if (qtd_tipo[0]== len || qtd_tipo[1] == len || qtd_tipo[2] == len) {
			level++;
		}

		if (len % 2 == 0) { // aaabbb
			String part1 = password.substring(0, len / 2);
			String part2 = password.substring(len / 2);
			if (part1.equals(part2)) {
				level++;
			}
			if (StringUtils.isCharEqual(part1) && StringUtils.isCharEqual(part2)) {
				level++;
			}
		}
		if (len % 3 == 0) { // ababab
			String part1 = password.substring(0, len / 3);
			String part2 = password.substring(len / 3, len / 3 * 2);
			String part3 = password.substring(len / 3 * 2);
			if (part1.equals(part2) && part2.equals(part3)) {
				level++;
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
				level++;
			}
		}

		if (null != DICTIONARY && DICTIONARY.length > 0) {// dictionary
			for (int i = 0; i < DICTIONARY.length; i++) {
				if (password.equals(DICTIONARY[i]) || DICTIONARY[i].indexOf(password) >= 0) {
					level++;
					break;
				}
			}
		}

		if (len <= 6) {
			level++;
			if (len <= 4) {
				level++;
				if (len <= 3) {
					level = -1;
				}
			}
		}

		if (StringUtils.isCharEqual(password)) {
			level = -1;
		}

		//if (level < 0) {
		//	level = 0;
		//}

		return level;
        }
	/**
	 * verifying the password strength, increasing or decreasing security level password
	 * 
	 * @param password
	 * @return strength level
	 */
	public static int checkPasswordStrength(String password) {  
            int [] qtd_tipo;
            qtd_tipo=countLetter(password, LETTERS);
		try{ 
                    checkPasswordEmpty(password);
                }
                catch(Exception e){
                    logError(e);
                }
                int increasePoints = increasePoints(password, qtd_tipo);
		int decreasePoints = decreasePoints(password, qtd_tipo);
                if( decreasePoints <0 || increasePoints-decreasePoints<0){
                    return 0;
                }                
            return increasePoints-decreasePoints;
	}

	/**
	 * Get password strength level, includes easy, medium, strong, very strong, extremely strong
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
				return LEVEL.MEDIUM;
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