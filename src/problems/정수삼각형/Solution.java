package problems.Á¤¼ö»ï°¢Çü;

class Solution {

  public static void main(String[] args) {

    System.out.println(new Solution()
        .solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
  }

  public int solution(int[][] triangle) {
    int[][] maxScore = new int[triangle.length][];
    for (int i = 0; i < triangle.length; i++) {
      maxScore[i] = new int[triangle[i].length];
      for (int j = 0; j < triangle[i].length; j++) {
        int leftTop = i > 0 && j > 0 ? maxScore[i - 1][j - 1] : 0;
        int rightTop = i > 0 && maxScore[i - 1].length > j ? maxScore[i - 1][j] : 0;
        maxScore[i][j] = Math.max(leftTop, rightTop) + triangle[i][j];
      }
    }
    int answer = 0;
    for (int i = 0; i < maxScore[maxScore.length - 1].length; i++) {
      answer = Math.max(maxScore[maxScore.length - 1][i], answer);
    }
    return answer;
  }
}