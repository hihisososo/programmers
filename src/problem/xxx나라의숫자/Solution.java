package problem.xxx나라의숫자;

class Solution {
	int convert[] = new int[] { 1, 2, 4 };

	public static void main(String[] args) {
		int n = 10;

		System.out.println(new Solution().solution(n));
	}

	public String solution(int n) {
		String str = "";
		while (true) {
			n -= 1;

			int tmp = n % 3;
			n /= 3;

			str = convert[tmp] + str;

			if (n <= 0) {
				break;
			}
		}

		return str;
	}

}