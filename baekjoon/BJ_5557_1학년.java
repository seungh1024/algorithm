package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_5557_1학년 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		long[][] dp = new long[N][21];
		dp[0][data[0]] = 1;
		for (int i = 1; i < N-1; i++) {
			for (int j = 0; j < 21; j++) {
				if(dp[i-1][j] == 0)continue;
				int plus = j+data[i];
				int minus = j-data[i];
				if (plus >= 0 && plus <= 20) {
					dp[i][plus] += dp[i-1][j];
				}
				if (minus >= 0 && minus <= 20) {
					dp[i][minus] += dp[i-1][j];
				}
			}
			// System.out.println(Arrays.toString(dp[i]));
		}

		System.out.println(dp[N-2][data[N-1]]);
	}

}
