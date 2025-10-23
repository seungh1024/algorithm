

import java.io.*;
import java.util.*;

public class Main {
	public static char[] arr;
	public static int N;
	public static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = br.readLine().toCharArray();
		N = arr.length;
		dp = new long[31][31];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i],-1);
			dp[i][i] = 1;
		}
		find(0, N - 1);
		System.out.println(dp[0][N-1]);
	}

	public static long find(int l, int r) {
		if (l >= r) {
			return 1;
		}
		if (dp[l][r] != -1) {
			return dp[l][r];
		}

		long cnt = 0;
		for (int i = l; i <= r; i++) {
			for (int j = i; j <= r; j++) {
				if (arr[i] == arr[j]) {
					cnt++;

					if (j - i <= 1) {
						continue;
					}
					cnt += find(i + 1, j - 1);
				}
			}
		}

		return dp[l][r] = cnt;
	}

}
