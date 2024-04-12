package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_20007_떡돌리기 {
	public static int N,M,X,Y;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken())*2;
			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
		}

		find();
	}

	public static void find() {
		boolean[] visited = new boolean[N];
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(Y, 0));

		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[Y] = 0;

		int d = 0;
		int result = 0;
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			if(visited[now.to]) continue;
			visited[now.to] = true;
			if (d + now.cost <= X) {
				d += now.cost;
			} else {
				d = now.cost;
				result++;
			}

			for (Data next : list[now.to]) {
				if (!visited[next.to] && distance[next.to] > distance[now.to] + next.cost && distance[now.to]+next.cost <= X) {
					distance[next.to] = distance[now.to]+next.cost;
					pq.offer(new Data(next.to,distance[next.to]));
				}
			}
		}
		Arrays.sort(distance);
		// System.out.println(Arrays.toString(distance));
		if (distance[N - 1] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		if (d > 0) {
			result++;
		}

		System.out.println(result);
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
			return this.cost-d.cost;
		}

		@Override
		public String toString() {
			return "to = "+to +", cost = "+cost;
		}

	}

}
