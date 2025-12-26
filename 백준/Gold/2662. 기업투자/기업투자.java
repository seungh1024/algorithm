

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] data = new int[M+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= M; j++) {
				data[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[M+1][N + 1];
		int[][] check = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				int v = data[i][j];
				if (dp[i - 1][j] < v) {
					check[i][j] = j;
				}
				dp[i][j] = Math.max(dp[i - 1][j], v);
				for (int k = 1; k < j; k++) {
					int now = data[i][k];
					if (dp[i][j] < dp[i - 1][j - k] + now) {
						dp[i][j] = dp[i-1][j-k]+now;
						check[i][j] = k;
					}
				}
			}
			// System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[M][N]);

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		// System.out.println("====");
		// for (int i = 1; i <= M; i++) {
		// 	System.out.println(Arrays.toString(check[i]));
		// }

		int v = dp[M][N];
		for (int i = M; i > 0; i--) {
			int target = 0;
			for (int j = N; j > 0; j--) {
				if (dp[i][j] == v) {
					target = check[i][j];
					break;
				}
			}
			v-= data[i][target];
			stack.push(target);
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
}
