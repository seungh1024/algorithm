import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][10];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				int idx = Integer.parseInt(st.nextToken());
				dp[i][idx] ++;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < 10; j++) {
				if(dp[i][j] == 0) continue;
				for (int k = 1; k < 10; k++) {
					if (j != k && dp[i-1][k] == i) {
						dp[i][j] = dp[i-1][k]+1;
						break;
					}
				}
			}
		}

		boolean flag = false;
		for (int i = 1; i < 10; i++) {
			if (dp[N - 1][i] == N) {
				flag = true;
				break;
			}
		}

		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }

		if (!flag) {
			System.out.println(-1);
			return;
		}

		Stack<Integer> stack = new Stack<>();
		int last = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 1; j < 10; j++) {
				if (dp[i][j] == i + 1 && last != j) {
					stack.push(j);
					last = j;
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append("\n");
		}
		System.out.println(sb);

	}
}