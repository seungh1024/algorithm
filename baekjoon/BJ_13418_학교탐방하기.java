package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_13418_학교탐방하기 {
	public static int N, M;
	public static List<Data>[] list;
	public static Data start;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = (Integer.parseInt(st.nextToken())+1)%2;
			if (i == 0) {
				start = new Data(to, cost);
			}
			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
		}

		// 최소
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));
		long min = find(pq);
		// 최대
		pq = new PriorityQueue<>(Comparator.comparingInt(o->-o.cost));
		long max = find(pq);

		// System.out.println("min = "+min + ", max = "+max);

		System.out.println(max*max - min*min);
	}

	public static long find(PriorityQueue<Data> pq) {
		pq.offer(start);
		boolean[] visited = new boolean[N + 1];
		visited[0] = true;

		long sum = 0;
		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;
			// System.out.println(now);

			sum += now.cost;

			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					pq.offer(next);
				}
			}
		}

		return sum;
	}


	public static class Data{
		int to;
		int cost; // 0이 오르막길, 1이 내리막길

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

// 4 5
// 0 1 0
// 1 2 0
// 1 4 0
// 4 2 1
// 3 4 1
// 2 3 0