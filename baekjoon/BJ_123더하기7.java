package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_123더하기7 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = 1001;
		int[][] dp = new int[size][size];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[3][1] = 1;

		int mod = 1_000_000_009;
		for (int i = 2; i < size; i++) {
			for (int j = 1; j < size; j++) {
				for (int k = 1; k <= 3; k++) {
					if (i - k > 0) {
						dp[i][j] += dp[i-k][j-1];
						dp[i][j] %= mod;
					}
				}
			}
		}

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(dp[a][b]).append("\n");
		}
		System.out.println(sb);
	}
}
