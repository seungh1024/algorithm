

import java.io.*;
import java.util.*;

public class Main {
	public static long[] dp;
	public static long MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		for (int i = 2; i <= 2500; i++) {
			for (int j = 0; j < i; j++) {
				dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
				dp[i*2] %= MOD;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int L = Integer.parseInt(br.readLine());
			sb.append(dp[L]).append("\n");
		}
		System.out.println(sb);

	}

}
