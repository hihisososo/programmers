package problems.단어변환;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solution(String begin, String target, String[] words) {
        int answer = dfs(begin, target, words, 0, new boolean[words.length]);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private int dfs(String currWord, String target, String[] words, int cnt, boolean[] use) {
        if (currWord.equals(target)) {
            return cnt;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (use[i]) continue;
            if (canTranslate(currWord, words[i])) {
                use[i] = true;
                min = Math.min(dfs(words[i], target, words, cnt + 1, use), min);
                use[i] = false;
            }
        }
        return min;
    }

    private boolean canTranslate(String currWord, String word) {
        int cnt = 0;
        for (int i = 0; i < currWord.length(); i++) {
            if (currWord.charAt(i) == word.charAt(i)) {
                cnt++;
            }
        }
        if (cnt == currWord.length() - 1) {
            return true;
        }
        return false;
    }
}