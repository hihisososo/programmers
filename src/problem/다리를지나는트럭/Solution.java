package problem.다리를지나는트럭;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Solution {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = new int[] { 10,10,10,10,10,10,10,10,10,10 };
		System.out.println(new Solution().solution(bridge_length, weight, truck_weights));
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		ArrayDeque<Truck> trucks = new ArrayDeque<>();
		for (int i = 0; i < truck_weights.length; i++) {
			trucks.addLast(new Truck(truck_weights[i], 0));
		}

		ArrayDeque<Truck> onBridge = new ArrayDeque<>();
		int brigeEndCnt = 0;
		int time = 0;
		int weightRemnant = weight;
		while (brigeEndCnt != truck_weights.length) {
			time++;

			Iterator<Truck> iter = onBridge.iterator();
			while (iter.hasNext()) {
				Truck truck = iter.next();
				truck.time++;
			}

			if (!onBridge.isEmpty()) {
				Truck truck = onBridge.pollFirst();
				if (truck.time < bridge_length) {
					onBridge.addFirst(truck);
				} else {
					brigeEndCnt++;
					weightRemnant += truck.weight;
				}
			}

			if (!trucks.isEmpty()) {
				Truck truck = trucks.pop();
				if (truck.weight <= weightRemnant) {
					weightRemnant -= truck.weight;
					onBridge.addLast(truck);
				} else {
					trucks.push(truck);
				}
			}
		}

		return time;
	}

	public class Truck {
		int weight;
		int time;

		public Truck(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}

	}
}
