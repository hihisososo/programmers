package problem.완주하지못한선수;

import java.util.HashMap;

class Solution {
	public static void main(String[] args) {
		String[] participant = new String[] { "mislav", "stanko", "mislav", "ana" };
		String[] completion = new String[] { "stanko", "ana", "mislav" };
		System.out.println(new Solution().solution(participant, completion));
	}

	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> completionMap = new HashMap<String, Integer>();
		for (int i = 0; i < completion.length; i++) {
			if (completionMap.get(completion[i]) == null) {
				completionMap.put(completion[i], 1);
			} else {
				completionMap.put(completion[i], completionMap.get(completion[i]) + 1);
			}

		}

		for (int i = 0; i < participant.length; i++) {
			if (completionMap.get(participant[i]) == null) {
				return participant[i];
			} else {
				int val = completionMap.get(participant[i]);
				val--;
				if (val == 0) {
					completionMap.remove(participant[i]);
				} else {
					completionMap.put(participant[i], val--);
				}

			}
		}

		return "";
	}

}