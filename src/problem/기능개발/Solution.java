package problem.기능개발;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		int[] progresses = new int[] { 1,0 };
		int[] speeds = new int[] { 1,1};
		int[] answer = new Solution().solution(progresses, speeds);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> releaseList = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = progresses.length - 1; i >= 0; i--) {
			stack.push(progresses[i]);
		}
		int[] processed = new int[speeds.length];
		for (int i = 0; i < processed.length; i++) {
			processed[i] = speeds[i];
		}

		int processIdx = 0;
		while (!stack.isEmpty()) {
			int releaseAvailable = 0;
			while (!stack.isEmpty()) {
				int progress = stack.pop();
				if (progress + processed[processIdx] >= 100) {
					processIdx++;
					releaseAvailable++;
				} else {
					stack.push(progress);
					break;
				}
			}
			if (releaseAvailable > 0) {
				releaseList.add(releaseAvailable);
			}
			for (int i = 0; i < processed.length; i++) {
				processed[i] += speeds[i];
			}
		}

		int[] answer = new int[releaseList.size()];
		for (int i = 0; i < releaseList.size(); i++) {
			answer[i] = releaseList.get(i);
		}
		return answer;
	}
}
