

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			stack.push(new int[]{u, v});
		}

		int[] dp = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dp[i] = i;
		}
		while(!stack.isEmpty()) {
			int[] now = stack.pop();
			int from = now[0];
			int to = now[1];

			dp[from] = dp[to];
		}
		// System.out.println(Arrays.toString(dp));

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(dp[i]).append(" ");
		}
		System.out.println(sb);
	}
}
