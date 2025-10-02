

import java.io.*;
import java.util.*;

public class Main {
	public static int result = Integer.MIN_VALUE;
	public static int[] data;
	public static int N, M;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N+1];
		int[] sum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
			sum[i] = sum[i - 1] + data[i];
		}

		dp = new int[N+1][M+1];
		for (int i = 0; i <= N; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
		for (int i = 0; i <= N; i++) {
			dp[i][0] = 0;   // 0개 고르면 합 0
		}
		for (int i = 1; i <= N; i++) {
			dp[i][1] = sum[i];
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
			for (int j = 1; j <= M; j++) {
				for (int k = i; k >=2; k--) {
					if(dp[k-2][j-1] == Integer.MIN_VALUE) continue;
					dp[i][j] = Math.max(dp[i][j], dp[k - 2][j - 1] + sum[i] - sum[k - 1]);
				}
				// if (j == 1) {
				// 	dp[i][1] = Math.max(dp[i][1], sum[i]);
				// }
			}
		}

		System.out.println(dp[N][M]);


	}

}
