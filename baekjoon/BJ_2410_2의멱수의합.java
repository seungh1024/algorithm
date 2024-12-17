package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_2410_2의멱수의합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i *= 2) {
			list.add(i);
		}

		int[] dp = new int[N+1];
		dp[0] = 1;
		int mod = 1000000000;
		for (int num : list) {
			for (int i = 0; i <= N; i++) {
				if (i - num >= 0) {
					dp[i] += dp[i - num];
					dp[i] %= mod;
				}
			}
		}

		System.out.println(dp[N]);
	}
}
