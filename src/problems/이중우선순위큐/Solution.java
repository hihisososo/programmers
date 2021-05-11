package problems.이중우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public static void main(String[] args) {
		String[] operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] result = new Solution().solution(operations);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public int[] solution(String[] operations) {

		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();

		for (int i = 0; i < operations.length; i++) {
			String operation = operations[i];
			String command = operation.split(" ")[0];
			int target = Integer.parseInt(operation.split(" ")[1]);

			switch (command) {
			case "I":
				maxQueue.offer(target);
				minQueue.offer(target);
				break;
			case "D":
				if (target == 1) {
					if(maxQueue.isEmpty()){
						break;
					}
					int max = maxQueue.poll();
					minQueue.remove(max);
				} else {
					if(minQueue.isEmpty()){
						break;
					}
					int min = minQueue.poll();
					maxQueue.remove(min);
				}
				break;
			}
		}

		if (maxQueue.isEmpty()) {
			return new int[] { 0, 0 };
		}

		return new int[] { maxQueue.poll(), minQueue.poll() };
	}
}