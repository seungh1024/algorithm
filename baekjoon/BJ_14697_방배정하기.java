package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_14697_방배정하기 {
	public static int A,B,C,N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[] dp = new int[N+1];
		int[] data = {A,B,C};

		dp[0] = 1;
		for(int d : data){
			for (int i = d; i <= N; i++) {
				dp[i] = dp[i] + dp[i-d];
			}
		}
		// System.out.println(Arrays.toString(dp));
		if (dp[N] > 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
