package pwd;

/**
 * Test password level
 * 
 */
public class Main {

	public static void main(String[] args) {
		String passwd = "2hAj5#mne-ix.86H";
                String pass = null;		
                System.out.println(CheckStrength.checkPasswordStrength(passwd));
                System.out.println(CheckStrength.checkPasswordStrength("000"));
               // System.out.println(CheckStrength.checkPasswordStrength(pass));
	}

}