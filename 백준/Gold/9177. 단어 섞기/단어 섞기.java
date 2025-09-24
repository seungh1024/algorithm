

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("Data set ").append(t).append(": ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] a = st.nextToken().toCharArray();
			char[] b = st.nextToken().toCharArray();
			char[] data = st.nextToken().toCharArray();

			int N = a.length;
			int M = b.length;

			int[][] dp = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				dp[i][0] = i;
			}
			for (int j = 1; j <= M; j++) {
				dp[0][j] = j;
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					int idx = i+j-1;
					if (a[i - 1] == data[idx]) {
						dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + 1);
					}
					if (b[j - 1] == data[idx]) {
						dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
					}
				}
			}
			if (dp[N][M] == data.length) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
