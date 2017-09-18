package other;

public class NthPrime {

	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++){
			System.out.println(nthPrime(i));
		}

	}

	static int nthPrime(int n){
		int count=0;
		int num = 1;
		while(count<n){
			num++;
			if(isPrime(num)){
				count++;
			}
		}
		return num;
		
	}

	static boolean isPrime(int num) {
		int maxDiv = (int) Math.sqrt(num);
		boolean prime = true;
		for (int i = 2; i <= maxDiv; i++) {
			if (num % i == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}

}
