import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] data;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new int[N + 1];
		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}


		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + data[i]);
				}
			}
			int max = 0;
			for (int j = 1; j <= M; j++) {
				if (i - j >=0) {
					max = Math.max(max, dp[i - j][j]);
				}
			}
			dp[i][0] = Math.max(dp[i][0], max);
		}

		System.out.println(dp[N][0]);

		// for (int i = 0; i <= N; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }
	}


}