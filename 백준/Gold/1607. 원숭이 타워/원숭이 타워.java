

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mod = 9901;
		int[] dp = new int[N + 1];
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = 2 * dp[i - 1] + 1;
			dp[i] %= mod;
		}

		int[] mk = new int[N + 1];
		mk[1] = 1;
		// mk[2] = 3;
		// mk[3] = 5;
		for (int i = 2; i <= N; i++) {
			int k = i - (int)Math.round(Math.sqrt(i * 2 + 1)) + 1;
			mk[i] = 2 * mk[k] + dp[i - k];
			mk[i] %= mod;
		}
		System.out.println(mk[N]);
	}
}

