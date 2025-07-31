

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// if (N <= 5) {
		// 	System.out.println(N);
		// 	return;
		// }

		int[] dp = new int[10001];
		for (int i = 1; i <= 10000; i++) {
			dp[i] = i;
		}
		int temp = 1;
		int[] facto = new int[10];
		for (int i = 2; i < 10; i++) {
			temp*=i;
			facto[i] = temp;
		}
		for (int i = 2; i <= 10000; i++) {
			for (int j = 2; j < 10; j++) {
				if (i == facto[j]) {
					dp[i] = Math.min(dp[i], dp[j]);
				}
			}

			for (int j = 1; j <= i; j++) {
				if (i * j <= 10000) {
					dp[i * j] = Math.min(dp[i * j], dp[j] + dp[i]);
				}
				if (i + j <= 10000) {
					dp[i + j] = Math.min(dp[i + j], dp[j] + dp[i]);
				}
			}
		}
		System.out.println(dp[N]);
	}
}
