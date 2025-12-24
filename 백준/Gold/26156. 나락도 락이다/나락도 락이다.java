

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mod = 1_000_000_007;
		int[] dp = new int[4];
		char[] data = br.readLine().toCharArray();

		long cnt = 1;
		for (char c : data) {
			switch(c) {
				case 'R' -> {
					dp[0] += cnt;
					dp[0] %= mod;
				}
				case 'O' -> {
					dp[1] += dp[0];
					dp[1] %= mod;
				}
				case 'C' -> {
					dp[2] += dp[1];
					dp[2] %= mod;
				}
				case 'K' -> {
					dp[3] += dp[2];
					dp[3] %= mod;
				}
			}
			cnt*=2;
			cnt%=mod;
		}

		System.out.println(dp[3]);

	}
}
