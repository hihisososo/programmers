package problem.Ã¼À°º¹;

class Solution {
	public static void main(String[] args) {
		int n = 3;
		int[] lost = new int[] { 3 };
		int[] reserve = new int[] { 1 };

		System.out.println(new Solution().solution(n, lost, reserve));
	}

	public int solution(int n, int[] lost, int[] reserve) {

		Student[] students = new Student[n];
		for (int i = 0; i < n; i++) {
			students[i] = new Student(false, false);
		}
		for (int i = 0; i < lost.length; i++) {
			students[lost[i] - 1].lost = true;
		}
		for (int i = 0; i < reserve.length; i++) {
			students[reserve[i] - 1].reserve = true;
		}

		for (int i = 0; i < students.length; i++) {
			if (students[i].lost) {
				if (students[i].reserve) {
					students[i].reserve = false;
					students[i].lost = false;
				}
			}
			if (students[i].lost) {
				if (i > 0) {
					if (students[i - 1].reserve && !students[i - 1].lost) {
						students[i - 1].reserve = false;
						students[i].lost = false;
					}
				}
			}
			if (students[i].lost) {
				if (i < students.length - 1) {
					if (students[i + 1].reserve && !students[i + 1].lost) {
						students[i + 1].reserve = false;
						students[i].lost = false;
					}
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < students.length; i++) {
			if (!students[i].lost) {
				cnt++;
			}
		}

		return cnt;
	}

	public class Student {
		boolean lost;
		boolean reserve;

		public Student(boolean lost, boolean reserve) {
			this.lost = lost;
			this.reserve = reserve;
		}
	}
}