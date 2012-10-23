/* 
 * Solution to Project Euler problem 65
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */

import java.math.BigInteger;


public class p065 {
	
	public static void main(String[] args) {
		BigInteger n = BigInteger.ONE;
		BigInteger d = BigInteger.ZERO;
		for (int i = 99; i >= 0; i--) {
			BigInteger temp = BigInteger.valueOf(continuedFractionTerm(i)).multiply(n).add(d);
			d = n;
			n = temp;
		}
		
		int sum = 0;
		while (!n.equals(BigInteger.ZERO)) {
			BigInteger[] divrem = n.divideAndRemainder(BigInteger.TEN);
			sum += divrem[1].intValue();
			n = divrem[0];
		}
		System.out.println(sum);
	}
	
	
	private static int continuedFractionTerm(int i) {
		if (i == 0)
			return 2;
		else if (i % 3 == 2)
			return i / 3 * 2 + 2;
		else
			return 1;
	}
	
}