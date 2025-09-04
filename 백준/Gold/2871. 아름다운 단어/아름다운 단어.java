

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		PriorityQueue<Data> pq = new PriorityQueue<>(
			Comparator.comparing((Data o) -> o.c).thenComparingInt((Data o) -> -o.idx));

		for (int i = 0; i < N; i++) {
			pq.offer(new Data(i, input[i]));
		}

		boolean[] visited = new boolean[N];
		boolean turn = true;
		int idx = N-1;

		StringBuilder hw = new StringBuilder();
		StringBuilder sg = new StringBuilder();
		while (!pq.isEmpty()) {
			if (turn) {
				while (idx >= 0) {
					if (!visited[idx]) {
						visited[idx] = true;
						sg.append(input[idx]);
						break;
					}
					idx--;
				}
			} else {
				while (!pq.isEmpty()) {
					Data now = pq.poll();
					if(visited[now.idx]) continue;
					visited[now.idx] = true;
					hw.append(now.c);
					break;
				}
			}
			turn = !turn;
		}

		if (hw.compareTo(sg) < 0) {
			System.out.println("DA");
		} else {
			System.out.println("NE");
		}
		System.out.println(hw);
	}

	public static class Data {
		int idx;
		char c;

		public Data(int idx, char c) {
			this.idx = idx;
			this.c = c;
		}
	}
}
