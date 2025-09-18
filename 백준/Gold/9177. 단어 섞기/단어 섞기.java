

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static char[] a,b, c;
	public static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = st.nextToken().toCharArray();
			b = st.nextToken().toCharArray();
			c = st.nextToken().toCharArray();
			N = a.length;
			M = b.length;
			K = c.length;

			dp = new boolean[N+1][M+1];
			dp[0][0] = true;
			for (int j = 1; j <= M; j++) {
				if (b[j-1] == c[j-1]) {
					dp[0][j] |= dp[0][j - 1];
				}
			}
			for (int i = 1; i <= N; i++) {
				if (a[i-1] == c[i-1]) {
					dp[i][0] |= dp[i-1][0];
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (a[i - 1] != c[i + j - 1] && b[j - 1] != c[i + j - 1]) {
						dp[i][j] = false;
					} else if (a[i - 1] == c[i + j - 1] && b[j - 1] != c[i + j - 1]) {
						dp[i][j] = dp[i - 1][j];
					} else if (a[i - 1] != c[i + j - 1] && b[j - 1] == c[i + j - 1]) {
						dp[i][j] = dp[i][j - 1];
					} else {
						dp[i][j] = (dp[i - 1][j] | dp[i][j - 1]);
					}
				}
			}
			sb.append("Data set ").append(t).append(": ");
			if (dp[N][M]) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");

		}

		System.out.println(sb);
	}

}
