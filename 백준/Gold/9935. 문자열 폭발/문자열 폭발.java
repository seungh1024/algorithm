

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Character> q = new ArrayDeque<>();
		char[] input =br.readLine().toCharArray();
		for (char c : input) {
			q.offer(c);
		}
		char[] str = br.readLine().toCharArray();
		Deque<Data> dq = new ArrayDeque<>();
		while (!q.isEmpty()) {
			char c = q.poll();

			if (!dq.isEmpty()) {
				Data peek = dq.peekLast();

				int idx = peek.idx + 1;
				// if (peek.idx == -1) {
				// 	peek.idx = -1;
				// }
				if (idx < str.length && str[idx] == c) {
					dq.offer(new Data(c, idx));
				} else {
					if (c == str[0]) {
						dq.offer(new Data(c, 0));
					} else {
						dq.offer(new Data(c, -1));
					}
				}
			} else {
				if (c == str[0]) {
					dq.offer(new Data(c, 0));
				} else {
					dq.offer(new Data(c, -1));
				}
			}

			if (!dq.isEmpty()) {
				Data peek = dq.peekLast();
				if (peek.idx == str.length - 1) {
					for (int i = peek.idx; i >= 0; i--) {
						dq.pollLast();
					}
				}
			}
		}

		// System.out.println(dq);

		if (!dq.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			while (!dq.isEmpty()) {
				Data now = dq.poll();

				sb.append(now.c);
			}
			System.out.println(sb);
		} else {
			System.out.println("FRULA");
		}
	}


	public static class Data{
		char c;
		int idx;

		public Data(char c, int idx) {
			this.c = c;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Data{" +
				"c=" + c +
				", idx=" + idx +
				'}';
		}
	}
}
