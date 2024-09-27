package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_1697_숨바꼭질 {
	public static int[] dp;
	public static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		find();
	}

	public static void find() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);
		dp[N] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			// System.out.println("now = "+now +", dp[now] = "+dp[now]);
			if (now == K) {
				break;
			}

			if (now + 1 <= 100000 && dp[now+1] > dp[now]+1) {
				dp[now+1] = dp[now]+1;
				q.offer(now+1);
			}
			if (now - 1 >= 0 && dp[now - 1] > dp[now] + 1) {
				dp[now-1] = dp[now]+1;
				q.offer(now - 1);
			}
			if (now * 2 <= 100000 && dp[now * 2] > dp[now] + 1) {
				dp[now * 2] = dp[now] + 1;
				q.offer(now * 2);
			}
		}

		System.out.println(dp[K]);
	}
}
