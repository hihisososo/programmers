package problems.전력망을둘로나누기;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }

    public int solution(int n, int[][] wires) {
        Map<Integer, Set<Integer>> conMap = new HashMap<>();
        Set<Integer> allCnt = new HashSet<>();
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];

            Set<Integer> starts = conMap.getOrDefault(end, new HashSet<>());
            starts.add(start);
            conMap.put(end, starts);

            Set<Integer> ends = conMap.getOrDefault(start, new HashSet<>());
            ends.add(end);
            conMap.put(start, ends);

            allCnt.add(start);
            allCnt.add(end);

        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int delStart = wires[i][0];
            int delEnd = wires[i][1];
            int cnt = 1;

            Set<Integer> visit = new HashSet<>();
            Queue<Integer> nextVisit = new LinkedList<>();
            visit.add(delStart);
            visit.add(delEnd);
            Set<Integer> cons = conMap.get(delStart);
            nextVisit.addAll(cons);

            Iterator<Integer> iter;
            while (!nextVisit.isEmpty()) {
                iter = nextVisit.iterator();
                Set<Integer> nextVisitAdd = new HashSet<>();
                while (iter.hasNext()) {
                    Integer next = iter.next();
                    if (!visit.contains(next)) {
                        cnt++;
                        nextVisitAdd.addAll(conMap.get(next));
                        visit.add(next);
                    }
                }
                nextVisitAdd.removeAll(visit);
                nextVisit.clear();
                nextVisit.addAll(nextVisitAdd);
            }

            int left = cnt;
            int right = allCnt.size() - cnt;
            answer = Math.min(answer, Math.abs(left - right));
        }

        return answer;

    }
}