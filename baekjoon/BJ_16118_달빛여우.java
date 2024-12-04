package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_16118_달빛여우 {
	public static int N, M;
	public static List<Data>[] list;
	public static long[] fox;
	public static long[][] wolf;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken())*2;

			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
		}

		findFox();
		findWolf();

		int result = 0;
		for (int i = 1; i <= N; i++) {

			if (fox[i] < Math.min(wolf[i][0],wolf[i][1])) {
				result ++;
			}
		}
		// System.out.println(Arrays.toString(fox));
		// for (int i = 1; i <= N; i++) {
		// 	System.out.println(Arrays.toString(wolf[i]));
		// }
		System.out.println(result);
	}

	public static void findFox() {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		// boolean[] visited = new boolean[N+1];
		pq.offer(new Data(1, 0));
		fox = new long[N+1];
		Arrays.fill(fox, Long.MAX_VALUE);
		fox[1] = 0;

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			// if(visited[now.to]) continue;
			// visited[now.to] = true;
			if(fox[now.to] < now.cost) continue;

			for (Data next : list[now.to]) {
				if (fox[next.to] > fox[now.to] + next.cost) {
					fox[next.to] = fox[now.to]+next.cost;
					pq.offer(new Data(next.to, fox[next.to]));
				}
			}
		}
	}

	public static void findWolf() {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		// boolean[][] visited = new boolean[N+1][2];
		pq.offer(new Data(1, 0, 0));
		wolf = new long[N+1][2];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(wolf[i], Long.MAX_VALUE);
		}
		wolf[1][0] = 0;
		// wolf[1][1] = 0;

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			int idx = now.run;
			int nextIdx = 1-now.run;
			// if(visited[now.to][idx]) continue;
			// visited[now.to][idx] = true;

			if(wolf[now.to][idx] < now.cost) continue;

			for (Data next : list[now.to]) {
				long nextCost = now.cost + (now.run == 0 ? (next.cost / 2) : (next.cost * 2));
				if (wolf[next.to][nextIdx] > nextCost) {
					wolf[next.to][nextIdx] = nextCost;
					pq.offer(new Data(next.to, wolf[next.to][nextIdx], nextIdx));
				}

			}
		}
	}

	public static class Data implements Comparable<Data>{
		int to;
		long cost;
		int run;

		public Data(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		public Data(int to, long cost, int run) {
			this.to = to;
			this.cost = cost;
			this.run = run;
		}

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", cost=" + cost +
				", run=" + run +
				'}';
		}

		@Override
		public int compareTo(Data o) {
			if(this.cost < o.cost) {
				return -1;
			} else if(this.cost > o.cost) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
