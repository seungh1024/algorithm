

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 1000000000;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[K + 1][N + 1];
		// 1개를 사용해서 합이 N이 되는 경우는 자기 자신
		for (int j = 0; j <= N; j++) {
			dp[1][j] = 1;
		}

		// K개를 더해서 1이 되는 경우는 K개
		// 3개인 경우 -> 100, 010, 001 이런 방식
		for (int i = 1; i <= K; i++) {
			dp[i][1] = i;
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 2; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				dp[i][j] %= mod;
			}
		}

		System.out.println(dp[K][N]);
	}
}
