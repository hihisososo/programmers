package problems.네트워크;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(new Solution().solution(3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(new Solution().solution(4, new int[][]{{1, 1, 0, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}}));
    }

    public int solution(int n, int[][] computers) {

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {
            int[] computer = computers[i];
            for (int j = 0; j < computer.length; j++) {
                if (i == j) {
                    continue;
                }
                if (computer[j] == 1 && getParent(i, parent) != getParent(j, parent)) {
                    parent[getParent(j, parent)] = getParent(i, parent);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(getParent(parent[i], parent));
        }

        return set.size();
    }

    private int getParent(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return getParent(parent[i], parent);

    }
}