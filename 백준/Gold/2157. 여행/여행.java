
import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int[][] max = new int[N+1][N+1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (from < to) {
				max[from][to] = Math.max(max[from][to], cost);
			}
		}

		int[][] dp = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[1][1] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (max[i][j] > 0) {
					for (int m = 1; m < M; m++) {
						if (dp[i][m] >=0) {
							dp[j][m + 1] = Math.max(dp[j][m + 1], dp[i][m] + max[i][j]);
							// System.out.println("i = "+ i +", j = "+j + ", m = "+m +", dp = "+dp[j][m+1]);
							// System.out.println(dp[2][2]);
						}
					}
				}
			}
		}

		int result = 0;
		for (int i = 2; i <= M; i++) {
			result = Math.max(result, dp[N][i]);
		}
		System.out.println(result);
	}


	public static class Data{
		int to;
		int cost;
		int m;

		public Data(int to, int cost, int m) {
			this.to = to;
			this.cost = cost;
			this.m = m;
		}

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", cost=" + cost +
				", m=" + m +
				'}';
		}
	}

}

// 3 3 5
// 1 3 1
// 1 2 1
// 2 3 2
// 3 1 4
// 3 1 100