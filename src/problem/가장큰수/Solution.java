package problem.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public static void main(String[] args) {
		int[] numbers = new int[] { 101,101111 };
		System.out.println(new Solution().solution(numbers));
	}

	public String solution(int[] numbers) {
		boolean allZero = true;
		String[] strNumbers = new String[numbers.length];
		for (int i = 0; i < strNumbers.length; i++) {
			strNumbers[i] = String.valueOf(numbers[i]);
			if(numbers[i] > 0){
				allZero = false;
			}
		}
		
		if(allZero){
			return "0";
		}
		

		Arrays.sort(strNumbers, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int length = o1.length() > o2.length() ? o1.length() : o2.length();
				for (int i = 0; i < length; i++) {
					int o1Val = 0;
					if (o1.length() < i + 1) {
						o1Val = Integer.parseInt(o1.substring(0, 1));
					} else {
						o1Val = Integer.parseInt(o1.substring(i, i + 1));
					}

					int o2Val = 0;
					if (o2.length() < i + 1) {
						o2Val = Integer.parseInt(o2.substring(0, 1));
					} else {
						o2Val = Integer.parseInt(o2.substring(i, i + 1));
					}
					if (o1Val != o2Val) {
						return o2Val - o1Val;
					}
				}

				if(Integer.parseInt(o1 + o2) > Integer.parseInt(o2 + o1)){
					return -1;
				}else{
					return 1;
				}
			}
		});

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strNumbers.length; i++) {
			sb.append(strNumbers[i]);
		}
		
		return sb.toString();
	}

}