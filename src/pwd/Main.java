package pwd;

/**
 * Test password level
 * 
 */
public class Main {

	public static void main(String[] args) {
		String passwd = "2hAj5#mne-ix.86H";		
                System.out.println(CheckStrength.getPasswordLevel("135#aet"));
                System.out.println(CheckStrength.getPasswordLevel(passwd));
                System.out.println(CheckStrength.getPasswordLevel("0"));
                System.out.println(CheckStrength.getPasswordLevel("00aa"));
                System.out.println(CheckStrength.getPasswordLevel("0aaaQ"));
                System.out.println(CheckStrength.getPasswordLevel("2371213278123"));
                System.out.println(CheckStrength.getPasswordLevel("00aahd73hed2d2uyu"));
                System.out.println(CheckStrength.getPasswordLevel("0aaaQ9sd9u29d9H9WDx"));
                System.out.println(CheckStrength.getPasswordLevel("0aaaQ9sd9u2#9d9H9WDx."));
                System.out.println(CheckStrength.getPasswordLevel("0@H9WDx"));
                
	}

}