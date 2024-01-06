package algo_202401;

import java.util.*;

public class P_멀리뛰기 {
	public static void main(String[] args) {
		P_멀리뛰기 test = new P_멀리뛰기();
		int n = 4;
		int result = 5;
		long answer = test.solution(n);
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public long solution(int n) {
		int mod = 1234567;

		int[] dp = new int[n+1];
		if(n == 1) {
			return 1;
		}

		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++){
			dp[i] = dp[i-1]+dp[i-2];
			dp[i] %= mod;
		}

		return dp[n];
	}
}
