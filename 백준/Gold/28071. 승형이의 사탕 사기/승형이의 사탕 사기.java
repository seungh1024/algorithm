

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[90001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= 90000; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = count[j];
				if (i - cnt >= 0 && dp[i - cnt] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - cnt] + 1);
				}
			}
		}


		int result = 0;
		for (int i = 90000; i >= 0; i--) {
			if (i%K == 0 && dp[i] <= M) {
				result = i;
				break;
			}
		}
		System.out.println(result);


	}
}
