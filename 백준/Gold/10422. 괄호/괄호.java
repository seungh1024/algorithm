import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		long mod = 1000000007;
		for (int i = 4; i <= 5000; i += 2) {
			for (int j = 2; j <= i; j += 2) {
				dp[i] += dp[j-2] * dp[i-j];
				dp[i] %= mod;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int L = Integer.parseInt(br.readLine());
			sb.append(dp[L]).append("\n");
		}

		System.out.println(sb);
		// (())
		// ()()
		//
		// (())()
		// ()(())
		// ()()()
		// (()())
		// ((()))
	}

}
