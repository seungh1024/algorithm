

import java.io.*;
import java.util.*;

public class Main {
	public static char[] data;
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine().toCharArray();
		int N= data.length;
		dp = new int[N];
		Arrays.fill(dp, Integer.MIN_VALUE);
		if (data[0] == '+') {
			dp[0] = 10;
			if (N > 1 && data[1] == '-') {
				dp[1] = 11;
			}
		} else {
			dp[0] = 1;
		}

		for (int i = 0; i < N; i++) {
			if(dp[i] == Integer.MIN_VALUE || i+2 >= N) continue;
			int num = 1;
			if (i + 1 < N && data[i + 1] == '-') {
				num *= -1;
			}

			if (i + 2 < N) {
				int value = 0;
				if (data[i + 2] == '+') {
					value = 10;
				} else {
					value = 1;
				}
				dp[i + 2] = Math.max(dp[i + 2], dp[i] + value * num);
			}
			if (i + 3 < N) {
				int value = 0;
				if (data[i + 2] == '+' && data[i + 3] == '-') {
					value = 11;
					dp[i + 3] = Math.max(dp[i + 3], dp[i] + value * num);
				}
			}
			// System.out.println("i = "+ i + ", " +Arrays.toString(dp));
			// System.out.println("num = "+num);
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[N-1]);
	}


}
