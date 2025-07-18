

import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;
	public static int[] data;
	public static int[] two;
	public static int[] five;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			data = new int[N];
			two = new int[N+K];
			five = new int[N+K];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());

				int value = data[i];
				while (value % 2 == 0) {
					value/= 2;
					two[i]++;
				}
				while (value % 5 == 0) {
					value/=5;
					five[i]++;
				}
			}

			dp = new int[N][2];
			for (int i = 0; i < N; i++) {

				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			dp[0][0] = two[0];
			dp[0][1] = five[0];
			for (int i = 1; i < N; i++) {
				for (int j = 1; j <= K; j++) {
					if(i-j<0) break;
					// System.out.println("i = "+i +", j ="+j);
					dp[i][0] = Math.min(dp[i][0], dp[i-j][0] + two[i]);
					dp[i][1] = Math.min(dp[i][1], dp[i-j][1] + five[i]);
				}
				// System.out.println(Arrays.toString(dp[i]));
			}
			// System.out.println(Math.min(dp[N - 1][0], dp[N - 1][1]));
			sb.append(Math.min(dp[N - 1][0], dp[N - 1][1])).append("\n");
			
		}
		System.out.println(sb);


	}
}
