package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_6118_숨바꼭질 {
	public static int N,M;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		find();
	}

	public static void find() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		boolean[] visited = new boolean[N+1];
		visited[1] = true;

		int minNum = Integer.MIN_VALUE;
		int totalCount = 0;
		int distance = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int min = Integer.MAX_VALUE;
			for (int s = 0; s < size; s++) {
				int now = q.poll();

				min = Math.min(min, now);

				for (int next : list[now]) {
					if (!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}

			minNum = min;
			totalCount = size;
			distance++;
		}

		System.out.println(minNum + " "+ (distance-1) +" " + totalCount);
	}
}
