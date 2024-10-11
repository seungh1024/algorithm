package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_12851_숨바꼭질2 {
	public static int N, K;
	public static int[] dp;
	// public static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		// count = new int[100001];

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));
		pq.offer(new int[] {N, 0});
		dp[N] = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int n = now[0];
			int v = now[1];

			if (n - 1 >= 0 ) {
				if (dp[n - 1] > dp[n] + 1) {
					dp[n-1] = dp[n]+1;
					// count[n-1] = 1;
					pq.offer(new int[] {n - 1, dp[n - 1]});
				}
			}
			if (n + 1 <= 100000 ) {
				if (dp[n + 1] > dp[n] + 1) {
					dp[n+1] = dp[n]+1;
					// count[n+1] = 1;
					pq.offer(new int[] {n + 1, dp[n + 1]});
				}
			}
			if (n * 2 <= 100000) {
				if (dp[n * 2] > dp[n] + 1) {
					dp[n * 2] = dp[n] + 1;
					// count[n*2] = 1;
					pq.offer(new int[] {n * 2, dp[n] + 1});
				}
			}
		}

		System.out.println(dp[K]);

		// StringBuilder sb = new StringBuilder();
		// for (int i = 0; i <= 18; i++) {
		// 	sb.append(dp[i]).append(" ");
		// }
		// System.out.println(sb);
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {K, dp[K]});
		int[] count = new int[100001];
		boolean[] visited = new boolean[100001];
		visited[K] = true;
		count[K] = 1;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int n = now[0];
			int v = now[1];
			// System.out.println(Arrays.toString(now));


			if (n - 1 >= 0 && dp[n - 1] == dp[n] - 1 ) {
				count[n-1]++;
				q.offer(new int[] {n - 1, dp[n - 1]});
			}
			if (n + 1 <= 100000 && dp[n + 1] == dp[n] - 1) {
				count[n + 1]++;
				q.offer(new int[] {n + 1, dp[n + 1]});
			}
			if (n % 2 == 0 && n / 2 <= 100000 && dp[n / 2] == dp[n] - 1) {
				count[n / 2]++;
				q.offer(new int[] {n / 2, dp[n / 2]});
			}
		}

		System.out.println(count[N]);

	}
}
