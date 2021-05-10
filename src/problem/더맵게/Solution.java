package problem.´õ¸Ê°Ô;

import java.util.PriorityQueue;

class Solution {

	public static void main(String[] args) {
		int[] scoville = new int[] { 1, 2, 3, 9, 10, 12 };
		int K = 1000000;
		System.out.println(new Solution().solution(scoville, K));

	}

	public int solution(int[] scoville, int K) {

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			queue.offer(scoville[i]);
		}

		int shakeCnt = 0;
		while (true) {
			if (queue.peek() >= K) {
				break;
			}
			if (queue.size() == 1) {
				return -1;
			}
			shakeCnt++;
			queue.offer(queue.poll() + (queue.poll() * 2));

		}

		return shakeCnt;
	}
}
