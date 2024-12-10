package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_13905_세부 {
	public static int N, M;
	public static int S, E;
	public static List<Data>[] list;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[from].add(new Data(to, w));
			list[to].add(new Data(from, w));
		}

		find();
	}

	public static void find() {
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.w, o2.w));
		pq.offer(new Data(S, Integer.MAX_VALUE));
		boolean[] visited = new boolean[N+1];

		int result = 0;
		while(!pq.isEmpty()) {
			Data now = pq.poll();

			if (now.to == E) {
				result = Math.max(result, now.w);
				continue;
			}

			if(visited[now.to]) continue;
			visited[now.to] = true;


			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					pq.offer(new Data(next.to, Math.min(now.w, next.w)));
				}
			}
		}

		System.out.println(result);
	}

	public static class Data{
		int to;
		int w;

		public Data(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", w=" + w +
				'}';
		}
	}
}
