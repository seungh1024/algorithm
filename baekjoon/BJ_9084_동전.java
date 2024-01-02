package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_9084_동전 {
	public static int N,M;
	public static int[] data;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());

			int[][] dp = new int[N+1][M+1];

			for (int i = 1; i <= N; i++) {
				dp[i][0] = 1;
				for (int j = 1; j <= M; j++) {
					dp[i][j] = dp[i-1][j];
					if (j >= data[i]) {
						dp[i][j] += dp[i][j - data[i]];;
					}
				}
			}
			sb.append(dp[N][M]).append("\n");

			// for (int i = 0; i <= N; i++) {
			// 	System.out.println(Arrays.toString(dp[i]));
			// }

		}
		System.out.println(sb);
	}


}
