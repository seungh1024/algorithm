

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] dp = new int[90001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		st = new StringTokenizer(br.readLine());
		int[] data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 0;
		for (int i = 1; i <=N; i++) {
			for (int j = data[i]; j <= 90000; j++) {
				if (dp[j - data[i]] != Integer.MAX_VALUE) {

					dp[j] = Math.min(dp[j], dp[j - data[i]] + 1);
				}
			}
		}

		// System.out.println(dp[90000]);
		for (int i = 90000; i >= 0; i--) {
			if (dp[i] <= M && i % K == 0) {
				System.out.println(i);
				break;
			}
		}
	}

}
