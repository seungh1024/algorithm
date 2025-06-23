

import java.io.*;
import java.util.*;

public class Main {
	public static int[] count;
	public static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		count = new int[N+1];

		list = new ArrayList<>();
		int idx = 1;
		while (idx <= N) {
		list.add(idx);
			idx *= 2;
		}

		int[] dp = new int[N + 1];
		dp[1] = 1;

		int mod = 1000000000;
		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0) {
				dp[i] = dp[i-1] + dp[i/2];
			} else {
				dp[i] = dp[i-1];
			}
			dp[i] %= mod;
		}

		System.out.println(dp[N]);

	}

}
