package problem.전화번호목록;

import java.util.HashSet;

class Solution {
	public static void main(String[] args) {
		String[] phone_book = new String[] { "123", "456", "789", };
		System.out.println(new Solution().solution(phone_book)); 
	}

	public boolean solution(String[] phone_book) {
		HashSet<String> phoneHash = new HashSet<>();
		for (int i = 0; i < phone_book.length; i++) {
			String phoneNum = phone_book[i];
			for (int j = 0; j < phoneNum.length(); j++) {
				phoneHash.add(phoneNum.substring(0, j));
			}
		}

		for (int i = 0; i < phone_book.length; i++) {
			String phoneNum = phone_book[i];
			if (phoneHash.contains(phoneNum)) {
				return false;
			}
		}

		return true;
	}

}