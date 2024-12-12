package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_19581_두번째트리의지름 {
	public static int N;
	public static List<Data>[] list;
	public static boolean[] visited;
	public static int[] distance;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
		}

		visited = new boolean[N+1];
		int[] startPoint = find(1);
		visited = new boolean[N+1];
		int[] longPoint = find(startPoint[0]);

		visited = new boolean[N+1];
		visited[startPoint[0]] = true;
		int[] point1 = find(longPoint[0]);
		visited = new boolean[N+1];
		visited[longPoint[0]] = true;
		int[] point2 = find(startPoint[0]);

		System.out.println(Math.max(point1[1], point2[1]));

	}

	public static int[] find(int start) {
		Queue<Data> pq = new ArrayDeque<>();
		pq.offer(new Data(start, 0));
		visited[start] = true;

		int[] result = new int[2];
		int max = 0;

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if (now.cost > max) {
				max = now.cost;
				result[0] = now.to;
				result[1] = now.cost;
			}

			for(Data next : list[now.to]) {
				if (!visited[next.to]) {
					visited[next.to] = true;
					pq.offer(new Data(next.to, next.cost + now.cost));
				}
			}
		}

		return result;
	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;

		}
	}
}
