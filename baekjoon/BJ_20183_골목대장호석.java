package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_20183_골목대장호석 {
	public static int N,M,A,B;
	public static long C;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Long.parseLong(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[from].add(new Data(from, to, cost));
			list[to].add(new Data(to, from, cost));
		}

		find();
	}

	public static void find(){
		long start = 1;
		long end = 1_000_000_001;

		while (start < end) {
			long mid = (start+end)/2;


			PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing((Data data) -> data.cost));
			long[] distance = new long[N+1];
			Arrays.fill(distance, Long.MAX_VALUE);
			distance[A] = 0;
			pq.offer(new Data(0, A, 0));
			boolean[] visited = new boolean[N + 1];

			boolean flag = false;
			while (!pq.isEmpty()) {
				Data now = pq.poll();
				// System.out.println(now);

				if(visited[now.to])continue;
				visited[now.to] = true;

				if (now.to == B) {
					flag = true;
					break;
				}

				for (Data next : list[now.to]) {
					if (!visited[next.to] && distance[next.to] > distance[now.to] + next.cost && distance[now.to]+next.cost <=C && next.cost <= mid) {
						distance[next.to] = distance[now.to]+next.cost;
						pq.offer(new Data(0, next.to, distance[next.to]));
					}
				}
			}

			// System.out.println("mid = "+mid + ", flag = "+flag);
			if (flag) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		// System.out.println(start);
		if (start == 1_000_000_001) {
			System.out.println(-1);
		} else {
			System.out.println(start);
		}

	}


	public static class Data{
		int from;
		int to;
		long cost;

		public Data(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Data{" +
				"from=" + from +
				", to=" + to +
				", cost=" + cost +
				'}';
		}
	}
}
