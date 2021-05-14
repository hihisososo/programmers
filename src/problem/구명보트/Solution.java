package problem.구명보트;

class Solution {
	public static void main(String[] args) {
		int[] people = new int[] { 10, 21, 31, 70 };
		int limit = 100;
		System.out.println(new Solution().solution(people, limit));
	}

	public int solution(int[] people, int limit) {
		int[] weights = new int[241];
		for (int i = 0; i < people.length; i++) {
			weights[people[i]]++;
		}

		int boatCnt = 0;
		int peopleCnt = people.length;
		while (true) {
			int remnant = limit;
			int cnt = 0;
			while (true) {
				int idx = findRightMost(weights, remnant);
				if (idx == -1) {
					break;
				}
				remnant -= (idx);
				weights[idx]--;
				peopleCnt--;
				cnt++;
				if (cnt == 2) {
					break;
				}

			}
			boatCnt++;
			if (peopleCnt == 0) {
				break;
			}
		}
		return boatCnt;
	}

	private int findRightMost(int[] weights, int remnant) {
		int idx = remnant;
		for (int i = idx; i >= 0; i--) {
			if (weights[i] > 0) {
				return i;
			}
		}
		return -1;
	}
}