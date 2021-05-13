package problem.¡∂¿ÃΩ∫∆Ω;

class Solution {
	public static void main(String[] args) {
		String name = "ABABAAAAAAAAABAB";
		System.out.println(new Solution().solution(name));
	}

	public int solution(String name) {
		char[] nameChar = name.toCharArray();
		boolean[] notAIndex = new boolean[nameChar.length];
		int notACnt = 0;
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] != 'A') {
				notAIndex[i] = true;
				notACnt++;
			}
		}

		if (notACnt == 0) {
			return 0;
		}
		int cnt = 0;
		int lastIndex = 0;

		while (true) {

			int distance = getDistance(nameChar[lastIndex], 'A');
			int reverseDistance = getReverseDistance(nameChar[lastIndex], 'A');
			cnt += Math.min(distance, reverseDistance);

			if (notAIndex[lastIndex]) {
				notAIndex[lastIndex] = false;
				notACnt--;
			}

			if (notACnt == 0) {
				break;
			}

			int rightMoveCnt = lastIndex == notAIndex.length - 1 ? Integer.MAX_VALUE : 0;
			int rightMoveIdx = 0;
			for (int i = lastIndex + 1; i < notAIndex.length; i++) {
				rightMoveCnt++;
				if (notAIndex[i]) {
					rightMoveIdx = i;
					break;
				} else {
					if (i == notAIndex.length - 1) {
						rightMoveCnt = Integer.MAX_VALUE;
					}
				}
			}

			int leftMoveCnt = 0;
			int leftMoveIdx = 0;
			for (int i = lastIndex - 1;; i--) {
				if (i < 0) {
					i = nameChar.length - 1;
				}
				leftMoveCnt++;
				if (notAIndex[i]) {
					leftMoveIdx = i;
					break;
				}
			}

			if (leftMoveCnt >= rightMoveCnt) {
				lastIndex = rightMoveIdx;
				cnt += rightMoveCnt;
			} else {
				lastIndex = leftMoveIdx;
				cnt += leftMoveCnt;
			}

			if (notACnt == 0) {
				break;
			}
		}
		return cnt;
	}

	private int getDistance(char c1, char c2) {
		return Math.abs(c2 - c1);
	}

	private int getReverseDistance(char c1, char c2) {
		return Math.abs('Z' - c1) + 1;
	}
}