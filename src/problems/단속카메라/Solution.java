package problems.단속카메라;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

  public static void main(String[] args) {
    System.out
        .println(new Solution().solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
  }

  public int solution(int[][] routes) {
    int answer = 0;
    Arrays.sort(routes, (a, b) -> a[1] - b[1]);
    Set<Integer> removes = new HashSet<>();
    for (int i = 0; i < routes.length; i++) {
      if (removes.contains(i)) {
        continue;
      }
      answer++;

      int base = routes[i][1];
      for (int j = i; j < routes.length; j++) {
        if (routes[j][0] <= base && base <= routes[j][1]) {
          removes.add(j);
        }
      }
    }

    return answer;
  }
}