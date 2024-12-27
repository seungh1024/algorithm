package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_14267_회사문화1 {
	public static int N, M;
	public static List<Integer>[] list;
	public static int[] count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		st.nextToken();
		for (int i = 2; i <= N; i++) {
			int superior = Integer.parseInt(st.nextToken());
			list[superior].add(i);
		}

		count = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			count[idx] += value;
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1, 0});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int idx = now[0];
			int value = now[1];

			for (int next : list[idx]) {
				count[next] += value;
				q.offer(new int[] {next, count[next]});
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(count[i]).append(" ");
		}
		System.out.println(sb);
	}
}
