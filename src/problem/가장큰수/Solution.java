package problem.가장큰수;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public static void main(String[] args) {
		int[] numbers = new int[] { 0, 0, 0, 999999999 };
		System.out.println(new Solution().solution(numbers));
	}

	public String solution(int[] numbers) {
		boolean allZero = true;
		String[] strNumbers = new String[numbers.length];
		for (int i = 0; i < strNumbers.length; i++) {
			strNumbers[i] = String.valueOf(numbers[i]);
			if (numbers[i] > 0) {
				allZero = false;
			}
		}
		if (allZero) {
			return "0";
		}

		Arrays.sort(strNumbers, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.startsWith("0")) {
					return 1;
				}
				if (o2.startsWith("0")) {
					return -1;
				}

				BigInteger bigInteger = new BigInteger(o1 + o2);
				BigInteger bigInteger2 = new BigInteger(o2 + o1);
				return -bigInteger.compareTo(bigInteger2);
			}
		});

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strNumbers.length; i++) {
			sb.append(strNumbers[i]);
		}

		return sb.toString();
	}

}