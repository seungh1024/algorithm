

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static int[] data;
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[90001];

		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			int v = data[i];
			for (int j = v; j <=90000; j++) {
				if (dp[j - v] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - v] + 1);
				}
			}
		}


		int result = 0;

		for (int j = 90000; j >= 0; j--) {
			if (dp[j] <= M && j % K == 0) {
				result = Math.max(result, j);
				break;
			}
		}


		System.out.println(result);
	}

}
