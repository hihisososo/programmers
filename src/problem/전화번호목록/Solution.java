package problem.전화번호목록;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
	public static void main(String[] args) {
		String[] genres = new String[] { "classic", "pop", "classic", "classic", "pop", "pop" };
		int[] plays = new int[] { 500, 600, 150, 800, 2000, 600 };

		int[] result = new Solution().solution(genres, plays);
		for (int i : result) {
			System.out.println(i);
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, ArrayList<Music>> genreMap = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (genreMap.get(genres[i]) == null) {
				genreMap.put(genres[i], new ArrayList<>());
			}
			ArrayList<Music> list = genreMap.get(genres[i]);
			list.add(new Music(i, plays[i]));
			genreMap.put(genres[i], list);
		}

		List<Map.Entry<String, ArrayList<Music>>> list = new LinkedList<>(genreMap.entrySet());

		Collections.sort(list, new Comparator<Entry<String, ArrayList<Music>>>() {
			@Override
			public int compare(Entry<String, ArrayList<Music>> o1, Entry<String, ArrayList<Music>> o2) {
				int o1Play = 0;
				ArrayList<Music> o1List = o1.getValue();
				for (int i = 0; i < o1List.size(); i++) {
					o1Play += o1List.get(i).play;
				}

				int o2Play = 0;
				ArrayList<Music> o2List = o2.getValue();
				for (int i = 0; i < o2List.size(); i++) {
					o2Play += o2List.get(i).play;
				}

				return o2Play - o1Play;
			}
		});

		ArrayList<Integer> resultList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Music> musicList = list.get(i).getValue();
			Collections.sort(musicList, new Comparator<Music>() {
				@Override
				public int compare(Music o1, Music o2) {
					if (o1.play > o2.play) {
						return -1;
					} else if (o1.play == o2.play) {
						return o1.id - o2.id;
					} else {
						return 1;
					}
				}
			});
			for (int j = 0; j < 2 && j < musicList.size(); j++) {
				resultList.add(musicList.get(j).id);
			}
		}

		int[] result = new int[resultList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = resultList.get(i);
		}
		return result;

	}

	public class Music {
		int id;
		int play;

		public Music(int id, int play) {
			this.id = id;
			this.play = play;
		}
	}
}