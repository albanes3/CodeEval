
public class First1000Primes {
	public static void main(String[] args){
		int numPrimes = 0;
		int numCount = 2;
		int primeSum = 0;
		boolean isPrime;
		while(numPrimes < 1000){
			isPrime = true;
			for(int i = 2 ; i <= numCount/2; i++){
				if(numCount % i == 0){
					isPrime = false;
					break;
				}	
			}
			if(isPrime){
				primeSum += numCount;
				numPrimes++;
			}
			numCount++;
		}
		System.out.println(primeSum);
	}
}
