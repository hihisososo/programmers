package problem.문자열압축;

class Solution {
	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
		System.out.println(new Solution().solution(s));
	}

	public int solution(String s) {
		int answer = 0;
		answer = s.length();
		for (int splitLength = 1; splitLength < s.length(); splitLength++) {
			StringBuffer sb = new StringBuffer();
			int matchCnt = 1;
			int startIdx = 0;
			
			String word = getWord(s, startIdx, splitLength);
			startIdx += splitLength;
			while (true) {
				if (!canGetNextWord(startIdx, splitLength, s)) {
					appendWordAndCnt(sb, word, matchCnt);
					appendRemnant(sb, startIdx, s);
					break;
				}

				if (isNextWordMatch(word, s, startIdx, splitLength)) {
					matchCnt++;
				} else {
					appendWordAndCnt(sb, word, matchCnt);
					
					matchCnt = 1;
					word = getWord(s, startIdx, splitLength);
				}
				
				startIdx += splitLength;
			}
			answer = Math.min(answer, sb.length());
		}
		return answer;
	}

	private void appendRemnant(StringBuffer sb, int startIdx, String s) {
		sb.append(s.subSequence(startIdx, s.length()));
	}

	private void appendWordAndCnt(StringBuffer sb, String word, int matchCnt) {
		if (matchCnt > 1) {
			sb.append(word + matchCnt);
		} else {
			sb.append(word);
		}
	}

	private boolean canGetNextWord(int startIdx, int i, String s) {
		return !(startIdx + i > s.length());
	}

	private boolean isNextWordMatch(String word, String s, int startIdx, int length) {
		return word.equals(getWord(s, startIdx, length));
	}

	private String getWord(String s, int from, int length) {
		return s.substring(from, from + length);
	}
}