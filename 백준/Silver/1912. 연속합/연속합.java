

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(data[i], dp[i - 1] + data[i]);
			// dp[i] = Math.max(dp[i], data[i]);
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);

	}
}
