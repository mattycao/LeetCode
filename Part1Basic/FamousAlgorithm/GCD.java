/*
 * Eucid's algorithm:
 * Find the greatest common division of two nonnegative integer p and q.
 */
public class GCD {
	int gcd(int p, int q) {
		if(q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
}