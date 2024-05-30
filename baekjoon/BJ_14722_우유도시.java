package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_14722_우유도시 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N+1][N+1];
		int[][][] dp = new int[N+1][N+1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 0) {
					dp[i][j][0] = 1;
				}
			}

		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = Math.max(dp[i][j][k], Math.max(dp[i - 1][j][k], dp[i][j - 1][k]));
				}
				int last = (data[i][j]+2)%3;
				if (dp[i][j][data[i][j]] < dp[i - 1][j][last]) {

					dp[i][j][data[i][j]] = Math.max(dp[i][j][data[i][j]], dp[i - 1][j][last]+1);
				}
				if (dp[i][j][data[i][j]] < dp[i][j - 1][last]) {

					dp[i][j][data[i][j]] = Math.max(dp[i][j][data[i][j]], dp[i][j - 1][last]+1);
				}
				// if (last == data[i - 1][j]) {
				// }
				// if (last == data[i][j - 1]) {
				// }
			}
		}

		System.out.println(Math.max(dp[N][N][0],Math.max(dp[N][N][1],dp[N][N][2])));

	}
}