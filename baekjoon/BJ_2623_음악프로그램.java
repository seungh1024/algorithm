package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_2623_음악프로그램 {
	public static int N, M;
	public static int[] count;
	public static List<Integer>[] list;
	public static Queue<Integer> q;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = new int[N+1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			for (int j = 1; j < k; j++) {
				int now = Integer.parseInt(st.nextToken());
				list[last].add(now);
				count[now]++;
				last = now;
			}
		}

		find();
	}

	public static void find() {
		q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				q.offer(i);
			}
		}

		List<Integer> ans = new ArrayList<>();
		while (!q.isEmpty()) {
			int now = q.poll();
			ans.add(now);

			for (int next : list[now]) {
				count[next]--;
				if (count[next] <= 0) {
					q.offer(next);
				}
			}
		}

		if (ans.size() < N) {
			System.out.println(0);
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i : ans) {
				sb.append(i).append("\n");
			}
			System.out.println(sb);
		}
	}
}
