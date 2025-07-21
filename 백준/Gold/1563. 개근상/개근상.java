

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000;

		int[][][] dp = new int[N + 1][2][3];
		dp[1][0][0] = 1;
		dp[1][1][0] = 1;
		dp[1][0][1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i][0][0] = dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2];
			dp[i][0][1] = dp[i - 1][0][0];
			dp[i][0][2] = dp[i - 1][0][1];

			dp[i][0][0]%=mod;
			dp[i][0][1]%=mod;
			dp[i][0][2]%=mod;

			dp[i][1][0] = dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i
				- 1][1][2];
			dp[i][1][1] = dp[i - 1][1][0];
			dp[i][1][2] = dp[i - 1][1][1];

			dp[i][1][0] %= mod;
			dp[i][1][1] %= mod;
			dp[i][1][2] %= mod;
		}

		int sum = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				sum+=dp[N][i][j];
				sum %= mod;
			}
		}
		System.out.println(sum);

	}
}
