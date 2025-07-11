

import java.io.*;
import java.util.*;

public class Main {
	public static int  N;
	public static char[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = br.readLine().toCharArray();

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o->-o[0]));
		for (int i = 0; i < N; i++) {
			pq.offer(new int[] {i, data[i]});
		}

		boolean turn = true;
		boolean[] visited = new boolean[N];
		int idx = N-1;
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();

		while (!pq.isEmpty()) {
			if (turn) {

				while (idx >= 0) {
					// System.out.println(Arrays.toString(visited));
					// System.out.println(idx);
					if (!visited[idx]) {
						visited[idx] = true;
						a.append(data[idx]);
						turn = false;
						break;
					}
					idx--;
				}
				if(idx < 0) break;
			} else {
				int[] now = pq.poll();
				if(visited[now[0]]) continue;
				visited[now[0]] = true;
				b.append(data[now[0]]);
				turn = true;
			}
		}

		// System.out.println("a = "+a +", b = "+b);
		if (b.compareTo(a) < 0) {
			System.out.println("DA");
		} else {
			System.out.println("NE");
		}
		System.out.println(b);
	}
}
