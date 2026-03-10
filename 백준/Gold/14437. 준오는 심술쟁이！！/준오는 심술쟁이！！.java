

import java.io.*;
import java.util.*;

public class Main {
	public static int S;
	public static char[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		int N = input.length;
		data = new char[N + 1];
		for (int i = 1; i <= N; i++) {
			data[i] = input[i - 1];
		}

		int M = 3000;
		long[] dp = new long[M+1];
		long mod = 1_000_000_007;

		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = M; j >= 0; j--) {
				for (int k = 1; k <= 25; k++) {
					if(j-k < 0) continue;
					dp[j] += dp[j - k];
					dp[j] %= mod;
				}
			}
			// System.out.println(Arrays.toString(dp));
		}

		System.out.println(dp[S]);
	}
}
