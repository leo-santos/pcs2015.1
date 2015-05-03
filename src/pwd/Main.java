package pwd;

/**
 * Test password level
 * 
 */
public class Main {

	public static void main(String[] args) {
		String passwd = "2hAj5#mne-ix.86H";
		System.out.println(CheckStrength.checkPasswordStrength(passwd));
                System.out.println(StringUtils.isCharEqual("0000"));
	}

}