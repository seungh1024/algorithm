

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000007;
		long[] dp = new long[10001];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 5;

		for (int i = 4; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
				dp[i]%=mod;
			}
		}
		System.out.println(dp[N]);
	}
}
