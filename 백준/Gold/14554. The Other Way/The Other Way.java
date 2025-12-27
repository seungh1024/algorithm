

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M,S, E;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long C = Long.parseLong(st.nextToken());
			list[A].add(new Data(B, C));
			list[B].add(new Data(A, C));
		}

		find();
	}

	public static void find() {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.c));
		pq.offer(new Data(S, 0,1));
		long[] distance = new long[N + 1];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[S] = 0;
		boolean[] visited = new boolean[N + 1];
		long[] count = new long[N + 1];
		count[S] = 1;

		long mod = 1_000_000_009;
		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if (now.to == E) {
				continue;
			}
			if(visited[now.to]) continue;
			visited[now.to] = true;
			now.cnt = count[now.to];
			// System.out.println(now);

			for (Data next : list[now.to]) {
				// System.out.println("next = "+next);
				if (!visited[next.to]) {
					if (distance[next.to] > distance[now.to] + next.c) {
						distance[next.to] = distance[now.to] + next.c;
						count[next.to] = 0;
						count[next.to] += now.cnt;
						count[next.to] %= mod;
						pq.offer(new Data(next.to, distance[next.to], count[next.to]));
					} else if (distance[next.to] == distance[now.to] + next.c) {
						count[next.to] += now.cnt;
						count[next.to] %= mod;
						pq.offer(new Data(next.to, distance[next.to], count[next.to]));
					}
				}
			}

		}
		// System.out.println(Arrays.toString(count));

		System.out.println(count[E]);
	}

	public static class Data{
		int to;
		long c;
		long cnt;

		public Data(int to, long c, long cnt) {
			this.to = to;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", c=" + c +
				", cnt=" + cnt +
				'}';
		}

		public Data(int to, long c) {
			this.to = to;
			this.c = c;
		}
	}
}
