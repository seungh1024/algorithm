

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] count = {A, B, C, D};
		int[] cost = {1, 5, 10, 25};
		int[][] dp = new int[X+1][5];

		for (int i = 1; i <= X; i++) {
			dp[i][4] = -1;
		}

		for (int i = 1; i <= X; i++) {
			dp[i][4] = 0;
			for (int j = 0; j < 4; j++) {
				if(i-cost[j] < 0 || dp[i-cost[j]][4] == -1) continue;

				if (dp[i - cost[j]][j] + 1 <= count[j] && dp[i - cost[j]][4] + 1 > dp[i][4]) {
					int sum = 0;
					for (int k = 0; k < 4; k++) {
						if (k == j) {
							dp[i][k] = dp[i - cost[j]][k] + 1;
						} else {
							dp[i][k] = dp[i - cost[j]][k];
						}
						sum += dp[i][k];
					}
					dp[i][4] = sum;
				}
			}
			if (dp[i][4] == 0) {
				dp[i][4] = -1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(dp[X][i]).append(" ");
		}
		System.out.println(sb);

	}

}
