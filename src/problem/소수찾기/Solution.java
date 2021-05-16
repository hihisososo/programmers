package problem.소수찾기;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {

	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(new Solution().solution(numbers));
	}

	public int solution(String numbers) {
		int answer = 0;

		HashSet<String> numberList = makeNumberList(numbers);

		for (String s : numberList) {
			if (!s.startsWith("0")) {
				int intVal = Integer.parseInt(s);
				if (checkSosu(intVal)) {
					System.out.println(s);
					answer++;
				}
			}
		}
		return answer;
	}

	private HashSet<String> makeNumberList(String numbers) {
		HashSet<String> list = new HashSet<String>();
		ArrayList<Character> availableList = new ArrayList<Character>();
		char[] numbersChar = numbers.toCharArray();
		for (int i = 0; i < numbersChar.length; i++) {
			availableList.add(numbersChar[i]);
		}
		find(availableList, list);

		return list;
	}

	private void find(ArrayList<Character> availableList, HashSet<String> list) {
		for (int i = 0; i < availableList.size(); i++) {
			ArrayList<Character> copyList = new ArrayList<Character>(availableList);
			copyList.remove(availableList.get(i));
			list.add(availableList.get(i) + "");
			find(availableList.get(i) + "", copyList, list);
		}
	}

	private void find(String available, ArrayList<Character> availableList, HashSet<String> list) {
		if (availableList.size() == 0) {
			list.add(available);
			return;
		}

		for (int i = 0; i < availableList.size(); i++) {
			ArrayList<Character> copyList = new ArrayList<Character>(availableList);
			copyList.remove(availableList.get(i));
			list.add(available + availableList.get(i));
			find(available + availableList.get(i), copyList, list);
		}
	}

	private boolean checkSosu(int val) {
		if(val == 1) {
			return false;
		}
		int endIdx = (int) Math.sqrt(val);
		for (int i = 2; i <= endIdx; i++) {
			if (val % i == 0) {
				return false;
			}
		}
		return true;
	}
}