package problems.N으로표현;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().solution(5, 12));
    System.out.println(new Solution().solution(2, 11));
  }

  public int solution(int N, int number) {
    Map<Integer, Set<Integer>> depthNumberMap = new HashMap<>();
    for (int i = 1; i <= 8; i++) {
      Set<Integer> depthNumbers = new HashSet<>();
      depthNumbers.add(getDefaultNumber(i, N));
      for (int j = 1; j < i; j++) {
        int numberSplit1 = j;
        int numberSplit2 = i - j;
        Set<Integer> calc1 = depthNumberMap.get(numberSplit1);
        Set<Integer> calc2 = depthNumberMap.get(numberSplit2);
        for (int a : calc1) {
          for (int b : calc2) {
            if (a == 0 || b == 0) {
              continue;
            }
            depthNumbers.add(a + b);
            depthNumbers.add(a - b);
            depthNumbers.add(a * b);
            depthNumbers.add(a / b);
          }
        }
      }
      if (depthNumbers.contains(number)) {
        return i;
      }
      depthNumberMap.put(i, depthNumbers);
    }
    return -1;
  }

  private Integer getDefaultNumber(int digit, int number) {
    String s = "";
    for (int i = 0; i < digit; i++) {
      s += number;
    }
    return Integer.parseInt(s);
  }
}