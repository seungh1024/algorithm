package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_6497_전력난 {
	public static int M, N;
	public static List<Data>[] list;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(M == 0 && N == 0) break;

			list = new ArrayList[M+1];
			for (int i = 0; i < M; i++) {
				list[i] = new ArrayList<>();
			}

			int totalCost = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				totalCost+=cost;

				list[from].add(new Data(to, cost));
				list[to].add(new Data(from, cost));
			}

			int result = find();
			sb.append(totalCost-result).append("\n");
		}

		System.out.println(sb);
	}

	public static int find() {
		int total = 0;
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(0, 0));
		boolean[] visited = new boolean[M];

		int count = 0;
		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;

			total += now.cost;
			count++;
			if(count == M) break;

			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					pq.offer(next);
				}
			}
		}

		return total;
	}

	public static class Data implements Comparable<Data> {
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data d) {
			return this.cost - d.cost;
		}
	}
}
