package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_2758_로또 {
	public static long[][] dp;
	public static int R = 11, C = 2001;
	public static int N, M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new long[R][C];
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		for (int i = 1; i < R-1; i++) {
			for (int j = 1; j < C; j++) {
				if(dp[i][j] == 0) continue;
				int x = j*2;
				for (int k = x; k < C; k++) {
					dp[i+1][k] += dp[i][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			long result = 0;
			for (int i = 1; i <= M; i++) {
				result += dp[N][i];
			}
			sb.append(result).append("\n");
		}
		// for (int i = 0; i <= N; i++) {
		// 	for (int j = 0; j <= M; j++) {
		// 		System.out.print(dp[i][j] +" ");
		// 	}
		// 	System.out.println();
		// }
		System.out.println(sb);
	}
}
