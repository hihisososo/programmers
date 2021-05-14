package problem.º∂ø¨∞·«œ±‚;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 0, 3, 5 }};
		System.out.println(new Solution().solution(n, costs));
	}

	public int solution(int n, int[][] costs) {
		Edge[] edges = new Edge[n];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new Edge(i);
		}

		for (int i = 0; i < costs.length; i++) {
			int point1 = costs[i][0];
			int point2 = costs[i][1];
			int cost = costs[i][2];

			edges[point1].briges.add(new Bridge(edges[point2], cost));
			edges[point2].briges.add(new Bridge(edges[point1], cost));
		}

		return tarverseAndFindMax(edges);

	}

	private int tarverseAndFindMax(Edge[] edges) {
		boolean[] visited = new boolean[edges.length];
		AtomicInteger max = new AtomicInteger(Integer.MAX_VALUE);

		for (int i = 0; i < edges.length; i++) {
			findMax(edges, Arrays.copyOf(visited, visited.length), i, max, 0, 0);
		}

		return max.intValue();
	}

	private void findMax(Edge[] edges, boolean[] visited, int curIdx, AtomicInteger max, int visitCnt, int cost) {
		visitCnt++;
		visited[curIdx] = true;
		if (visitCnt == visited.length) {
			if (max.get() > cost) {
				max.set(cost);
			}
		}

		boolean isAnyVisit = false;
		ArrayList<Bridge> nextVisitBriges = edges[curIdx].briges;
		for (int i = 0; i < nextVisitBriges.size(); i++) {
			Bridge bridge = nextVisitBriges.get(i);
			if (!visited[bridge.to.idx]) {
				findMax(edges, Arrays.copyOf(visited, visited.length), bridge.to.idx, max, visitCnt,
						cost + bridge.cost);
				boolean[] copyVisited = Arrays.copyOf(visited, visited.length);
				copyVisited[bridge.to.idx] = true;
				findMax(edges, copyVisited, curIdx, max, visitCnt,
						cost + bridge.cost);
				isAnyVisit = true;
			}
		}
		if (!isAnyVisit) {
			return;
		}

	}

	public class Edge {
		int idx;
		ArrayList<Bridge> briges;

		public Edge(int idx) {
			this.idx = idx;
			this.briges = new ArrayList<>();
		}
	}

	public class Bridge {
		Edge to;
		int cost;

		public Bridge(Edge to, int cost) {
			this.to = to;
			this.cost = cost;
		}

	}
}