package problem.º∂ø¨∞·«œ±‚;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

class Solution {

  public static void main(String[] args) {
    int n = 4;
    int[][] costs = new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
    System.out.println(new Solution().solution(n, costs));
  }

  public int solution(int n, int[][] costs) {
    Map<Integer, HashSet<String>> costMap = new TreeMap<>();
    for (int i = 0; i < costs.length; i++) {
      int edge1 = costs[i][0];
      int edge2 = costs[i][1];
      int cost = costs[i][2];

      HashSet<String> costInfo = costMap.getOrDefault(cost, new HashSet<>());
      costInfo.add(edge1 + "," + edge2);
      costMap.put(cost, costInfo);
    }
    int[] parents = IntStream.range(0, n).toArray();
    int cost = 0;
    for (Integer key : costMap.keySet()) {
      HashSet<String> costInfos = costMap.get(key);
      for (String costInfo : costInfos) {
        Integer edge1 = Integer.parseInt(costInfo.split(",")[0]);
        Integer edge2 = Integer.parseInt(costInfo.split(",")[1]);

        if (getParent(parents, edge1) != getParent(parents, edge2)) {
          parents[getParent(parents, edge1)] = getParent(parents, edge2);
          cost += key;
        }
      }

    }
    return cost;
  }

  private int getParent(int[] parents, Integer edge) {
    if (parents[edge] == edge) {
      return edge;
    } else {
      return getParent(parents, parents[edge]);
    }
  }
}