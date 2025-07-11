

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[][] dp = new long[3001][3001];
		// Arrays.fill(dp[0], 1);
		// st = new StringTokenizer(br.readLine());
		// int a = Integer.parseInt(st.nextToken());
		// int b = Integer.parseInt(st.nextToken());
		// for (int i = a; i <= b; i++) {
		// 	dp[1][i] = 1;
		// }
		// for (int j = 1; j <= 3000; j++) {
		// 	dp[1][j] += dp[1][j - 1];
		// }
		// System.out.println();

		// System.out.println(Arrays.toString(dp[1]));

		long[][] sum = new long[3001][3001];
		long mod = 1000000007;
		int a = 0;
		int b = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (i == 1) {
				for (int j = start; j <= end; j++) {
					dp[i][j] = 1;
				}
				a = start;
				b = end;
			} else {

				for (int j = start; j <= end; j++) {
					int max = Math.min(j + K, b);
					int min = Math.max(a, j - K);

					dp[i][j] = (sum[i - 1][max] - sum[i - 1][min-1] + mod);
					dp[i][j] %= mod;
				}
				a = start;
				b = end;
			}
			for (int j = 1; j <= 3000; j++) {
				sum[i][j] += sum[i][j - 1] + dp[i][j];
				sum[i][j] %= mod;
			}
			// System.out.println(Arrays.toString(dp[i]));
		}

		System.out.println(sum[N][3000]);
	}
}

// 1 2 3 4 5 6 7
//   2 3
//       4   6
//     3 4 5 6 7