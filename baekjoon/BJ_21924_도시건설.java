package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_21924_도시건설 {
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

		long sum = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());

			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
			sum+=cost;
		}

		long minCost = find();

		if (minCost == -1) {
			System.out.println(-1);
		} else {
			System.out.println(sum-minCost);
		}

	}

	public static long find() {
		long result = 0;

		PriorityQueue<Data> q = new PriorityQueue<>(Comparator.comparing((Data data)-> data.cost));
		q.offer(new Data(1, 0));
		boolean[] visited = new boolean[N+1];

		int count = 0;
		while (!q.isEmpty()) {
			Data now = q.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;

			result += now.cost;
			count++;

			if (count == N) {
				break;
			}

			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					q.offer(next);
				}
			}
		}

		if (count != N) {
			result = -1;
		}

		return result;
	}

	public static class Data{
		int to;
		long cost;

		public Data(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
