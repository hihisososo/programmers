package problem.Hindex;

import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		int[] citations = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(new Solution().solution(citations));
	}

	public int solution(int[] citations) {
		int answer = 0;
		int[] sortedCitation = new int[10001];
		for (int i = 0; i < citations.length; i++) {
			sortedCitation[citations[i]]++;
		}

		for (int i = 0; i < 10000; i++) {
			int upCnt = 0;
			for (int j = i; j < sortedCitation.length; j++) {
				upCnt += sortedCitation[j];
			}
			int downCnt = 0;
			for (int j = i - 1; j >= 0; j--) {
				downCnt += sortedCitation[j];
			}

			if (upCnt >= i && downCnt <= i) {
				answer = Math.max(i, answer);
			}
		}
		return answer;
	}
}