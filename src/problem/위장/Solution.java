package problem.¿ß¿Â;

import java.util.HashMap;

class Solution {
	public static void main(String[] args) {
		String[][] clothes = new String[][] { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(new Solution().solution(clothes));
	}

	public int solution(String[][] clothes) {
		HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			String type = clothes[i][1];
			if (clothesMap.get(type) == null) {
				clothesMap.put(type, 1);
			}
			clothesMap.put(type, clothesMap.get(type) + 1);
		}

		int result = 1;
		for (String key : clothesMap.keySet()) {
			result *= clothesMap.get(key);
		}

		return result - 1;
	}
}
