

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] data = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			data[i] = num;
		}

		List<Data>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		int p = Integer.parseInt(br.readLine());
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[a].add(new Data(b, t));
			data[b] += t;
		}

		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong((long[] o) -> o[1]));
		for (int i = 1; i <= N; i++) {
			pq.offer(new long[] {i, data[i]});
		}

		long max = 0;
		boolean[] visited = new boolean[N + 1];
		while (!pq.isEmpty() && M > 0) {
			long[] now = pq.poll();
			int idx = (int)now[0];
			if(visited[idx]) continue;
			visited[idx] = true;

			max = Math.max(max, now[1]);

			for (Data d : list[idx]) {
				data[d.b] -= d.t;
				pq.offer(new long[] {d.b, data[d.b]});
			}
			M--;
		}
		System.out.println(max);



	}


	public static class Data{
		int b;
		long t;

		@Override
		public String toString() {
			return "Data{" +
				"b=" + b +
				", t=" + t +
				'}';
		}

		public Data(int b, int t) {
			this.b = b;
			this.t = t;
		}
	}
}
