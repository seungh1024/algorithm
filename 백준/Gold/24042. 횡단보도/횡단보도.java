

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(new Data(i,to,i));
			list[to].add(new Data(i,from,i));
		}

		find();
	}

	public static void find() {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.time));
		pq.offer(new Data(0, 1,0));
		boolean[] visited = new boolean[N + 1];
		long[] distance = new long[N + 1];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[1] = 0;

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if (now.to == N) {
				System.out.println(now.time);
				break;
			}

			if(visited[now.to]) continue;
			visited[now.to] = true;

			// System.out.println(now);


			for (Data next : list[now.to]) {
				// System.out.println("next = "+next);
				long value = 0;
				if (now.idx < next.idx) {
					value = next.idx - now.idx;
				}else{
					value = M-now.idx + next.idx;
				}
				// value += 1;

				if (!visited[next.to] && distance[next.to] > distance[now.to] + value) {
					distance[next.to] = distance[now.to] + value;
					pq.offer(new Data(distance[next.to], next.to,next.idx));

				}
			}

		}

	}

	public static class Data{
		long time;
		int to;
		int idx;

		public Data(long time, int to, int idx) {
			this.time = time;
			this.to = to;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Data{" +
				"time=" + time +
				", to=" + to +
				'}';
		}
	}
}
