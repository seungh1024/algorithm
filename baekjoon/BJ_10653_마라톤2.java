package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_10653_마라톤2 {
	public static int N, K;
	public static List<int[]> data;
	public static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			data.add(new int[] {x, y});
		}

		dp = new int[N][K+1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i],-1);
		}
		dp[0][0] = 0;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				if(i-j <= 0) continue;

				int min = Integer.MAX_VALUE;
				for (int k = 0; k <= j; k++) {
					int value = dp[i-k-1][j-k];
					if(value == -1) continue;
					int[] last = data.get(i-k-1);
					int[] now = data.get(i);
					min = Math.min(min, value+Math.abs(last[0] - now[0]) + Math.abs(last[1] - now[1]));
				}
				dp[i][j] = min;
			}
		}

		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }

		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			result = Math.min(result, dp[N - 1][i]);
		}

		System.out.println(result);

	}
}
