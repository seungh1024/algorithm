import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			int v = Integer.parseInt(br.readLine());
			visited[v] = true;
		}

		int[][] dp = new int[N + 1][1001];
		for (int i = 2; i <= N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		if (!visited[2]) {
			dp[2][1] = 1;
		}

		for (int i = 2; i <= N; i++) {
			if(visited[i]) continue;
			for (int j = 1; j <= 1000; j++) {
				if(dp[i][j] == Integer.MAX_VALUE) continue;

				if (i + j + 1 <= N && !visited[i + j + 1]) {
					dp[i + j + 1][j + 1] = Math.min(dp[i + j + 1][j + 1], dp[i][j] + 1);
				}
				if (i + j <= N && !visited[i + j]) {
					dp[i + j][j] = Math.min(dp[i + j][j], dp[i][j] + 1);
				}
				if (j - 1 > 0 && i + j - 1 <= N && !visited[i + j - 1]) {
					dp[i + j - 1][j - 1] = Math.min(dp[i + j - 1][j - 1], dp[i][j] + 1);
				}
			}
		}

		int result = Integer.MAX_VALUE;
		for (int j = 1; j <= 1000; j++) {
			result = Math.min(result, dp[N][j]);
		}
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}