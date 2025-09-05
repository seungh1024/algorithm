

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N + 4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N + 1][4]; // 0 -> no, 1,2,3 -> button
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		dp[0][0] = 0;


		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + data[i]);
			dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + data[i] * 2);
			if (dp[i - 1][1] != Integer.MIN_VALUE) {

				dp[i][2] = Math.max(dp[i][2], dp[i - 1][1] + data[i] * 2);
			}
			if (dp[i - 1][2] != Integer.MIN_VALUE) {
				dp[i][3] = Math.max(dp[i][3], dp[i - 1][2] + data[i] * 2);
			}
			if (dp[i - 1][3] != Integer.MIN_VALUE) {
				dp[i][0] = Math.max(dp[i][0], dp[i - 1][3] + data[i]);
				dp[i][1] = Math.max(dp[i][1], dp[i - 1][3] + data[i]*2);
			}
			// System.out.println(Arrays.toString(dp[i]));
		}

		int result = dp[N][0];
		for (int i = 1; i <= 3; i++) {
			result = Math.max(result, dp[N][i]);
		}
		System.out.println(result);
	}
}
