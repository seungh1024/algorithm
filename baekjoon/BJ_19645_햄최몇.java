package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_19645_햄최몇 {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;

		int[] count = new int[51];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			count[data[i]] ++;
			sum+= data[i];
		}

		boolean[][] dp = new boolean[sum + 1][sum + 1];
		dp[0][0] = true;

		for(int k = 0; k < N; k++){
			for (int i = sum; i >= 0; i--) {
				for (int j = sum; j >= 0; j--) {
					if (i - data[k] >= 0) {
						dp[i][j] |= dp[i-data[k]][j];
					}
					if (j - data[k] >= 0) {
						dp[i][j] |= dp[i][j - data[k]];
					}

				}
			}
		}

		int result = 0;

		for (int i = 0; i <= sum; i++) {
			for (int j = 0; j <= sum; j++) {
				int value = sum-i-j;
				// System.out.println("i = "+i + ", j = "+j + ", value = "+value +", dp = "+dp[i][j]);
				if (dp[i][j] && value <= i && value <= j) {
					result = Math.max(result, value);
				}
			}
		}

		System.out.println(result);

	}
}
