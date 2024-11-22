package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_10159_저울 {
	public static int N, M;
	public static List<Integer>[] left, right;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		left = new ArrayList[N+1];
		right = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			left[i] = new ArrayList<>();
			right[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			left[l].add(r);
			right[r].add(l);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int count = find(i);
			sb.append(N-1-count).append("\n");
		}

		System.out.println(sb);
	}

	public static int find(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);

		int count = 0;
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		while (!q.isEmpty()) {
			int now = q.poll();

			for(int i : left[now]) {
				if (!visited[i]) {
					visited[i] = true;
					q.offer(i);
					count++;
				}
			}
		}

		q.offer(start);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i : right[now]) {
				if (!visited[i]) {
					visited[i] = true;
					q.offer(i);
					count++;
				}
			}
		}

		return count;
	}
}
