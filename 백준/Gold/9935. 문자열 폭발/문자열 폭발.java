

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();

		ArrayDeque<Character> q = new ArrayDeque<>();
		char[] data = s.toCharArray();
		for (char c : data) {
			q.offer(c);
		}
		// System.out.println(q);

		Map<Character, Integer> map = new HashMap<>();
		int number = 1;
		char[] b = bomb.toCharArray();
		for (char c : b) {
			if (!map.containsKey(c)) {
				map.put(c, number++);
			}
		}

		ArrayDeque<Character> dq = new ArrayDeque<>();

		int maxSize = b.length;
		Integer idx = 0;

		while (!q.isEmpty()) {
			Character now = q.poll();
			dq.offer(now);

			// System.out.println("q = " + q);
			// System.out.println("dq = "+dq);

			if (now == b[maxSize - 1] && dq.size() >= maxSize) {
				Stack<Character> stack = new Stack<>();
				boolean check = false;
				for (int i = maxSize - 1; i >= 0; i--) {
					Character c = dq.pollLast();
					stack.push(c);
					if (c != b[i]) {
						check = true;
						break;
					}
				}

				if (check) {
					while (!stack.isEmpty()) {
						dq.offer(stack.pop());
					}
				}
			}
		}

		if (dq.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			while (!dq.isEmpty()) {
				sb.append(dq.poll());
			}
			System.out.println(sb);
		}
	}
}