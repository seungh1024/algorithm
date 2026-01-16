

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] dp = new long[18][18];
		dp[0][0] = 1;
		for (int i = 1; i < 18; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = 1;
					for (long k = 1; k <= i; k++) {
						dp[i][j] *= k;
					}
				} else {
					dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1];
				}
			}
		}

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			sb.append(num).append(" ").append(dp[N][K]).append("\n");
		}

		System.out.println(sb);

	}
}
