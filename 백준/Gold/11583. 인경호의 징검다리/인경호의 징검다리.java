

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] data = new int[N + 1];
			int[] two = new int[N + 1];
			int[] five = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
				int a = 0;
				int num = data[i];
				while (num % 2 == 0) {
					a++;
					num /= 2;
				}
				two[i] = a;
				int b = 0;
				num = data[i];
				while (num % 5 == 0) {
					b++;
					num /= 5;
				}
				five[i] = b;
			}

			// System.out.println(Arrays.toString(two));
			// System.out.println(Arrays.toString(five));
			int[][] dp = new int[N + 1][2];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			dp[1][0] = two[1];
			dp[1][1] = five[1];

			for (int i = 1; i <= N; i++) {
				if(dp[i][0] == Integer.MAX_VALUE || dp[i][1] == Integer.MAX_VALUE)continue;
				for (int k = 1; k <= K; k++) {
					if(i+k >N)continue;
					// int plus = two[i + k] + five[i + k];

					dp[i + k][0] = Math.min(dp[i + k][0], dp[i][0]+two[i+k]);
					dp[i + k][1] = Math.min(dp[i + k][1], dp[i][1]+five[i+k]);
				}
			}
			// for (int i = 1; i <= N; i++) {
			// 	System.out.println(Arrays.toString(dp[i]));
			// }

			sb.append(Math.min(dp[N][0], dp[N][1])).append("\n");
		}
		System.out.println(sb);
	}
}
