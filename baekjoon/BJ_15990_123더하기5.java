package algo_202405;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BJ_15990_123더하기5 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] dp = new long[100001][4];

		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		long mod = 1_000_000_009;
		for (int i = 4; i <= 100000; i++) {
			for (int j = 1; j <= 3; j++) {
				dp[i][j] = (dp[i-j][1] + dp[i-j][2] + dp[i-j][3] - dp[i-j][j])%mod;
			}
		}


		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append((dp[n][1]+dp[n][2]+dp[n][3])%mod).append("\n");
		}
		System.out.println(sb);

	}
}
