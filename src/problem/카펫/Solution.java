package problem.Ä«Æê;

class Solution {
	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		int[] result = new Solution().solution(brown, yellow);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		for (int height = 3; height <= ((brown - (height * 2) + 4) / 2); height++) {
			int width = (brown - (height * 2) + 4) / 2;
			int yellowFromHeight = calcYellow(width, height);
			if (yellowFromHeight == yellow) {
				answer[0] = width;
				answer[1] = height;
				break;
			}
		}

		return answer;
	}

	private int calcYellow(int width, int height) {
		return (width - 2) * (height - 2);
	}
}