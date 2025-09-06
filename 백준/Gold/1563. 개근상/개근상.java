

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mod = 1_000_000;
		int[][][] dp = new int[N + 1][3][3]; // 지각 횟수, 결석 연속 횟수
		dp[0][0][0] = 1;

		for (int i = 1; i <= N; i++) {
			dp[i][0][0] = dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2];
			dp[i][0][0] %= mod;

			dp[i][0][1] = dp[i-1][0][0];
			dp[i][0][2] = dp[i-1][0][1];

			dp[i][1][0] = dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2] + dp[i-1][1][0]+ dp[i-1][1][1] + dp[i-1][1][2];
			dp[i][1][0] %= mod;

			dp[i][1][1] = dp[i - 1][1][0];
			dp[i][1][2] = dp[i - 1][1][1];

		}
		System.out.println((dp[N][0][0] + dp[N][1][0] + dp[N][0][1] + dp[N][0][2] + dp[N][1][1]+dp[N][1][2]) % mod);
	}
}
