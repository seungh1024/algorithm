

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long mod = 1000_000_000;
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];

		dp[2] = 1;

		for (int i = 3; i <= N; i++) {
			long a = ((i-1)*dp[i-2])%mod;
			long b = ((i-1)*dp[i-1])%mod;
			dp[i] = (a+b)%mod;
		}
		System.out.println(dp[N]);
	}
}
