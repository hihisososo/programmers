package problems.게임맵최단거리;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {

        System.out.println(new Solution().solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(new Solution().solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public int solution(int[][] maps) {
        int answer = bfs(maps, 0, 0, 0, new boolean[maps.length][maps[0].length], new int[maps.length][maps[0].length]);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int bfs(int[][] maps, int sRow, int sCol, int path, boolean[][] visit, int[][] minMap) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        List<Pair<Integer, Integer>> next = new LinkedList<>();
        queue.add(new Pair<>(sRow, sCol));
        int level = 0;
        while (true) {
            level++;
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> position = queue.poll();
                Integer row = position.getKey();
                Integer col = position.getValue();
                if(row == maps.length - 1 && col == maps[0].length - 1) {
                    return level;
                }
                if (minMap[row][col] != 0 && minMap[row][col] <= level) {
                    continue;
                }
                minMap[row][col] = level;
                if (row + 1 < maps.length && maps[row + 1][col] == 1 && !visit[row + 1][col]) {
                    next.add(new Pair<>(row + 1, col));
                }
                if (col + 1 < maps[0].length && maps[row][col + 1] == 1 && !visit[row][col + 1]) {
                    next.add(new Pair<>(row, col + 1));
                }
                if (row - 1 >= 0 && maps[row - 1][col] == 1 && !visit[row - 1][col]) {
                    next.add(new Pair<>(row - 1, col));
                }
                if (col - 1 >= 0 && maps[row][col - 1] == 1 && !visit[row][col - 1]) {
                    next.add(new Pair<>(row, col - 1));
                }
            }
            if (next.isEmpty()) {
                break;
            }
            queue.addAll(next);
            next.clear();

        }
        return -1;
    }
}