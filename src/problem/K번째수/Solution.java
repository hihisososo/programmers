package problem.K¹øÂ°¼ö;

import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		new Solution().solution(array, commands);
	}

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int startIdx = commands[i][0] - 1;
			int endIdx = commands[i][1] - 1;
			int target = commands[i][2] - 1;

			int[] subArray = new int[endIdx - startIdx + 1];
			System.arraycopy(array, startIdx, subArray, 0, endIdx - startIdx + 1);

			Arrays.sort(subArray);
			answer[i] = subArray[target];
		}
		return answer;
	}
}