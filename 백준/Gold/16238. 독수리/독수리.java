

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[][] dp;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i],-1);
		}

		int cost = find(0, 0);
		System.out.println(cost);


	}

	public static int find(int idx,int t) {
		if (idx >= N) {
			return 0;
		}

		if (dp[idx][t] >-1) {
			return dp[idx][t];
		}

		int max = 0;
		max = Math.max(max, find(idx + 1, t));
		
		if (data[idx] - t > 0) {

			max = Math.max(max, find(idx + 1, t + 1)+data[idx]-t);
		}


		return dp[idx][t] = max;
	}
}
