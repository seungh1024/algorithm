package algo_202405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2616_소형기관차 {
	public static int N;
	public static int[] data;
	public static int[] section;
	public static int M;
	public static int[][] dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		section = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			section[i] = section[i-1]+data[i];
		}

		M = Integer.parseInt(br.readLine());
		dp = new int[4][N+1];

		for (int i = 1; i <= 3; i++) {
			for (int j = M; j <= N; j++) {
				dp[i][j] = Math.max(dp[i][j-1],Math.max(dp[i][j-M],dp[i-1][j-M]+section[j]-section[j-M]));
			}
		}
		System.out.println(dp[3][N]);
		// for (int i = 1; i <= 3; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }

	}
}
