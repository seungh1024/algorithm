package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_20924_트리의기둥과가지 {
	public static int N, R;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
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
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(R, 0));
		boolean[] visited = new boolean[N + 1];
		visited[R] = true;

		int max = 0; // 가지 크기
		int sum = 0; // 기둥 크기
		boolean flag = false;
		while (!q.isEmpty()) {
			Data now = q.poll();

			// System.out.println(now);
			if (!flag && (list[now.to].size() > 2 ||(now.to == R && list[now.to].size() >= 2) || (now.to != R && list[now.to].size() == 1))) {
				flag = true;
				sum = now.cost;
			}

			if (flag) {
				max = Math.max(max, now.cost - sum);
			}

			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					visited[next.to] = true;
					q.offer(new Data(next.to, next.cost + now.cost));
				}
			}
		}

		System.out.println(sum + " " + max);
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
