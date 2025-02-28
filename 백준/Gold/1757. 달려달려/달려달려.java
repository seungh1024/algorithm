import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[N+1][M+1];
		dp[1][1] = data[1];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = dp[i - 1][0];
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i - 1][j - 1] + data[i]);

			}

			int max = 0;
			for (int j = 1; j <= M; j++) {
				if (i - j >= 0) {
					max = Math.max(max, dp[i - j][j]);
				}
			}
			dp[i][0] = Math.max(dp[i][0], max);
		}

		System.out.println(dp[N][0]);

		// for (int i = 1; i <= N; i++) {
		//
		// 	System.out.println(Arrays.toString(dp[i]));
		// }
	}
}