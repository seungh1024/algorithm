

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[] data;
	public static char[] ch = {'R', 'O', 'C', 'K'};
	public static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		long mod = 1000000007;

		long[] dp = new long[4];
		char[] input = br.readLine().toCharArray();
		data = new char[N + 1];
		int idx = 1;
		for (char c : input) {
			data[idx++] = c;
		}

		long[] value = new long[N + 1];
		value[1] = 1;
		for (int i = 2; i <= N; i++) {
			value[i] = value[i - 1] * 2 % mod;
		}

		for (int i = N; i > 0; i--) {
			if (data[i] == 'K') {
				dp[3]++;
			} else if (data[i] == 'C') {
				dp[2] = (dp[2] + dp[3]) % mod;
			} else if (data[i] == 'O') {
				dp[1] = (dp[1] + dp[2]) % mod;
			} else if (data[i] == 'R') {
				dp[0] = (dp[0] + value[i] * dp[1] % mod) % mod;
			}
		}
		System.out.println(dp[0]);
		
	}

}