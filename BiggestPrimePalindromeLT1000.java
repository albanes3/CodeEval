
public class BiggestPrimePalindromeLT1000 {
	public static void main(String[] args){
		int maxPP = 2;
		for(int i = 2; i<1000; i++){
			if(isPrime(i) && isPalindrome("" + i))
				maxPP = i;
		}
		System.out.println("" + maxPP);
	}

	private static boolean isPalindrome(String num) {
		for(int i = 0, j=num.length()-1; i<j ; i++, j--)
			if(num.charAt(i) != num.charAt(j))
				return false;
		return true;
	}

	private static boolean isPrime(int i) {
		for(int j = 2 ; j <= i/2; j++){
			if(i % j == 0){
				return false;
			}	
		}
		return true;
	}
}
