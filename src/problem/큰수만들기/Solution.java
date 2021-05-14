package problem.큰수만들기;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		String number = "4321111";
		int k = 3;
		System.out.println(new Solution().solution(number, k));
	}

	public String solution(String number, int k) {
		int[] numbers = new int[number.length()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
		}

		Arrays.sort(numbers);
		ArrayList<Integer> numberList = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			if (!numberList.contains(numbers[i])) {
				numberList.add(numbers[i]);
			}
		}
		int numberListIdx = numberList.size() - 1;
		int remnant = k;
		StringBuffer sb = new StringBuffer();

		while (true) {
			int targetVal = numberList.get(numberListIdx);
			int distance = getFrontDistance(targetVal, number, remnant);
			if (distance >= 0 && distance <= remnant) {
				sb.append(number.substring(distance, distance + 1));
				number = number.substring(distance + 1, number.length());
				remnant -= distance;
				numberListIdx = numberList.size() - 1;
			} else {
				numberListIdx--;
			}

			if(numberListIdx < 0){
				return sb.toString().substring(0, sb.length() - remnant); 
			}
			if (remnant == 0) {
				break;
			}
		}

		return sb.toString() + number;
	}

	private int getFrontDistance(int targetVal, String number, int remnant) {
		return number.indexOf(String.valueOf(targetVal));
	}
}