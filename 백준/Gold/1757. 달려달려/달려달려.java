import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] data;
	public static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[N][M+1][2];

		dp[0][1][1] = data[0];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <=M; j++) {
				if (j > 0) {
					if (j+1 <= M) {
						dp[i][j][0] = Math.max(dp[i][j][0], Math.max(dp[i - 1][j + 1][1], dp[i - 1][j + 1][0]));
					}
					if (j - 1 == 0) {
						dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][0][0] + data[i]);
					}
					dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j - 1][1] + data[i]);
				} else {
					// System.out.println("i = "+i +", j = "+j);
					dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0]);
					if (j + 1 <= M) {
						dp[i][j][0] = Math.max(dp[i][j][0], Math.max(dp[i - 1][j + 1][1], dp[i - 1][j + 1][0]));
					}
				}
			}
		}

		System.out.println(dp[N-1][0][0]);
		// System.out.println(dp[N-1][0][1]);
	}

}