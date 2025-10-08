

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static char[] A,B;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();

		dp = new int[M][N];
		for (int i = 0; i < N; i++) {
			if (B[0] == A[i]) {
				dp[0][i] = 1;
			}
		}

		for (int i = 1; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (B[i] == A[j]) {
					dp[i][j] = Math.max(dp[i][j], 1);
					if (j + 1 < N) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
					}
					if (j - 1 >= 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
					}
				}else{
					if (j + 1 < N) {
						dp[i][j] = Math.max(dp[i][j], dp[i-1][j + 1]);
					}
					if (j - 1 >= 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[M - 1][i]);
		}

		System.out.println(max);
	}
}
