

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] data = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= K; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		int[][] dp = new int[N + 1][K + 1];
		Data[] M = new Data[2];
		M[0] = new Data(0, 0);
		M[1] = new Data(0, 0);
		for (int i = 1; i <= N; i++) {
			Data first = M[0];
			Data second = M[1];
			for (int j = 1; j <= K; j++) {
				if (first.idx == j) {
					dp[i][j] = second.cost + data[i][j];
				} else {
					dp[i][j] = first.cost + data[i][j];
				}
				if (dp[i][j] >= M[0].cost) {
					M[1] = M[0];
					M[0] = new Data(j, dp[i][j]);
				} else if (dp[i][j] >= M[1].cost) {
					M[1] = new Data(j, dp[i][j]);
				}
				result = Math.max(result, dp[i][j]);
			}
			// System.out.println(Arrays.toString(dp[i]));
			// System.out.println(Arrays.toString(M));
		}
		System.out.println(result);
	}

	public static class Data{
		int idx;
		int cost;

		@Override
		public String toString() {
			return "Data{" +
				"idx=" + idx +
				", cost=" + cost +
				'}';
		}

		public Data(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
