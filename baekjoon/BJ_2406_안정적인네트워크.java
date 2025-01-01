package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_2406_안정적인네트워크 {
	public static int N, M;
	public static List<Data>[] list;
	public static boolean[][] connected;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		connected = new boolean[N+1][N+1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			connected[1][i] = true;
			connected[i][1] = true;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connected[a][b] = true;
			connected[b][a] = true;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if(i == j)continue;
				if (i != 1 && j != 1 && connected[i][j]) {
					cost = 0;
				}
				list[i].add(new Data(j, cost));
				list[j].add(new Data(i, cost));
			}
		}

		find();
	}

	public static void find() {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		pq.offer(new Data(1,2, 0));
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;

		int cnt = 0;
		int sum = 0;
		List<Data> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;

			// System.out.println("now = "+now);

			if (!connected[now.from][now.to]) {
				connected[now.from][now.to] = true;
				connected[now.to][now.from] = true;
				cnt++;
				sum += now.cost;
				// System.out.println(now);
				result.add(now);
			}

			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					// System.out.println(next);
					Data data = new Data(now.to, next.to, next.cost);
					pq.offer(data);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(sum).append(" ").append(cnt).append("\n");

		if (cnt > 0) {
			for (Data data : result) {
				sb.append(data.from).append(" ").append(data.to).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static class Data{
		int from;
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

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
