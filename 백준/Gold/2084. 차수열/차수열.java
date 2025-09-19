

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
		int sum = 0;
		for (int i = 0; i < N; i++) {
			count[i] = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {i, count[i]});
			sum += count[i];
		}

		if (sum % 2 != 0) {
			System.out.println(-1);
			return;
		}

		int[][] result = new int[N][N];
		Queue<int[]> q = new ArrayDeque<>();
		while (!pq.isEmpty() && pq.size()>=2) {
			int[] now = pq.poll();
			int x = now[0];


			for (int i = 0; i < now[1]; i++) {
				if (pq.isEmpty()) {
					System.out.println(-1);
					return;
				}
				int[] next = pq.poll();
				int y = next[0];
				if (result[x][y] == 0) {
					next[1]--;
					result[x][y] = 1;
					result[y][x] = 1;
				}
				if (next[1] > 0) {
					q.offer(next);
				}
			}

			while (!q.isEmpty()) {
				pq.offer(q.poll());
			}

		}


		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
