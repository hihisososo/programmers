package problem.주식가격;

import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		int[] prices = new int[] { 5, 5, 5, 5, 5, 5 };
		int[] result = new Solution().solution(prices);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Stack<Stock> stocks = new Stack<>();
		Stack<Stock> tempStocks = new Stack<>();

		for (int i = 0; i < prices.length; i++) {
			int curPrice = prices[i];
			while (!stocks.isEmpty()) {
				Stock stock = stocks.pop();
				if (stock.price <= curPrice) {
					stock.time++;
					tempStocks.push(stock);
				} else {
					answer[stock.idx] = stock.time + 1;
				}
			}

			while (!tempStocks.isEmpty()) {
				stocks.push(tempStocks.pop());
			}

			stocks.push(new Stock(0, prices[i], i));
		}

		while (!stocks.isEmpty()) {
			Stock stock = stocks.pop();
			answer[stock.idx] = stock.time;
		}

		return answer;
	}

	public class Stock {
		int time;
		int price;
		int idx;

		public Stock(int time, int price, int idx) {
			this.time = time;
			this.price = price;
			this.idx = idx;
		}

	}
}
