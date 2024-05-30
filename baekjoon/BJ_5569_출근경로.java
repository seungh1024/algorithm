package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_5569_출근경로 {
	public static int w,h;
	public static int[][][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		dp = new int[w+1][h+1][2]; // 0 아래, 1 오른쪽


		for (int i = 1; i <= w; i++) {
			dp[i][1][0] = 1;
		}
		for (int i = 1; i <= h; i ++) {
			dp[1][i][1] = 1;
		}


		int mod = 100000;
		for (int i = 2; i <= w; i++) {
			for (int j = 2; j <= h; j++) {
				dp[i][j][0] += dp[i-1][j][0] + dp[i-2][j][1];
				dp[i][j][0] %= mod;
				dp[i][j][1] += dp[i][j-1][1] + dp[i][j-2][0];
				dp[i][j][1] %= mod;
			}
		}
		dp[w][h][0] += dp[w-1][h][1];
		dp[w][h][0] %= mod;
		dp[w][h][1] += dp[w][h-1][0];
		dp[w][h][1] %= mod;


		System.out.println((dp[w][h][0]+dp[w][h][1])%mod);
	}
}
