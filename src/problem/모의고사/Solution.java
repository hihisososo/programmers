package problem.모의고사;

import java.util.ArrayList;

class Solution {
	public static void main(String[] args) {
		int[] answers = new int[] { 1,3,2,4,2 };
		int[] result = new Solution().solution(answers);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

	public int[] solution(int[] answers) {
		int scorePerson1 = 0;
		int scorePerson2 = 0;
		int scorePerson3 = 0;
		for (int i = 0; i < answers.length; i++) {
			if (isCorrectPerson1(i, answers[i])) {
				scorePerson1++;
			}
			if (isCorrectPerson2(i, answers[i])) {
				scorePerson2++;
			}
			if (isCorrectPerson3(i, answers[i])) {
				scorePerson3++;
			}
		}

		int maxScore = Math.max(scorePerson3, Math.max(scorePerson1, scorePerson2));
		ArrayList<Integer> personList = new ArrayList<>();
		if (scorePerson1 == maxScore) {
			personList.add(1);
		}
		if (scorePerson2 == maxScore) {
			personList.add(2);
		}
		if (scorePerson3 == maxScore) {
			personList.add(3);
		}

		int[] result = new int[personList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = personList.get(i);
		}
		return result;
	}

	private boolean isCorrectPerson1(int i, int answer) {
		int answerP1 = i % 5 + 1;
		return answer == answerP1;
	}

	private boolean isCorrectPerson2(int i, int answer) {
		int[] answers = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
		int answerP2 = answers[i % 8];
		return answer == answerP2;
	}

	private boolean isCorrectPerson3(int i, int answer) {
		int[] answers = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int answerP3 = answers[i % 10];
		return answer == answerP3;
	}
}