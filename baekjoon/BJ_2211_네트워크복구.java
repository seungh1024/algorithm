package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_2211_네트워크복구 {
	public static int N, M;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Data(from, to, cost));
			list[to].add(new Data(to, from, cost));
		}

		find();
	}

	public static void find() {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing((Data data) -> data.cost));
		pq.offer(new Data(0, 1, 0));
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		boolean[] visited = new boolean[N + 1];

		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			// System.out.println(now);

			if(visited[now.to]) continue;
			visited[now.to] = true;
			if (now.from != 0) {
				count++;
				sb.append(now.from).append(" ").append(now.to).append("\n");
			}

			for (Data next : list[now.to]) {
				if (!visited[next.to] && distance[next.to] > distance[now.to] + next.cost) {
					distance[next.to] = distance[now.to] + next.cost;
					pq.offer(new Data(now.to, next.to, distance[next.to]));
				}
			}
		}

		System.out.println(count);
		System.out.println(sb);
	}

	public static class Data{
		int from;
		int to;
		int cost;

		public Data(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Data{" +
				"from=" + from +
				", to=" + to +
				", cost=" + cost +
				'}';
		}
	}
}
