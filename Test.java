import java.util.Arrays;


public class Test {
	public static void main(String[] args){
		System.out.println(getBadCharactersForPassingNamingValidation("p;123444444").toString());
	}
	public static String[] getBadCharactersForPassingNamingValidation(String password) {
	    String[] badCharacters = new String[0];
	    //return badCharacters;  
	    String badCharacter = "";
	    int j =0;
	    passwordValidation:
	    for (String character : password.split(""))
	    {
	        // fix for first empty character
	    	System.out.println(character);
	    	j++;
	        if (character != "") if (character.isEmpty() == false)
	        {
	            
	 
	            for (Integer i = 0; i < 127; i++) {
	                if (i == 48) i =123;
	                if (character.toCharArray()[0] == (char)i.intValue()) {
	                    badCharacter = character;
	                }
	            }
	 
	            if (badCharacter != "") if (badCharacter.isEmpty() == false) {
	            	System.out.println("" + badCharacters.length);
	                badCharacters = Arrays.copyOf(badCharacters, badCharacters.length + 1);
	                badCharacters[badCharacters.length - 1] = badCharacter;
	                System.out.println("" + badCharacters.length);
	            }
	            continue passwordValidation;
	        }
	    }
	    System.out.println("" + j);
	    return badCharacters;           
	}
}
