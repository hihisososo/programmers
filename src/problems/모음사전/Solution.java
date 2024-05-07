package problems.모음사전;

import java.util.concurrent.atomic.AtomicInteger;

class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().solution("AAAAE"));
    System.out.println(new Solution().solution("AAAE"));
    System.out.println(new Solution().solution("I"));
    System.out.println(new Solution().solution("EIO"));
  }

  public int solution(String word) {
    AtomicInteger answer = new AtomicInteger();
    find(word, "", "AEIOU", answer);

    return answer.get();
  }

  private boolean find(String word, String currWord, String useWord, AtomicInteger answer) {
    if (currWord.equals(word)) {
      return true;
    }
    if (currWord.length() == useWord.length()) {
      return false;
    }

    boolean find = false;
    for (int i = 0; i < useWord.length(); i++) {
      answer.addAndGet(1);
      find = find(word, currWord + useWord.charAt(i), useWord, answer);
      if (find) {
        break;
      }
    }
    return find;
  }
}