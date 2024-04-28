package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_16202_MST게임 {
	public static int N,M,K;
	public static List<Point>[] list;
	public static boolean[][] broke;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(new Point(to, i));
			list[to].add(new Point(from, i));
		}

		broke = new boolean[N+1][N+1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			int score = find();
			sb.append(score).append(" ");
			// System.out.println("=======");
		}
		System.out.println(sb);
	}

	public static int find() {
		Queue<Point> q = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		q.offer(new Point(1, 0));
		int cost = 0;

		int from = 0;
		int to = 0;
		int minCost = Integer.MAX_VALUE;

		int count = 0;

		while (!q.isEmpty()) {
			Point now = q.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;
			cost += now.cost;
			count++;


			for (Point next : list[now.to]) {
				if (!visited[next.to] && !broke[now.to][next.to]) {
					// System.out.println("next = "+next);
					q.offer(next);
					if (next.cost < minCost) {
						from = now.to;
						to = next.to;
						minCost = next.cost;
					}
				}
			}
		}

		if (count != N) {
			return 0;
		}

		broke[from][to] = true;
		broke[to][from] = true;

		return cost;
	}

	public static class Point implements Comparable<Point>{
		int to;
		int cost;

		public Point(int to, int cost){
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point point) {
			return this.cost - point.cost;
		}

		@Override
		public String toString() {
			return "to = "+to + ", cost = "+cost;
		}
	}
}
