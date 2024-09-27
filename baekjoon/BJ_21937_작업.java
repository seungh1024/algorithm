package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_21937_작업 {
	public static int N, M;
	public static List<Integer>[] list;

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
			list[to].add(from);
		}

		int start = Integer.parseInt(br.readLine());
		find(start);
	}

	public static void find(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		boolean[] visited = new boolean[N+1];
		int result = 0;
		while(!q.isEmpty()) {
			int now = q.poll();

			for (int next : list[now]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
					result++;
				}
			}
		}

		System.out.println(result);
	}
}
