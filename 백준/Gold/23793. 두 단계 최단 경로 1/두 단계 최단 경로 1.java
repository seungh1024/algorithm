

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Data>[] list;
	public static int x,y, z;

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
		}
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		z = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		int xyz = find(x, y,0);
		if (xyz != -1) {
			int yz = find(y, z,0);
			if (yz == -1) {
				xyz = -1;
			} else {
				xyz += yz;
			}
		}
		sb.append(xyz).append(" ");
		int xz = find(x, z,y);
		sb.append(xz);
		System.out.println(sb);
	}

	public static int find(int start, int end, int mid) {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));
		pq.offer(new Data(start, 0));
		int[] distance=  new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		boolean[] visited = new boolean[N + 1];

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;

			for (Data next : list[now.to]) {
				if(next.to == mid) continue;
				if (!visited[next.to] && distance[next.to] > distance[now.to] + next.cost) {
					distance[next.to] = distance[now.to] + next.cost;
					pq.offer(new Data(next.to, distance[next.to]));
				}
			}
		}

		int result = distance[end];
		if (distance[end] == Integer.MAX_VALUE) {
			result = -1;
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

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", cost=" + cost +
				'}';
		}
	}
}
