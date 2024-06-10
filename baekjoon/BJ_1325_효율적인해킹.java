package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_1325_효율적인해킹 {
	public static int N,M;
	public static List<Integer>[] list;
	public static boolean[] visited;
	public static Queue<Integer> q = new ArrayDeque<>();
	public static int[] totalCount;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		}

		q = new ArrayDeque<>();
		totalCount = new int[N+1];
		for (int i = 1; i <= N; i++) {
			q.offer(i);
			visited = new boolean[N+1];
			visited[i] = true;

			bfs();

		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, totalCount[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (totalCount[i] == max) {
				sb.append(i).append(" ");
			}
		}

		// System.out.println(sb);
		bw.write(sb.substring(0,sb.length()-1));
		bw.close();

	}

	private static void bfs() {

		while (!q.isEmpty()) {
			int now = q.poll();


			for (int next : list[now]) {
				if (!visited[next]) {
					visited[next] = true;
					totalCount[next]++;
					q.offer(next);
				}
			}
		}
	}

}
