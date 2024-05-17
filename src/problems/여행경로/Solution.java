package problems.여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

class Solution {

  public static void main(String[] args) {

  }

  private boolean find = false;
  private List<String> result = new ArrayList<>();

  public String[] solution(String[][] tickets) {
    Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
    Map<String, List<Pair<String, Integer>>> fromTo = new HashMap<>();
    for (int i = 0; i < tickets.length; i++) {
      String from = tickets[i][0];
      String to = tickets[i][1];
      fromTo.putIfAbsent(from, new ArrayList<>());
      fromTo.get(from).add(new Pair<>(to, i));
    }

    dfs("ICN", fromTo, new LinkedList<>(), new HashSet<Integer>(), tickets.length);

    return result.toArray(new String[result.size()]);
  }

  private void dfs(String name, Map<String, List<Pair<String, Integer>>> fromTo,
      LinkedList<String> paths, Set<Integer> useTicketNum, int length) {
    if (find) {
      return;
    }
    paths.addLast(name);
    if (useTicketNum.size() == length) {
      find = true;
      result.addAll(paths);
    }

    Iterator<Pair<String, Integer>> iter = fromTo.getOrDefault(name, Collections.emptyList())
        .iterator();
    while (iter.hasNext()) {
      Pair<String, Integer> next = iter.next();
      if (!useTicketNum.contains(next.getValue())) {
        useTicketNum.add(next.getValue());
        dfs(next.getKey(), fromTo, paths, useTicketNum, length);
        useTicketNum.remove(next.getValue());
      }
    }
    paths.removeLast();
  }
}