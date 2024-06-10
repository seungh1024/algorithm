package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_11568_민균이의계략 {
	public static int N;
	public static int[] data;
	public static int[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N];
		dp[0] = 1;
		int max = 1;
		for (int i = 1; i < N; i++) {
			int last = 0;
			for (int j = 0; j < i; j++) {
				if (data[j] < data[i]) {
					last = Math.max(last,dp[j]);
				}
			}

			dp[i] = last+1;

			max = Math.max(max, dp[i]);
		}

		System.out.println(max);

	}
}
