

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[10001][5001];
		int[] data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			if (data[i] >= 5000) {
				System.out.println(0);
				return;
			}
		}
		if (data[1] > 0 || data[N] > 0) {
			System.out.println(0);
			return;
		}

		int mod = 1_000_000_007;
		dp[1][0] = 1;

		for (int i = 2; i <= N; i++) {
			if (data[i] == -1) {
				dp[i][0] = (dp[i-1][0]+dp[i-1][1])%mod;
				for (int j = 1; j < 5000; j++) {
					dp[i][j] = ((dp[i-1][j-1]+dp[i-1][j])%mod+dp[i-1][j+1])%mod;
				}
			} else {
				if (data[i] == 0) {
					dp[i][0] = (dp[i-1][0]+dp[i-1][1])%mod;
				} else {
					dp[i][data[i]] = ((dp[i-1][data[i]-1]+dp[i-1][data[i]])%mod +dp[i-1][data[i]+1])%mod;
				}
			}
		}

		System.out.println(dp[N][0]);
	}
}
