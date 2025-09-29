

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] height = new int[N + 1];
		int[] speed = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			height[i] = h;
			speed[i] = s;
		}

		int[] dp = new int[H + 1];

		dp[0] = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int h = height[i];
			int s = speed[i];
			for (int j = H; j >= h; j--) {
				int min = Integer.MAX_VALUE;
				if (dp[j - h] > 0) {
				}
				min = Math.min(s, dp[j - h]);
				// if (dp[j] == 0) {
				//
				// 	dp[j] = Math.min(min, s);
				// } else {
				//
				//
				// 	dp[j] = Math.min(dp[j], Math.min(min, s));
				// }
				dp[j] = Math.max(dp[j], min);
			}
			result = Math.max(result, dp[H]);
		}

		System.out.println(result);

	}
}
