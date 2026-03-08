

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
		long[] dp = new long[M+1];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			int a = A[i];
			int b = B[i];
			if(a > M) continue;
			for (int j = M; j > a; j--) {
				if(j-a+1>=M || dp[j-a+1] == Long.MAX_VALUE) continue;
				dp[j] = Math.min(dp[j], dp[j - a + 1] + b);
			}
			dp[a] = Math.min(dp[a], b);
			// System.out.println(Arrays.toString(dp[i]));
		}

		long result = dp[M];
		if (dp[M] == Long.MAX_VALUE) {
			result = -1;
		}

		System.out.println(result);
	}
}
