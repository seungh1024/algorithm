

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] data = br.readLine().toCharArray();
		long[] dp = new long[N + 1];
		dp[0] = 1;
		long mod = 1000000007;
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i - 1]*2;
			dp[i] %= mod;
		}
		long o = 0;
		long c = 0;
		long k = 0;

		long result = 0;
		for (int i = N-1; i >= 0; i--) {
			char d = data[i];
			if (d == 'R') {
				result = ((result + dp[i] * o % mod) % mod);

				// System.out.println("cnt = "+cnt +", dp[i] = "+dp[i]);
			} else if (d == 'O') {
				o += c;
				o %= mod;
			} else if (d == 'C') {
				c += k;
				c %= mod;
			} else if (d == 'K') {
				k++;
			}
			// System.out.println("i = " + i + ", r = " + r + ", o = " + o + ", c = " + c + ", k = " + k);
		}
		System.out.println(result);
	}
}
