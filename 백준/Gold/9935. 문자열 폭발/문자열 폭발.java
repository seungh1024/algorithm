

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> q = new ArrayDeque<>();
		char[] input = br.readLine().toCharArray();
		for (char c : input) {
			q.offer(c);
		}

		char[] data = br.readLine().toCharArray();

		Deque<Character> q2 = new ArrayDeque<>();
		int idx = 0;
		while (!q.isEmpty()) {
			char now = q.poll();
			if (now == data[idx]) {
				idx++;
			} else {
				idx = 0;
				if (now == data[idx]) {
					idx++;
				}
			}
			q2.offer(now);

			// System.out.println("q2 = "+q2);
			// System.out.println("q = "+q);
			// System.out.println("idx = "+idx);
			if (idx == data.length) {
				for (int i = 0; i < idx; i++) {
					q2.pollLast();
				}
				while (!q2.isEmpty()) {
					char last = q2.pollLast();
					q.offerFirst(last);
					if (last == data[0]) {
						break;
					}
				}

				idx = 0;
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q2.isEmpty()) {
			sb.append(q2.poll());
		}
		if (sb.isEmpty()) {
			sb.append("FRULA");
		}
		System.out.println(sb);

	}
}
