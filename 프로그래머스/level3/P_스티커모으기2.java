package algo_202403;

import java.util.*;

public class P_스티커모으기2 {
	public static int N;
	public static int[] dp;

	public int solution(int sticker[]) {
		int answer = 0;

		N = sticker.length;
		if(N == 1){
			return sticker[0];
		}

		dp = new int[N];
		// dp[0] = sticker[N-1];
		dp[0] = sticker[0];

		for(int i = 1; i < N-1; i++){
			if(i>=2){
				dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
			}else{
				dp[i] = Math.max(dp[i-1],sticker[i]);
			}

		}
		int a = dp[N-2];
		// System.out.println(Arrays.toString(dp));

		dp = new int[N];
		for(int i = 1; i < N; i++){
			if(i>=2){
				dp[i] = Math.max(dp[i-2]+sticker[i],dp[i-1]);
			}else{
				dp[i] = Math.max(dp[i-1],sticker[i]);
			}

		}
		int b = dp[N-1];


		// System.out.println(Arrays.toString(dp));
		answer = Math.max(a,b);
		return answer;
	}
}
