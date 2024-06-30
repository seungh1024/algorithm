package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_14284_간선이야기 {
	public static int N, M;
	public static List<Point>[] list;
	public static int s,t;

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

			list[from].add(new Point(to, cost));
			list[to].add(new Point(from, cost));
		}

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		find();
	}

	public static void find() {
		Queue<Point> pq = new PriorityQueue<>();
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s] = 0;
		pq.offer(new Point(s, distance[s]));

		boolean[] visited = new boolean[N+1];

		while (!pq.isEmpty()) {
			Point now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;

			for(Point next : list[now.to]) {
				if (!visited[next.to] && distance[next.to] > distance[now.to] + next.cost) {
					distance[next.to] = distance[now.to] + next.cost;
					pq.offer(new Point(next.to, distance[next.to]));
				}
			}
		}

		System.out.println(distance[t]);
		//        System.out.println(Arrays.toString(distance));
	}

	public static class Point implements Comparable<Point>{
		int to;
		int cost;

		public Point(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point p){
			return this.cost - p.cost;
		}
	}
}
