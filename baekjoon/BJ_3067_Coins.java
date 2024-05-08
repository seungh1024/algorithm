package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_3067_Coins {
	public static int T, N, M;
	public static int[] data;
	public static int[][] dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			dp = new int[N+1][M+1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (j == data[i - 1]) {
						dp[i][j] = 1;
						// continue;
					}
					else if (j > data[i-1]) {
						// dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - data[i-1]]);
						// dp[i][j] = Math.max(dp[i][j], dp[i][j - data[i - 1]]);
						dp[i][j] = Math.max(dp[i][j - data[i - 1]], dp[i - 1][j - data[i - 1]]);
					}
					dp[i][j] += dp[i-1][j];
				}
			}
			// System.out.println(dp[N][M]);
			// for (int i = 0; i <= N; i++) {
			// 	System.out.println(Arrays.toString(dp[i]));
			// }
			sb.append(dp[N][M]).append("\n");
		}
		System.out.println(sb);
	}

}
