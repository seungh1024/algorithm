package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_3687_성냥개비 {
	public static void main(String[] args) throws IOException{
		long[] dp = new long[101];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;

		String[] data = {"1", "7", "4", "2", "0", "8"};
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				String num = "" + dp[i-j] + data[j-2];
				dp[i] = Math.min(Long.parseLong(num), dp[i]);
			}
		}

		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			sb.append(dp[N]).append(" ");

			StringBuilder max = new StringBuilder();
			int size = N/2;
			for (int i = 1; i < size; i++) {
				max.append("1");
			}
			if (N % 2 == 0) {
				sb.append(1).append(max);
			} else {
				sb.append(7).append(max);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
