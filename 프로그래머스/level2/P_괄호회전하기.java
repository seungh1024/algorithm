package algo_202401;

import java.util.*;

public class P_괄호회전하기 {
	public static void main(String[] args) {
		P_괄호회전하기 test = new P_괄호회전하기();
		String s = "}]()[{";
		int answer = test.solution(s);
		int result = 2;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static Map<Character, Integer> map;

	public int solution(String s) {
		int answer = 0;

		map = new HashMap<>();
		map.put('(', 1);
		map.put(')', 1);
		map.put('{', 2);
		map.put('}', 2);
		map.put('[', 3);
		map.put(']', 3);

		char[] input = s.toCharArray();
		int length = input.length;
		ArrayDeque<Character> q = new ArrayDeque<>();
		for (char c : input) {
			q.offer(c);
		}
		for (int i = 1; i < length; i++) {
			// System.out.println(q);
			if (isCorrect(q, length)) {
				answer++;
			}
			q.offerLast(q.pollFirst());
		}

		return answer;
	}

	public static boolean isCorrect(ArrayDeque<Character> q, int size) {
		if (size % 2 == 1)
			return false;
		Stack<Character> stack = new Stack<>();
		Object[] data = q.toArray();
		for (int i = 0; i < size; i++) {
			char c = (char)data[i];
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char sc = stack.pop();
				if (map.get(sc) != map.get(c)) {
					// System.out.println(sc + ", "+c);
					// System.out.println("?");
					return false;
				}
			}
		}

		return true;
	}
}
