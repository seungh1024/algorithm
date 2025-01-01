package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_14938_서강그라운드 {
	public static int N,M, R;
	public static List<Data>[] list;
	public static int[] cost;
	public static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		cost = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			list[a].add(new Data(b, l));
			list[b].add(new Data(a, l));
		}

		result = 0;
		for (int i = 1; i <= N; i++) {
			find(i);
		}
		System.out.println(result);
	}

	public static void find(int start) {
		PriorityQueue<Data> q = new PriorityQueue<>(Comparator.comparingInt(o->o.length));
		q.offer(new Data(start, 0));
		int sum = 0;
		boolean[] visited = new boolean[N + 1];
		// visited[start] = true;

		while (!q.isEmpty()) {
			Data now = q.poll();

			if(visited[now.to])continue;
			visited[now.to] = true;
			sum += cost[now.to];
			for (Data next : list[now.to]) {
				if (!visited[next.to] && now.length + next.length <= M) {
					q.offer(new Data(next.to, now.length + next.length));
				}
			}
		}

		result = Math.max(result, sum);
	}


	public static class Data{
		int to;
		int length;

		public Data(int to, int length) {
			this.to = to;
			this.length = length;
		}
	}
}
