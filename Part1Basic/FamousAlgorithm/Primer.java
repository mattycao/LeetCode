/*
 * TO check whether the number is primer
 */
public class Primer {
	public boolean isPrimer(int num) {
		if(num < 2) return false;
		for(int i = 2; i*i < num; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
}