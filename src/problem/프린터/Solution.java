package problem.«¡∏∞≈Õ;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Solution {
	public static void main(String[] args) {
		int[] priorities = new int[] { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		System.out.println(new Solution().solution(priorities, location));

	}

	public int solution(int[] priorities, int location) {
		
		ArrayDeque<PrintJob> processQueue = new ArrayDeque<>();
		for (int i = 0; i < priorities.length; i++) {
			processQueue.addLast(new PrintJob(i, priorities[i]));
		}

		int processIdx = 0;
		while (true) {
			PrintJob targetJob = processQueue.poll();
			Iterator<PrintJob> iter = processQueue.iterator();
			boolean isProcessable = true;
			while (iter.hasNext()) {
				PrintJob job = iter.next();
				if (job.priority > targetJob.priority) {
					isProcessable = false;
					break;
				}
			}

			if (isProcessable) {
				processIdx++;
				if (targetJob.idx == location) {
					break;
				}
			} else {
				processQueue.addLast(targetJob);
			}
		}
		return processIdx;
	}

	public class PrintJob {
		int idx;
		int priority;

		public PrintJob(int idx, int priority) {
			this.idx = idx;
			this.priority = priority;
		}

	}
}
