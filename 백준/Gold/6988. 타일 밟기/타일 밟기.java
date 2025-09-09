

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N+1];
		int[] index = new int[2000000];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			index[data[i]] = i;
		}
		long[][] dp = new long[N + 1][N+1];

		long result = 0;
		for (int i = 1; i <= N; i++) {
			int mid = data[i];
			for (int j = i + 1; j <= N; j++) {
				int end = data[j];
				int jump = end-mid;
				int last = mid-jump;
				int lastIdx = 0;
				if (last >= 0) {
					lastIdx = index[last];
				}

				if (lastIdx == 0) {
					dp[i][j] = Math.max(dp[i][j], mid + end);
				} else {
					dp[i][j] = Math.max(dp[i][j], dp[lastIdx][i] + data[j]);
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		// System.out.println(dp[4][5]);
		// System.out.println(dp[2][1]);

		System.out.println(result);
	}
}
