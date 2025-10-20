

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N+1][H+1];
		dp[1][0] = 1;

		int mod = 10007;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int v = Integer.parseInt(st.nextToken());
			dp[1][v] = 1;
		}
		// System.out.println(Arrays.toString(dp[1]));
		for (int i = 2; i <= N; i++) {
			for (int j = H; j >= 0; j--) {
				dp[i][j] +=dp[i-1][j];
				dp[i][j] %= mod;
			}
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				for (int j = H-v; j >= 0; j--) {
					dp[i][j + v] += dp[i - 1][j];
					dp[i][j + v] %= mod;
				}
			}
			// System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[N][H]);
	}
}
