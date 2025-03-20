

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[T + 1];
		dp[0] = 1;

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			for (int t = T; t >= 0; t--) {
				for (int j = 1; j <= n; j++) {
					if (t - p * j >= 0) {
						dp[t] += dp[t - p * j];
					}
				}
			}
		}

		System.out.println(dp[T]);
	}
}
