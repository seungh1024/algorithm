

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] parent;
	public static int[] cost;
	public static List<Integer>[] list;

	public static int MOD = 998_244_353;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		cost = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		cost[0] = 1;

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			int p = parent[i];

			list[p].add(i);
		}

		long result = find();
		System.out.println(result);
	}

	public static long find() {
		long[] dp = new long[N + 1];
		dp[0] = 1;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);

		long result = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			// System.out.println("now = "+now);

			long sum = 0;
			int depth = 0;
			int c = now;
			while (parent[c] != c) {
				int p = parent[c];
				depth++;
				if (cost[p] >= depth) {
					sum += dp[p];
					sum %= MOD;
				}
				c = p;
			}

			if (now != 0) {

				dp[now] = sum;
			}
			if (list[now].isEmpty()) {
				result += dp[now];
				result %= MOD;
			} else {
				for (int next : list[now]) {
					q.offer(next);
				}
			}
			// System.out.println(Arrays.toString(dp));
		}


		return result;
	}

}
