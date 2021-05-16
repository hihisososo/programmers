package problems.Å¸°Ù³Ñ¹ö;

class Solution {
	public static void main(String[] args) {
		int[] numbers = new int[] {1,1,1,1,1};
		int target = 3;
		System.out.println(new Solution().solution(numbers, target));
	}
	
	public int solution(int[] numbers, int target) {
		int answer = 0;

		answer = find(0, numbers, target, +numbers[0]) + find(0, numbers, target, -numbers[0]);

		return answer;
	}

	private int find(int targetIdx, int[] numbers, int target, int sum) {
		if (targetIdx == numbers.length - 1) {
			if (sum == target)
				return 1;
			else {
				return 0;
			}
		}

		int cnt = 0;
		cnt += find(targetIdx + 1, numbers, target, sum + numbers[targetIdx + 1]);
		cnt += find(targetIdx + 1, numbers, target, sum - numbers[targetIdx + 1]);
		return cnt;
	}

}