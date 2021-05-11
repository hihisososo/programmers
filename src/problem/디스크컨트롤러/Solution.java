package problem.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public static void main(String[] args) {
		int[][] jobs = new int[][] { { 0, 5 }, { 0, 2 }, { 0, 10 } };
		System.out.println(new Solution().solution(jobs));
	}

	public int solution(int[][] jobs) {
		Task[] tasks = new Task[jobs.length];
		for (int i = 0; i < jobs.length; i++) {
			tasks[i] = new Task(jobs[i][0], jobs[i][1]);
		}
		Arrays.sort(tasks, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				return o1.time - o2.time;
			}
		});

		PriorityQueue<Task> taskQueue = new PriorityQueue<Task>();
		int time = 0;
		int taskIdx = 0;
		int allProcessTime = 0;
		while (true) {
			while (true) {
				if (taskIdx < jobs.length && tasks[taskIdx].time <= time) {
					taskQueue.add(tasks[taskIdx]);
					taskIdx++;
				} else {
					break;
				}

			}

			if (!taskQueue.isEmpty()) {
				Task task = taskQueue.poll();
				time += task.processTime;
				allProcessTime += (time - task.time);
			} else {
				time++;
			}

			if (taskIdx == jobs.length && taskQueue.isEmpty()) {
				break;
			}
		}

		return allProcessTime / jobs.length;
	}

	class Task implements Comparable<Task> {
		int time;
		int processTime;

		public Task(int time, int processTime) {
			this.time = time;
			this.processTime = processTime;
		}

		@Override
		public int compareTo(Task o) {
			if (o.processTime == processTime) {
				return time - o.time;
			} else {
				return processTime - o.processTime;
			}
		}
	}
}