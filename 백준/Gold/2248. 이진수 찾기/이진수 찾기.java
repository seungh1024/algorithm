

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		long I = Long.parseLong(st.nextToken());

		int[][] dp = new int[N+1][N+1];

		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= N; j++) {
				dp[i][j] += dp[i-1][j] + dp[i-1][j-1];
			}
			// System.out.println(Arrays.toString(dp[i]));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = N-1; i >= 0; i--) {
			int sum = 0;
			for (int j = 0; j <= L; j++) {
				sum += dp[i][j];
			}

			if (sum >= I) {
				sb.append("0");
			} else {
				I-=sum;
				L--;
				sb.append("1");
			}
		}
		System.out.println(sb);
	}
}
