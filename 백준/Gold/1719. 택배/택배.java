import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Data>[] list;

	public static int[][] result;


	public static void main(String[] args) throws IOException {
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

			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
		}

		result = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			find(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (result[i][j] == 0) {
					sb.append('-');
				} else {
					sb.append(result[i][j]);
				}
				sb.append(' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void find(int start) {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		pq.offer(new Data(0, start, 0));
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		boolean[] visited = new boolean[N + 1];

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;

			if (now.from != 0) {
				result[start][now.to] = now.from;
			}


			for (Data next : list[now.to]) {
				if (!visited[next.to] && distance[next.to] > distance[now.to] + next.cost) {
					distance[next.to] = distance[now.to] + next.cost;
					if (now.from == 0) {
						pq.offer(new Data(next.to, next.to, distance[next.to]));
					} else {
						pq.offer(new Data(now.from, next.to, distance[next.to]));
					}
				}
			}
		}
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
	}
}