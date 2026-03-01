

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] data = new int[M + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			for (int j = 1; j <= M; j++) {
				data[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[M + 1][N + 1];
		int[][] check = new int[M + 1][N + 1];

		for (int i = 1; i <= M; i++) { // 기업
			for (int j = 1; j <= N; j++) { // 투자금액
				int v = data[i][j];
				if (dp[i - 1][j] < v) { // 이전 기업에서의 j만큼 투자한 것보다 v가 더 크면 현재 값은 v로
					dp[i][j] = v;
					check[i][j] = j;
				} else {
					dp[i][j] = dp[i-1][j];
				}

				// k라는 금액을 써서 이전 값에서 더했을 때 더 큰 값이 있는지 확인
				for (int k = 1; k < j; k++) {
					int c = data[i][k];
					if (dp[i][j] < dp[i - 1][j - k] + c) {
						dp[i][j] = dp[i - 1][j - k] + c;
						check[i][j] = k;
					}
				}
			}
		}

		Stack<Integer> stack = new Stack<>();
		int v = dp[M][N];
		for (int i = M; i > 0; i--) {
			int target = 0;
			for (int j = 1; j <= N; j++) {
				if (dp[i][j] == v) {
					target = check[i][j];
					break;
				}
			}
			v -= data[i][target];
			stack.push(target);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dp[M][N]).append("\n");
		
		while (!stack.isEmpty()) {
			int money = stack.pop();
			sb.append(money).append(" ");
		}
		System.out.println(sb);
	}
}
