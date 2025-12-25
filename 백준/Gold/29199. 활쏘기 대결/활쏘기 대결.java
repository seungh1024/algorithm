

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static long[] data;
	public static long[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new long[N+1];
		sum = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Long.parseLong(st.nextToken());
			sum[i] = sum[i - 1] + data[i];
		}

		long[] dp = new long[N + 1];
		dp[1] = Math.max(0, sum[1]);
		for (int i = 2; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], sum[i] - dp[i - 1]);
		}
		System.out.println(dp[N]);
	}

}
