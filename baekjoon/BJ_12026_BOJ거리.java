package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_12026_BOJ거리 {
	public static int N;
	public static char[] data;
	public static int[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new char[N];
		dp = new int[N];
		data = br.readLine().toCharArray();

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			char target;
			if(data[i] == 'B'){
				target = 'O';
			} else if (data[i] == 'O') {
				target = 'J';
			} else {
				target = 'B';
			}
			for (int j = i + 1; j < N; j++) {
				if(data[j] == target){
					dp[j] = Math.min(dp[j],(j-i)*(j-i)+dp[i]);
					// dp[j] += dp[i];
					// System.out.println("dp[j] = "+dp[j] + ", dp[i] = "+dp[i]);
					// System.out.println("j = "+j +", i = "+i );
				}
			}
		}
		// System.out.println(Arrays.toString(dp));
		if (dp[N - 1] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N-1]);
		}
	}
}
