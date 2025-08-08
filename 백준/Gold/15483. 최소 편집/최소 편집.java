

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();

		int N = A.length;
		int M = B.length;

		int[][] dp = new int[N+1][M+1];

		for (int i = 1; i <= N; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= M; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= N; i++) {
			char a = A[i-1];
			for (int j = 1; j <= M; j++) {
				char b = B[j-1];
				if (a == b) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}
