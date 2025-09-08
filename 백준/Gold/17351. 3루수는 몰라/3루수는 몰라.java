

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new char[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				data[i][j] = input[j-1];
			}
		}

		int[][][] dp = new int[N + 1][N + 1][4];

		// int max = 0;
		for (int i = 1; i <= N; i++) {
			// System.out.println("i = "+i);
			for (int j = 1; j <= N; j++) {

				if (data[i][j] == 'M') {
					dp[i][j][0]++;
					dp[i][j][0] += Math.max(dp[i - 1][j][3], dp[i][j - 1][3]);
				} else if (data[i][j] == 'O') {
					dp[i][j][1] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
				} else if (data[i][j] == 'L') {
					dp[i][j][2] = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);

				} else if (data[i][j] == 'A') {
					dp[i][j][3] = Math.max(dp[i - 1][j][2], dp[i][j - 1][2]);
					// max = Math.max(max, dp[i][j][3]);
				}else{
					// if (data[i - 1][j] == 'A' || data[i][j - 1] == 'A') {
					// 	dp[i][j][3] = Math.max(dp[i - 1][j][2], dp[i][j - 1][2]);
					// } else if (data[i - 1][j] == 'L' || data[j][j - 1] == 'L') {
					// 	dp[i][j][2] = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);
					// } else if (data[i - 1][j] == 'O' || data[i][j - 1] == 'O') {
					// 	dp[i][j][1] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
					// } else if (data[i - 1][j] == 'M' || data[i][j - 1] == 'M') {
					// 	dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
					// }
				}
				dp[i][j][3] = Math.max(dp[i][j][3], Math.max(dp[i - 1][j][3], dp[i][j - 1][3]));


				// System.out.println(Arrays.toString(dp[i][j]));
			}
		}
		System.out.println(dp[N][N][3]);
	}
}
