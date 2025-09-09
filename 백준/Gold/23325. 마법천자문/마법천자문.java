

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int N = input.length;
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		if (input[0] == '+') {
			dp[0] = 10;
			if (N > 1 && input[1] == '-') {
				dp[1] = 11;
			}
		} else {
			dp[0] = 1;
		}

		for (int i = 1; i < N-1; i++) {
			if(dp[i-1] == Integer.MIN_VALUE) continue;

			if (input[i] == '+') {
				if (input[i + 1] == '+') {
					dp[i + 1] = Math.max(dp[i + 1], dp[i - 1] + 10);
					if (i + 2 < N && input[i + 2] == '-') {
						dp[i + 2] = Math.max(dp[i + 2], dp[i - 1] + 11);
					}
				} else {
					dp[i + 1] = Math.max(dp[i + 1], dp[i - 1] + 1);
				}

			} else {
				// System.out.println("i = "+i +", data[i+2] = "+input[i+2]);
				if (input[i + 1] == '+') {
					dp[i + 1] = Math.max(dp[i + 1], dp[i - 1] - 10);
					if (i + 2 < N && input[i + 2] == '-') {
						// System.out.println("??");
						dp[i + 2] = Math.max(dp[i + 2], dp[i - 1] - 11);
					}
				} else {
					dp[i + 1] = Math.max(dp[i + 1], dp[i - 1] - 1);
				}
			}
		}
		System.out.println(dp[N-1]);
		// System.out.println(Arrays.toString(dp));
	}

}
