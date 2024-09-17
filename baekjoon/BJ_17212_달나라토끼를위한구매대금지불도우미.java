package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_17212_달나라토끼를위한구매대금지불도우미 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100010];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[5] = 1;
		dp[7] = 1;

		for (int i = 1; i <= N; i++) {
			dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
			dp[i + 2] = Math.min(dp[i + 2], dp[i] + 1);
			dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
			dp[i + 7] = Math.min(dp[i + 7], dp[i] + 1);
		}
		System.out.println(dp[N]);
	}
}
