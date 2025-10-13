

import java.io.*;
import java.util.*;

public class Main {
	public static int N, C;
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>(
			Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt((int[] o) -> o[0]));
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			pq.offer(new int[] {from, to, cost});
		}

		int[] cost = new int[N + 1];
		Arrays.fill(cost, C);

		int result = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int from = now[0];
			int to = now[1];
			int c = now[2];
			int max = Integer.MAX_VALUE;
			for (int i = from; i < to; i++) {
				max = Math.min(max, cost[i]);
			}
			int minus = Math.min(max, c);
			for (int i = from; i < to; i++) {
				cost[i] -= minus;
			}
			result += minus;
		}
		System.out.println(result);
	}
}
