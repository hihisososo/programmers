package problems.µî±·±æ;

class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().solution(4, 3, new int[][]{{2, 2}}));

  }

  public int solution(int m, int n, int[][] puddles) {
    int[][] dp = new int[n][m];
    dp[0][0] = 1;
    for (int i = 0; i < puddles.length; i++) {
      dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
    }

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i == 0 && j == 0 || dp[i][j] == -1) {
          continue;
        }
        int sum = 0;
        if (i > 0) {
          sum = (dp[i - 1][j] == -1 ? 0 : dp[i - 1][j]) % 1000000007;
        }
        if (j > 0) {
          sum += (dp[i][j - 1] == -1 ? 0 : dp[i][j - 1]) % 1000000007;
        }
        dp[i][j] = sum % 1000000007;
      }
    }
    return dp[n - 1][m - 1];
  }
}