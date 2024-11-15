package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_2982_국왕의방문 {
	public static int N, M;
	public static int A,B,K, G;
	public static int[][] gondola;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		gondola = new int[N+1][N+1];
		int [] gonInput = new int[G];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < G; i++) {
			gonInput[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
		}

		makeGondola(gonInput);
		find();
	}

	public static void find() {
		PriorityQueue<Data> q = new PriorityQueue<>(Comparator.comparing((Data d)->d.cost));
		q.offer(new Data(A, K));
		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[A] = K;
		// visited[A] = true;

		while (!q.isEmpty()) {
			Data now = q.poll();
			// System.out.println(now);

			if(visited[now.to]) continue;
			visited[now.to] = true;

			if (now.to == B) {
				// System.out.println(now.cost-K);
				// break;
				continue;
			}

			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					int nextCost = now.cost;
					if(gondola[now.to][next.to] > 0 && gondola[now.to][next.to]-next.cost <= now.cost && gondola[now.to][next.to] > now.cost) {
						nextCost += gondola[now.to][next.to] - now.cost;
					}
					nextCost += next.cost;

					if (distance[next.to] > nextCost) {
						distance[next.to] = nextCost;
						q.offer(new Data(next.to, nextCost));
					}
				}
			}
		}

		System.out.println(distance[B]-K);
	}

	public static void makeGondola(int[] gonInput) {
		int cost = 0;
		for (int i = 1; i < G; i++) {
			int last = gonInput[i - 1];
			int now = gonInput[i];

			for (Data next : list[last]) {
				if (next.to == now) {
					cost += next.cost;
					break;
				}
			}

			gondola[last][now] = cost;
			gondola[now][last] = cost;
		}

		// for (int i = 0; i <= N; i++) {
		// 	System.out.println(Arrays.toString(gondola[i]));
		// }
	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		public String toString() {
			return "to = "+to + ", cost = "+cost;
		}
	}
}
