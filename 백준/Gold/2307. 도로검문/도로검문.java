

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Data>[] list;
	public static int[] path;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		List<int[]> road = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
			road.add(new int[] {from, to});
		}

		path = new int[N + 1];
		int time = find(0, 0);
		int max = 0;
		for (int i = N; i > 0; i = path[i]) {
			int value = find(i, path[i]);
			if (value == Integer.MAX_VALUE) {
				max = -1;
				break;
			}
			if (value > time) {
				max = Math.max(value - time, max);
			}
		}

		System.out.println(max);
	}

	public static int find(int p1, int p2) {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));

		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		pq.offer(new Data(1, 0));

		while (!pq.isEmpty()) {
			Data data = pq.poll();

			if (distance[data.to] < data.cost) {
				continue;
			}

			for (Data next : list[data.to]) {
				if((data.to == p1 && next.to ==p2) || (data.to == p2 && next.to == p1)) continue;

				if (distance[next.to] > distance[data.to] + next.cost) {
					distance[next.to] = distance[data.to] + next.cost;
					pq.offer(new Data(next.to, distance[next.to]));
					if (p1 == 0 && p2 == 0) {
						path[next.to] = data.to;
					}
				}
			}
		}


		return distance[N];
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
