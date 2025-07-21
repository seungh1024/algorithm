

import java.io.*;
import java.util.*;


public class Main {
	public static long[][] dp;
	public static String[] data = {"", "X", "YZ", "ZX"};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		dp = new long[101][3];
		dp[1][0] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][0] = 1;
		dp[3][2] = 1;

		for (int i = 4; i <= N; i++) {
			dp[i][0] = dp[i - 2][0] + dp[i - 3][0];
			dp[i][1] = dp[i - 2][1] + dp[i - 3][1];
			dp[i][2] = dp[i - 2][2] + dp[i - 3][2];
		}

		if (t == 1) {
			System.out.println(dp[N][0] + dp[N][1] + dp[N][2]);
		} else if (t == 2) {
			long k = Long.parseLong(br.readLine());
			Character result = find(k, N);
			System.out.println(result);
		} else {
			int idx = br.readLine().charAt(0)-'X';
			System.out.println(dp[N][idx]);
		}
	}

	public static Character find(long k, int N) {
		if (N <= 3) {
			return data[N].charAt((int)k - 1);
		}
		long leftCnt = dp[N - 3][0] + dp[N - 3][1] + dp[N - 3][2];

		if (k <= leftCnt) {
			return find(k, N - 3);
		} else {
			return find(k - leftCnt, N - 2);
		}
	}
}
