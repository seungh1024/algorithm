package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_20168_골목대장호석 {
	public static int N,M,A,B, C;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
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

		find();
	}

	public static void find() {
		int start = 0;
		int end = 1001;

		int count = 5;
		while (start < end) {
			// System.out.println("start = "+start +", end = "+end );
			int mid = (start + end) / 2;

			PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing((Data data) -> data.cost));
			pq.offer(new Data(A, 0));
			int[] distance = new int[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[A] = 0;
			boolean[] visited = new boolean[N+1];

			boolean flag = false;
			while (!pq.isEmpty()) {
				Data now = pq.poll();

				// System.out.println(now);

				if(visited[now.to]) continue;
				visited[now.to] = true;

				if (now.to == B) {
					flag = true;
					break;
				}
				for (Data next : list[now.to]) {
					if (next.cost <= mid && !visited[next.to] && distance[next.to] > distance[now.to] + next.cost && distance[now.to] +next.cost <=C) {
						distance[next.to] = distance[now.to] + next.cost;
						pq.offer(new Data(next.to, distance[next.to]));
					}
				}

			}

			if (flag) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if (start == 1001) {
			System.out.println(-1);
		} else {
			System.out.println(start);
		}
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
