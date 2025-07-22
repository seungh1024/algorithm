

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[][] dp = new long[1001][1001];

		dp[1][1] = Long.parseLong(st.nextToken());

		long k1 = 0;
		long k2 = 0;
		long tmp = 0;

		for (int i = 1; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());
			tmp = Long.MIN_VALUE;
			for (int j = i; j >= 1; j--) {
				tmp = Math.max(tmp, dp[i][j]);
				dp[i+1][j + 1] = dp[i][j] + (j + 1L) * t;
			}

			dp[i+1][0] = Math.max(k1, k2);
			dp[i+1][1] = dp[i+1][0] + t;
			k2 = k1;
			k1 = tmp;
		}

		tmp = Math.max(k1, k2);
		for (int i = 1; i <= n; i++) {
			tmp = Math.max(tmp, dp[n][i]);
			// System.out.println(Arrays.toString(dp[i]));
		}

		System.out.println(Math.max(tmp, 0));
	}
}
