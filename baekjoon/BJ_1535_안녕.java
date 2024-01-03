package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_1535_안녕 {
	public static int N;
	public static int[] L;
	public static int[] J;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		L = new int[N+1];
		J = new int[N+1];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			L[i] = Integer.parseInt(st1.nextToken());
			J[i] = Integer.parseInt(st2.nextToken());
		}
		int[][] dp = new int[N+1][100];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < 100; j++) {
				if (L[i] <= j) {
					dp[i][j] = Math.max(J[i] + dp[i - 1][j - L[i]], dp[i - 1][j]);
				} else {
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
			// System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[N][99]);

	}
}
