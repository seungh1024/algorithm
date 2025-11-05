

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] W = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] L = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		int K = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + W[i];
		}
		for (int j = 1; j <= M; j++) {
			if (((dp[0][j - 1]%K)+K)%K == 0) {
				dp[0][j] = dp[0][j - 1] - L[j];
			} else {
				dp[0][j] = dp[0][j - 1] - Math.min(((dp[0][j - 1]%K)+K)%K, L[j]);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (((dp[i][j - 1]%K)+K)%K == 0) {
					dp[i][j] = Math.max(dp[i - 1][j] + W[i], dp[i][j - 1] - L[j]);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j] + W[i], dp[i][j - 1]-Math.min(((dp[i][j - 1]%K)+K)%K, L[j]));
				}
			}
		}

		System.out.println(dp[N][M]);
	}
}
