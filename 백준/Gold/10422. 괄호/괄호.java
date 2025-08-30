

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		dp[4] = 2;
		dp[6] = 5;

		long mod = 1000000007;
		for (int i = 8; i <= 5000; i += 2) {
			for (int j = 0; j < i; j += 2) {
				dp[i] += (dp[j] * dp[i - j - 2]);
				dp[i] %= mod;
			}
		}

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int L = Integer.parseInt(br.readLine());
			sb.append(dp[L]).append("\n");
		}
		System.out.println(sb);
	}
}
