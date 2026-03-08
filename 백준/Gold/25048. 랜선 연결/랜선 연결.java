

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		int[] B = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			A[i] = a;
			B[i] = b;
		}

		int M = Integer.parseInt(br.readLine());
		if (M == 1) {
			System.out.println(0);
			return;
		}
		long[][] dp = new long[N + 1][M+1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], Long.MAX_VALUE);
			dp[i][0] = 0;
		}
		dp[0][0] = 0;
		for (int i = 1; i <= N; i++) {
			int a = A[i];
			int b = B[i];

			for (int j = 0; j <= M; j++) {
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
				if(j-a <0) continue;

				if (j - a == 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - a] + b);
				} else {

					if(dp[i-1][j-a+1] == Long.MAX_VALUE) continue;
					// if (i == 3) {
					// 	System.out.println("j = "+j + ", a = "+a +", b = "+b);
					// }
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - a+1] + b);
				}

			}
			// System.out.println(Arrays.toString(dp[i]));
		}


		if (dp[N][M] == Long.MAX_VALUE) {
			dp[N][M] = -1;
		}
		System.out.println(dp[N][M]);

	}
}
