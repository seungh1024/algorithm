package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_16194_카드구매하기2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i-1]+data[1];
		}
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j++) {

				dp[j] = Math.min(dp[j],data[i]+dp[j-i]);

			}
		}
		System.out.println(dp[N]);
	}
}
