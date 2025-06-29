

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000000;

		int[] dp = new int[1000001];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0) {
				dp[i] += dp[i / 2] + dp[i - 1];
			} else {
				dp[i] += dp[i - 1];
			}
			dp[i] %= mod;
		}
		System.out.println(dp[N]);
	}
}

// 1 1 1 1 1 1
// 1 1 1 1 2
// 1 1 2 2
// 1 1 4
// 2 4
// 2 2 2
//
//
// 2.
// 1 1
// 2
//
// 3.
// 1 1 1
// 1 2
//
// 4.
// 1 1 1 1
// 1 1 2
// 2 2
// 4