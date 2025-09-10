

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long mod = 1_000_000_007;
		long[][] dp = new long[N+1][2]; // 인덱스 1 -> 높이 2 선인장 넘은 경우

		dp[0][0] = 1;
		for(int i = 0; i < N; i++){
			if (i + 1 <= N) {
				dp[i+1][0] += dp[i][0];
				dp[i+1][0]%=mod;
				dp[i+1][1] += dp[i][1];
				dp[i+1][1]%=mod;
			}
			if(i+2 <= N){
				dp[i+2][0] += dp[i][0];
				dp[i+2][1] += (dp[i][1]*2%mod+dp[i][0])%mod; // 1,2
				dp[i + 2][0] %= mod;
				dp[i + 2][1] %= mod;
			}
			if(i+3 <= N){
				dp[i+3][0] += dp[i][0]; // 11
				dp[i+3][1] += (dp[i][1]*3%mod+dp[i][0]*2%mod)%mod; // 11, 12, 21
				dp[i + 3][0] %= mod;
				dp[i + 3][1] %= mod;
			}
			// System.out.println("i = " + i);
			// System.out.println(Arrays.toString(dp[i]));
		}

		System.out.println(dp[N][1]);
	}
}
