

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] algo;
	public static int R;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		algo = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			algo[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		R = Integer.parseInt(br.readLine());
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Data(to, cost));
		}

		int result = find();
		System.out.println(result);
	}

	public static int find() {
		int start = 1;
		int end = 100000000;

		while (start < end) {
			int mid = (start + end) / 2;
			int cnt = check(mid);
			if (cnt >= M) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if (check(start - 1)>=M) {
			start--;
		}

		return start;
	}
	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static int check(int range) {
		int cnt = 0;
		int[] copy = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			copy[i] = algo[i];
		}

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (copy[i] <= range) {
				q.offer(i);
			}
		}

		boolean[] visited = new boolean[N + 1];
		while (!q.isEmpty()) {
			int now = q.poll();

			if(visited[now]) continue;
			visited[now] =true;
			for (Data next : list[now]) {
				copy[next.to] -= next.cost;
				if (copy[next.to] <= range) {
					q.offer(next.to);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (copy[i] <= range) {
				cnt++;
			}
		}

		return cnt;
	}
}
