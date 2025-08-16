

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long[] dp = new long[1000001];
		dp[2] = 1;
		long mod = 1000000000;

		for (int i = 3; i <= N; i++) {
			dp[i] += dp[i - 2] * (i-1); // i가 서로 주고 받을 때
			dp[i] %= mod;

			dp[i] += dp[i - 1] * (i - 1); // 일방적으로 주는 경우
			dp[i] %= mod;
		}
		System.out.println(dp[(int)N]);
	}
}
